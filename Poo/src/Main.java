import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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
}