package AcoesProduto;

import Produto.Produto;
import Produto.ProdutoPerecivel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class CadastroProduto {
    public static boolean perecivel = false; // Variável estática para indicar se o produto é perecível ou não
    public static void escolhaOpcao(List<Produto> produtos) {     // Método para permitir ao usuário escolher entre produto perecível e não perecível
        // Opções apresentadas ao usuário
        String[] options = {"Perecível", "Não Perecível"};
        // Janela de diálogo para a escolha do usuário
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
            // Produto perecivel
            cadastrarProdutoPerecivel(produtos);
        } else if (choice == 1) {
            cadastrarProdutoNaoPerecivel(produtos);
        } else {
            // Usuário cancelou
            JOptionPane.showMessageDialog(null, "Operação cancelada");
        }
    }

    // Método para cadastrar um produto perecível
    public static void cadastrarProdutoPerecivel(List<Produto> produtos) {
        perecivel = true;
        // Configurar o painel para entrada de dados
        JPanel panel = new JPanel(new GridLayout(0, 2)); // Painel com layout de grade para os pares de campos
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Adicionando um espaçamento ao redor do paine
        JTextField codigoField = new JTextField(10);
        JTextField nomeProdutoField = new JTextField(10);
        JTextField descricaoField = new JTextField(10);
        JTextField precoField = new JTextField(10);
        JTextField validadeField = new JTextField(10);

        // Adicionar campos ao painel com o metodo addField
        addField(panel, "Digite o código do produto: ", "", codigoField);
        addField(panel, "Digite o nome do produto: ", "", nomeProdutoField);
        addField(panel, "Digite a descrição do produto: ", "", descricaoField);
        addField(panel, "Digite o preço do produto: ", "", precoField);
        addField(panel, "Selecione a data de validade: ", "", validadeField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Produto",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE); // Janela de diálogo para entrada de dados
        if (result == JOptionPane.OK_OPTION) {
            String codigo = codigoField.getText();
            String nomeProduto = nomeProdutoField.getText();
            String descricao = descricaoField.getText();
            double preco = Double.parseDouble(precoField.getText());
            String validade = validadeField.getText();

            // Criar um objeto ProdutoPerecivel e adicioná-lo à lista de produtos atraves de produtps.add(itemDeCompra)
            ProdutoPerecivel itemDeCompra = new ProdutoPerecivel(codigo, nomeProduto, descricao, preco, perecivel, validade);
            produtos.add(itemDeCompra);
            JOptionPane.showMessageDialog(null, "Cadastro de Produto realizado com sucesso.");
            JOptionPane.showMessageDialog(null, itemDeCompra.paraString());
        }
    }
    // Método para cadastrar um produto não perecível
    public static void cadastrarProdutoNaoPerecivel(List<Produto> produtos) {
        // Configurar o painel para entrada de dados
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

        // Janela de diálogo para entrada de dados
        int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Produto",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            // Processar os dados inseridos pelo usuário
            String codigo = codigoField.getText();
            String nomeProduto = nomeProdutoField.getText();
            String descricao = descricaoField.getText();
            double preco = Double.parseDouble(precoField.getText());

            // Criar um objeto Produto e adicioná-lo à lista de produtos
            Produto produto = new Produto(codigo, nomeProduto, descricao, preco);
            produtos.add(produto);
            JOptionPane.showMessageDialog(null, "Cadastro de Produto realizado com sucesso.");
            JOptionPane.showMessageDialog(null, produto.paraString());
        }
    }

    // Método auxiliar para adicionar um campo ao painel
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
