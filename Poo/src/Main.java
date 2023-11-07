import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Main {
    public static class MenuComJOptionPane { //criacao da classe estatica com a biblioteca do menu
        public static void main(String[] args) { //iniciando a main
            int escolha; //variavel do tipo inteira para poder navegar atraves do menu
            List<Cliente> clientes = new ArrayList<>();
            do {
                String menu = "Menu:\n" +
                        "1. Cadastro Cliente \n" +
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
                                "1. Cliente físico\n" +
                                        "2. Cliente Jurídico\nEscolha o tipo de cliente:");

                        int tipoCliente = Integer.parseInt(tipoClienteStr);


                        if (tipoCliente == 1) {
                            String nome = JOptionPane.showInputDialog(null,
                                    "Cliente fisico selecionado \n"
                            +"Digite o nome do cliente:");
                            String dataCadastro = JOptionPane.showInputDialog(null,"""
                            Data do cadastro:
                            Obs. Utilize XX/XX/XXXX
                            """);

                          /*  String rua = JOptionPane.showInputDialog(null, "Digite o nome da rua:");
                            String numero = JOptionPane.showInputDialog(null, "Digite o número:");
                            String bairro = JOptionPane.showInputDialog(null, "Digite o nome do bairro:");
                            String cep = JOptionPane.showInputDialog(null, "Digite o CEP:");
                            String cidade = JOptionPane.showInputDialog(null, "Digite o nome da cidade:");
                            String estado = JOptionPane.showInputDialog(null, "Digite o nome do estado:");

                            Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado);
                            */
                            JTextField textField1 = new JTextField(10);
                            JTextField textField2 = new JTextField(10);
                            JTextField textField3 = new JTextField(10);

                            // Criando o painel para conter os campos de entrada
                            JPanel panel = new JPanel();
                            panel.setLayout(new GridLayout(3, 2)); // Define o layout do painel

                            // Adicionando os componentes ao painel
                            panel.add(new JLabel("Campo 1:"));
                            panel.add(textField1);
                            panel.add(new JLabel("Campo 2:"));
                            panel.add(textField2);
                            panel.add(new JLabel("Campo 3:"));
                            panel.add(textField3);

                            // Exibindo o JOptionPane com o painel
                            int result = JOptionPane.showConfirmDialog(null, panel, "Painel com Inputs",
                                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                            // Verificando se o usuário pressionou OK
                            if (result == JOptionPane.OK_OPTION) {
                                // Obtendo os valores dos campos de entrada
                                String value1 = textField1.getText();
                                String value2 = textField2.getText();
                                String value3 = textField3.getText();

                                // Fazendo algo com os valores inseridos (nesse exemplo, exibindo os valores)
                                System.out.println("Valor do Campo 1: " + value1);
                                System.out.println("Valor do Campo 2: " + value2);
                                System.out.println("Valor do Campo 3: " + value3);
                            }
                            String CPF = JOptionPane.showInputDialog(null, """
                                    Digite o CPF do cliente:
                                    Obs. seperar por . e -: XXX.XXX.XXX-XX
                                    """);

                            int qtdMaximaParcelas = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantas parcelas serao realizadas:"));

                            Cliente clienteFisico =  new ClienteFisico(nome, dataCadastro, CPF, qtdMaximaParcelas, endereco);
                            clientes.add(clienteFisico);

                            JOptionPane.showMessageDialog(null, "Cadastro de cliente fisico realizado.");
                        }
                        else if (tipoCliente == 2) {

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
}

   /* public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao;
        List<Cliente> clientes = new ArrayList<>();
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
                    System.out.println("---Cadastro de Cliente---");
                    System.out.println("Nome do Cliente:");
                    String nome = scanner.next();
                    System.out.println("""
                            Data do cadastro:
                            Obs. Utilize XX/XX/XXXX
                            """);
                    String dataCadastro = scanner.next();

                    System.out.println("1. Cliente fisico");
                    System.out.println("2. Cliente Juridico");
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