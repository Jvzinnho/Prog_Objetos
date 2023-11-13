package AcoesCliente;

import Cliente.ClienteFisico;
import Cliente.ClienteJuridico;
import Cliente.Cliente;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class CadastroCliente {
    public static void escolhaOpcao(List<Cliente> clientes) {
        String[] options = {"Cliente Físico", "Cliente Jurídico"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Escolha o tipo de cliente:",
                "Cadastro de Cliente",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        // Verificar a escolha do usuário
        if (choice == 0) {
            // Cliente Físico
            cadastrarClienteFisico(clientes);
        } else if (choice == 1) {
            cadastrarClienteJuridico(clientes);
        } else {
            // Usuário cancelou
            JOptionPane.showMessageDialog(null, "Operação cancelada");
        }
    }

    public static void cadastrarClienteFisico(List<Cliente> clientes) {

        JPanel panel = new JPanel(new GridLayout(0, 2)); // Painel com layout de grade para os pares de campos
            panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Adicionando um espaçamento ao redor do paine
            JTextField nomeField = new JTextField(10);
            JTextField dataCadastroField = new JTextField(10);
            JTextField ruaField = new JTextField(10);
            JTextField numeroField = new JTextField(10);
            JTextField bairroField = new JTextField(10);
            JTextField cepField = new JTextField(10);
            JTextField cidadeField = new JTextField(10);
            JTextField estadoField = new JTextField(10);
            JTextField CPFField = new JTextField(10);
            JTextField qtdMaxParcelasField = new JTextField(10);
            addField(panel, "Digite o nome do cliente:", "", nomeField);
            addField(panel, "Data do cadastro:", "", dataCadastroField);
            addField(panel, "Digite o nome da rua:", "", ruaField);
            addField(panel, "Digite o número:", "", numeroField);
            addField(panel, "Digite o nome do bairro:", "", bairroField);
            addField(panel, "Digite o CEP:", "", cepField);
            addField(panel, "Digite o nome da cidade:", "", cidadeField);
            addField(panel, "Digite o nome do estado:", "", estadoField);
            addField(panel, "Digite o CPF do cliente (XXX.XXX.XXX-XX):", "", CPFField);
            addField(panel, "Quantas parcelas serão realizadas:", "", qtdMaxParcelasField);
            int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Cliente Físico",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                String nome = nomeField.getText();
                String dataCadastro = dataCadastroField.getText();
                String rua = ruaField.getText();
                String numero = numeroField.getText();
                String bairro = bairroField.getText();
                String cep = cepField.getText();
                String cidade = cidadeField.getText();
                String estado = estadoField.getText();
                String CPF = CPFField.getText();
                int qtdMaxParcelas = Integer.parseInt(qtdMaxParcelasField.getText());
                Cliente clienteFisico = new ClienteFisico(nome, dataCadastro, CPF, qtdMaxParcelas, rua, numero, bairro, cep, cidade, estado);
                clientes.add(clienteFisico);
                JOptionPane.showMessageDialog(null, "Cadastro de cliente físico realizado.");
            }
    }

    //metodo para cadastrar um cliente do tipo ClienteJuridico, no qual este metodo tem oresente todos os campos de adição de caixa de dialogo e de obtenção de dados do usuario
    public static void cadastrarClienteJuridico(List<Cliente> clientes) {

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JTextField nomeField = new JTextField(10);
        JTextField dataCadastroField = new JTextField(10);
        JTextField ruaField = new JTextField(10);
        JTextField numeroField = new JTextField(10);
        JTextField bairroField = new JTextField(10);
        JTextField cepField = new JTextField(10);
        JTextField cidadeField = new JTextField(10);
        JTextField estadoField = new JTextField(10);
        JTextField cnpjField = new JTextField(10);
        JTextField razaoSocialField = new JTextField(10);
        JTextField prazoMaxPagamentoField = new JTextField(10);

        addField(panel, "Digite o nome da empresa:", "", nomeField);
        addField(panel, "Data do cadastro:", "", dataCadastroField);
        addField(panel, "Digite o nome da rua:", "", ruaField);
        addField(panel, "Digite o número:", "", numeroField);
        addField(panel, "Digite o nome do bairro:", "", bairroField);
        addField(panel, "Digite o CEP:", "", cepField);
        addField(panel, "Digite o nome da cidade:", "", cidadeField);
        addField(panel, "Digite o nome do estado:", "", estadoField);
        addField(panel, "Digite o CNPJ da empresa:", "", cnpjField);
        addField(panel, "Digite a razão social da empresa:", "", razaoSocialField);
        addField(panel, "Prazo máximo para pagamento (dias):", "", prazoMaxPagamentoField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Cliente Jurídico realizado.",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Processar os dados inseridos pelo usuário
        if (result == JOptionPane.OK_OPTION) {
            String nome = nomeField.getText();
            String dataCadastro = dataCadastroField.getText();
            String rua = ruaField.getText();
            String numero = numeroField.getText();
            String bairro = bairroField.getText();
            String cep = cepField.getText();
            String cidade = cidadeField.getText();
            String estado = estadoField.getText();
            String cnpj = cnpjField.getText();
            String razaoSocial = razaoSocialField.getText();
            int prazoMaxPagamento = Integer.parseInt(prazoMaxPagamentoField.getText());

            // Criar um objeto ClienteJuridico e adicioná-lo à lista de clientes
            Cliente clienteJuridico = new ClienteJuridico(nome, rua, numero, bairro, cep, cidade, estado, dataCadastro, cnpj, razaoSocial, prazoMaxPagamento);
            clientes.add(clienteJuridico);

            JOptionPane.showMessageDialog(null, "Cadastro de cliente jurídico realizado.");
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