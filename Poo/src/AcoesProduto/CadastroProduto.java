package AcoesProduto;

import Produto.Produto;
import Produto.ProdutoPerecivel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class CadastroProduto {
    public static boolean perecivel = false;
    public static void escolhaOpcao(List<Produto> produtos) {
        String[] options = {"Perecível", "Não Perecível"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Escolha o tipo do produto:",
                "Cadastro de Produto",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        // Verificar a escolha do usuário
        if (choice == 0) {
            // Cliente Físico
            cadastrarProdutoPerecivel(produtos);
        } else if (choice == 1) {
            cadastrarProdutoNaoPerecivel(produtos);
        } else {
            // Usuário cancelou
            JOptionPane.showMessageDialog(null, "Operação cancelada");
        }
    }

    public static void cadastrarProdutoPerecivel(List<Produto> produtos) {
        perecivel = true;
        JPanel panel = new JPanel(new GridLayout(0, 2)); // Painel com layout de grade para os pares de campos
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Adicionando um espaçamento ao redor do paine
        JTextField codigoField = new JTextField(10);
        JTextField nomeProdutoField = new JTextField(10);
        JTextField descricaoField = new JTextField(10);
        JTextField precoField = new JTextField(10);
        JTextField validadeField = new JTextField(10);

        addField(panel, "Digite o código do produto: ", "", codigoField);
        addField(panel, "Digite o nome do produto: ", "", nomeProdutoField);
        addField(panel, "Digite a descrição do produto: ", "", descricaoField);
        addField(panel, "Digite o preço do produto: ", "", precoField);
        addField(panel, "Selecione a data de validade: ", "", validadeField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Produto",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String codigo = codigoField.getText();
            String nomeProduto = nomeProdutoField.getText();
            String descricao = descricaoField.getText();
            double preco = Double.parseDouble(precoField.getText());
            String validade = validadeField.getText();

            ProdutoPerecivel itemDeCompra = new ProdutoPerecivel(codigo, nomeProduto, descricao, preco, perecivel, validade);
            produtos.add(itemDeCompra);
            JOptionPane.showMessageDialog(null, "Cadastro de Produto realizado com sucesso.");
            JOptionPane.showMessageDialog(null, itemDeCompra.paraString());
        }
    }

    public static void cadastrarProdutoNaoPerecivel(List<Produto> produtos) {
        JPanel panel = new JPanel(new GridLayout(0, 2)); // Painel com layout de grade para os pares de campos
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Adicionando um espaçamento ao redor do paine
        JTextField codigoField = new JTextField(10);
        JTextField nomeProdutoField = new JTextField(10);
        JTextField descricaoField = new JTextField(10);
        JTextField precoField = new JTextField(10);
        addField(panel, "Digite o código do produto: ", "", codigoField);
        addField(panel, "Digite o nome do produto: ", "", nomeProdutoField);
        addField(panel, "Digite a descrição do produto: ", "", descricaoField);
        addField(panel, "Digite o preço do produto: ", "", precoField);
        int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Produto",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String codigo = codigoField.getText();
            String nomeProduto = nomeProdutoField.getText();
            String descricao = descricaoField.getText();
            double preco = Double.parseDouble(precoField.getText());
            Produto itemDeCompra = new Produto(codigo, nomeProduto, descricao, preco);
            produtos.add(itemDeCompra);
            JOptionPane.showMessageDialog(null, "Cadastro de Produto realizado com sucesso.");
            JOptionPane.showMessageDialog(null, itemDeCompra.paraString());
        }
    }

    private static void addField(JPanel panel, String label1, String label2, JTextField textField) {
        JPanel fieldPanel = new JPanel(new GridLayout(0, 1)); // Sub-painel para o par de rótulo e campo
        fieldPanel.setBorder(new EmptyBorder(0, 10, 0, 10)); // Adicionando espaçamento entre colunas

        fieldPanel.add(new JLabel(label1));
        fieldPanel.add(textField);
        if (!label2.isEmpty()) {
            fieldPanel.add(new JLabel(label2));
        }

        panel.add(fieldPanel);
    }
}
