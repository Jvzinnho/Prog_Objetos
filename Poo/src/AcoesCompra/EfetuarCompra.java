package AcoesCompra;

import Compra.Compra;
import Compra.ItemCompra;
import Produto.Produto;
import Cliente.Cliente;
import Cliente.ClienteFisico;
import Cliente.ClienteJuridico;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.DecimalFormat;

public class EfetuarCompra {
    private static int proximoIdentificador = 1;

    public static void escolhaOpcao(List<Compra> compras, List<Cliente> clientes, List<Produto> produtos) {
        String[] options = {"Cliente Físico", "Cliente Jurídico"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Escolha o tipo do cliente:",
                "Tipo de cliente",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == 0) {
            // Cliente físico
            verificarCpf(clientes, compras, produtos);
        } else if (choice == 1) {
            // Cliente Jurídico
            verificaCnpj(clientes, compras, produtos);
        } else {
            // Usuário cancelou
            JOptionPane.showMessageDialog(null, "Operação cancelada");
        }
    }

    private static void verificarCpf(List<Cliente> clientes, List<Compra> compras, List<Produto> produtos) {
        String cpf = JOptionPane.showInputDialog("Digite o CPF:");

        for (Cliente cliente : clientes) {
            if (cliente instanceof ClienteFisico && ((ClienteFisico) cliente).getCPF().equals(cpf)) {
                // Cliente encontrado, criar e adicionar uma compra
                Compra compra = criarCompra(cliente, produtos);
                compras.add(compra);
                return;  // Saímos do método após a compra ser adicionada
            }
        }

        JOptionPane.showMessageDialog(null, "CPF não encontrado");
    }

    private static void verificaCnpj(List<Cliente> clientes, List<Compra> compras, List<Produto> produtos) {
        String cnpj = JOptionPane.showInputDialog("Digite o CNPJ:");

        for (Cliente cliente : clientes) {
            if (cliente instanceof ClienteJuridico && ((ClienteJuridico) cliente).getCNPJ().equals(cnpj)) {
                // Cliente encontrado, criar e adicionar uma compra
                Compra compra = criarCompra(cliente, produtos);
                compras.add(compra);
                return;  // Saímos do método após a compra ser adicionada
            }
        }

        JOptionPane.showMessageDialog(null, "CNPJ não encontrado");
    }

    private static Compra criarCompra(Cliente cliente, List<Produto> produtos) {
        int identificador = proximoIdentificador++;
        Date data = new Date();

        // Criar uma lista de itens de compra
        List<ItemCompra> itensCompra = criarItensCompra(produtos);

        // Calcular o valor total da compra
        double valorTotal = calcularValorTotal(itensCompra);

        // Solicitar o total pago (você pode implementar o método solicitarTotalPago)
        double totalPago = solicitarTotalPago(valorTotal);

        // Mostrar mensagem de compra realizada
        exibirMensagemCompraRealizada(valorTotal);

        if (cliente instanceof ClienteFisico) {
            return new Compra(identificador, data, valorTotal, ((ClienteFisico) cliente).getCpfCnpj(), totalPago, itensCompra);
        } else if (cliente instanceof ClienteJuridico) {
            return new Compra(identificador, data, valorTotal, ((ClienteJuridico) cliente).getCpfCnpj(), totalPago, itensCompra);
        } else {
            return null;
        }
    }

    private static double calcularValorTotal(List<ItemCompra> itensCompra) {
        return itensCompra.stream().mapToDouble(ItemCompra::getValorTotalItem).sum();
    }

    private static List<ItemCompra> criarItensCompra(List<Produto> produtos) {
        List<ItemCompra> itensCompra = new ArrayList<>();

        while (true) {
            JPanel panel = new JPanel(new GridLayout(0, 2));
            panel.setBorder(new EmptyBorder(10, 10, 10, 10));

            JComboBox<ProdutoComboItem> produtoComboBox = criarProdutoComboBox(produtos);
            JTextField quantidadeField = new JTextField(10);
            JLabel precoLabel = new JLabel(); // Adiciona um JLabel para exibir o preço

            // Adiciona um ouvinte de alteração de seleção para atualizar o preço
            produtoComboBox.addActionListener(e -> {
                ProdutoComboItem selectedItem = (ProdutoComboItem) produtoComboBox.getSelectedItem();
                if (selectedItem != null) {
                    precoLabel.setText("Preço: R$ " + selectedItem.getPrecoUnitario());
                }
            });

            addField(panel, "Selecione o produto: ", "", produtoComboBox);
            addField(panel, "Digite a quantidade: ", "", quantidadeField);

            JOptionPane.showMessageDialog(null, "Clique em cancelar para finalizar a compra.");



            int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar Item à Compra",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                ProdutoComboItem produtoComboItem = (ProdutoComboItem) produtoComboBox.getSelectedItem();
                Produto produtoSelecionado = produtoComboItem.getProduto();
                double precoUnitario = produtoComboItem.getPrecoUnitario();

                int quantidade = Integer.parseInt(quantidadeField.getText());
                double valorTotalItem = quantidade * precoUnitario;

                ItemCompra itemCompra = new ItemCompra(produtoSelecionado, quantidade, precoUnitario, valorTotalItem);
                itensCompra.add(itemCompra);
            } else {
                break;
            }

        }

        return itensCompra;
    }

    private static void exibirMensagemCompraRealizada(double valorTotal) {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel mensagemLabel = new JLabel("Compra realizada com sucesso!");
        JLabel valorTotalLabel = new JLabel("Valor Total: R$ " + formatarValor(valorTotal));

        panel.add(mensagemLabel);
        panel.add(valorTotalLabel);

        JOptionPane.showMessageDialog(null, panel, "Compra Realizada", JOptionPane.INFORMATION_MESSAGE);
    }

    private static double solicitarTotalPago(double valorTotal) {
        while (true) {
            try {
                if (valorTotal >= 0) {
                    return valorTotal;
                } else {
                    JOptionPane.showMessageDialog(null, "O valor total pago deve ser maior ou igual a zero.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um valor numérico válido.");
            }
        }
    }

    private static String formatarValor(double valor) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(valor);
    }

    private static JComboBox<ProdutoComboItem> criarProdutoComboBox(List<Produto> produtos) {
        DefaultComboBoxModel<ProdutoComboItem> model = new DefaultComboBoxModel<>();
        for (Produto produto : produtos) {
            ProdutoComboItem comboItem = new ProdutoComboItem(produto, produto.getPreco());
            model.addElement(comboItem);
        }

        return new JComboBox<>(model);
    }

    private static class ProdutoComboItem {
        private final Produto produto;
        private final double precoUnitario;

        public ProdutoComboItem(Produto produto, double precoUnitario) {
            this.produto = produto;
            this.precoUnitario = precoUnitario;
        }

        public Produto getProduto() {
            return produto;
        }

        public double getPrecoUnitario() {
            return precoUnitario;
        }

        @Override
        public String toString() {
            return produto.getNomeProduto() + " - R$ " + precoUnitario; // Exibe o nome e o preço do produto no JComboBox
        }
    }


    private static void addField(JPanel panel, String label1, String label2, JComponent component) {
        JPanel fieldPanel = new JPanel(new GridLayout(0, 1));
        fieldPanel.setBorder(new EmptyBorder(0, 10, 0, 10));

        fieldPanel.add(new JLabel(label1));
        fieldPanel.add(component);

        if (!label2.isEmpty()) {
            fieldPanel.add(new JLabel(label2));
        }

        panel.add(fieldPanel);
    }

}
