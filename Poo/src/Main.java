import Cliente.Cliente;
import Cliente.ClienteFisico;
import Cliente.ClienteJuridico;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Main {
    public static class MenuComJOptionPane { //criacao da classe estatica com a biblioteca do menu
        public static void main(String[] args) { //iniciando a main
            int escolha; //variavel do tipo inteira para poder navegar atraves do menu
            List<Cliente> clientes = new ArrayList<>();
            do {
                String menu = "Menu:\n" +
                        "1. Cadastro Cliente.Cliente \n" +
                        "2. Deletar cliente pelo CPF ou CNPJ \n" +
                        "3. Deletar cliente pelo nome \n" +
                        "4. Cadastro de Produtos\n" +
                        "5. Efetuação de uma compra\n" +
                        "6. Atualização da situação de pagamento de uma compra\n" +
                        "7. Relatorios\n" +
                        "8. Sair\n" +
                        "Escolha uma opção:";

                String escolhaStr = JOptionPane.showInputDialog(null, menu);//criar uma caixa String mostrando o menu realizado
                escolha = Integer.parseInt(escolhaStr);// converte a string digitada para um tipo inteiro

                switch (escolha) {
                    case 1:
                        String tipoClienteStr = JOptionPane.showInputDialog(null,
                                "1. Cliente.Cliente físico\n" +
                                        "2. Cliente.Cliente Jurídico\n Escolha o tipo de cliente:");

                        int tipoCliente = Integer.parseInt(tipoClienteStr);


                        if (tipoCliente == 1) {
                            JPanel panel = new JPanel(new GridLayout(0, 2)); // Painel com layout de grade para os pares de campos
                            panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Adicionando um espaçamento ao redor do painel

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

                            int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Cliente.Cliente Físico",
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

                        //Cliente.Cliente Jurídico
                        else if (tipoCliente == 2) {
                            JPanel panel = new JPanel(new GridLayout(0, 2)); // Painel com layout de grade para os pares de campos
                            panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Adicionando um espaçamento ao redor do painel

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
                            JTextField prazoPagamentoField = new JTextField(10);

                            addField(panel, "Digite o nome do cliente:", "", nomeField);
                            addField(panel, "Data do cadastro:", "", dataCadastroField);
                            addField(panel, "Digite o nome da rua:", "", ruaField);
                            addField(panel, "Digite o número:", "", numeroField);
                            addField(panel, "Digite o nome do bairro:", "", bairroField);
                            addField(panel, "Digite o CEP:", "", cepField);
                            addField(panel, "Digite o nome da cidade:", "", cidadeField);
                            addField(panel, "Digite o nome do estado:", "", estadoField);
                            addField(panel, "Digite o CNPJ do cliente:", "", cnpjField);
                            addField(panel, "Digite a razão social:", "", razaoSocialField);
                            addField(panel, "Prazo máximo para pagamento:", "", prazoPagamentoField);

                            int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Cliente.Cliente Jurídico",
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
                                String cnpj = cnpjField.getText();
                                String razaoSocial = razaoSocialField.getText();
                                int prazoPagamento = Integer.parseInt(prazoPagamentoField.getText());

                                Cliente clienteJuridico = new ClienteJuridico(nome, rua, numero, bairro, cep, cidade, estado, dataCadastro, cnpj, razaoSocial, prazoPagamento);
                                clientes.add(clienteJuridico);

                                JOptionPane.showMessageDialog(null, "Cadastro de cliente jurídico realizado.");
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                        }
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                }
            } while (escolha != 8);
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



   /* public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao;
        List<Cliente.Cliente> clientes = new ArrayList<>();
        //do while para executar o menu em um loop, saindo apenas qnd o usuario digitar 8
        do {

            System.out.println("-----MENU-----");
            System.out.println("1. Cadastro de Clientes");
            System.out.println("2. Deletar cliente pelo CPF ou CNPJ");
            System.out.println("3. Deletar cliente pelo nome");
            System.out.println("4. Cadastro de Produtos");
            System.out.println("5. Efetuação de uma compra");
            System.out.println("6. Atualização da situação de pagamento de uma compra");
            System.out.println("7. Relatorios");
            System.out.println("8. Sair");

            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("---Cadastro de Cliente.Cliente---");
                    System.out.println("Nome do Cliente.Cliente:");
                    String nome = scanner.next();
                    System.out.println("""
                            Data do cadastro:
                            Obs. Utilize XX/XX/XXXX
                            """);
                    String dataCadastro = scanner.next();

                    System.out.println("1. Cliente.Cliente fisico");
                    System.out.println("2. Cliente.Cliente Juridico");
                    int escolhaCliente = scanner.nextInt();

                    if (escolhaCliente == 1){
                        System.out.println("""
                                Digite o CPF do cliente:
                                Obs. seperar por . e -: XXX.XXX.XXX-XX
                                """);
                        String CPF = scanner.next();
                        System.out.println("Quantas parcelas serao realizadas:");
                        int qtdMaximaParcelas = scanner.nextInt();
                        System.out.println("Cadastro de cliente fisico realizado.");
                    }
                    if (escolhaCliente == 2){

                    }
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Numero incorreto..");
                    break;
            }
        } while (opcao != 8);

        scanner.close();
    }
} */