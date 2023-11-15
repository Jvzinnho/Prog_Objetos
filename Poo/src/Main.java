import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import javax.swing.border.EmptyBorder;
import AcoesCliente.CadastroCliente;
import AcoesCliente.DeletaClienteCpfCnpj;
import AcoesCliente.DeletaClienteNome;
import AcoesCompra.EfetuarCompra;
import AcoesProduto.CadastroProduto;
import Cliente.Cliente;
import Cliente.ClienteFisico;
import Compra.Compra;
import Produto.Produto;

public class Main {
    public static class MenuComJOptionPane {
        public static void main(String[] args) throws IOException {

            File file = new File("../baseDados/clientes.txt");
            boolean existe = file.exists();
            file.createNewFile();

            try (BufferedWriter bw = new BufferedWriter(new FileWriter("clientes.txt"))) {
                // Escrever os dados do cliente no arquivo
                bw.write(Cliente.getDadosFormatados());
                JOptionPane.showInputDialog(null, "Dados do cliente escritos com sucesso.");
            } catch (IOException e) {
                e.printStackTrace();
            }

            List<Cliente> clientes = new ArrayList<>(); //instanciando uma coleção parametrizada com a classe
            List<Produto> produtos = new ArrayList<>(); //instanciando uma coleção parametrizada com a classe
            List<Compra> compras = new ArrayList<>(); //instanciando uma coleção parametrizada com a classe

            ClienteFisico clienteFisico1 = new ClienteFisico("João", "01/02/23", "34512354198"
                                                                , 4, "Rua Aparecida", "211", "Vila Helena"
                                                                , "18099080", "Sorocaba", "SP");
            clientes.add(clienteFisico1);

            int escolha; //Variavel para navegacao do menu
            do { // Inicio de um Loop infinito onde para sair ou encerrar a atividade será necessario o usuario digitar o numero de sair (8)
                String menu = "Menu: \n" +
                        "1. Cadastro Cliente \n" +
                        "2. Deletar cliente pelo CPF ou CNPJ \n" +
                        "3. Deletar cliente pelo nome \n" +
                        "4. Cadastro de Produtos\n" +
                        "5. Efetuação de uma compra\n" +
                        "6. Atualização da situação de pagamento de uma compra\n" +
                        "7. Relatorios\n" +
                        "8. Sair\n" +
                        "Escolha uma opção:";

                //Utilizando a classe JOptionPane para exibir uma caixa de dialogo ao usuario
                String escolhaStr = JOptionPane.showInputDialog(null, menu); //Interface Grafica do usuario onde 'menu' ´q a mensagem exibida na caixa
                escolha = Integer.parseInt(escolhaStr); //Recebimento de uma variavel do tipo String do usuario e entao a converte para um tipo inteiro

                switch (escolha) {
                    case 1:
                        //Cadastro de Clientes
                        CadastroCliente.escolhaOpcao(clientes);
                        break;

                    case 2:
                        //Deletar cliente pelo CPF ou CNPJ
                        DeletaClienteCpfCnpj.escolhaOpcao(clientes);
                        break;
                    case 3:
                        //Deletar cliente pelo nome
                        DeletaClienteNome.deletarClientePorNome(clientes);
                        break;
                    case 4:
                        //Cadastro de Produtos
                        CadastroProduto.escolhaOpcao(produtos);
                        break;
                    case 5:
                        //Efetuação de uma compra
                        EfetuarCompra.escolhaOpcao(compras, clientes, produtos);
                        break;
                    case 6:
                        //Atualização da situação de pagamento de uma compra
                        break;
                    case 7:
                        //Relatórios
                        break;
                    case 8:
                        //Sair
                        return;
                    case 9:
                        System.out.println(clientes);
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente");
                }
            } while (escolha != 8);
        }
    }

    //Definição do addField o qual adiciona um label e um campo de texto no painel do usuario
    //o comeco do codigo é um metodo privado e estatico que não retorna valor
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