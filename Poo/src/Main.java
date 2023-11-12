import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import AcoesCliente.CadastroCliente;
import AcoesCliente.DeletaClienteCpfCnpj;
import AcoesCliente.DeletaClienteNome;
import AcoesProduto.CadastroProduto;
import Cliente.Cliente;
import Cliente.ClienteFisico;
import Produto.Produto;

public class Main {
    public static class MenuComJOptionPane {
        public static void main(String[] args) {
            List<Cliente> clientes = new ArrayList<>();
            List<Produto> produtos = new ArrayList<>();

            ClienteFisico clienteFisico1 = new ClienteFisico("João", "01/02/23", "34512354198"
                                                                , 4, "Rua Aparecida", "211", "Vila Helena"
                                                                , "18099080", "Sorocaba", "SP");
            clientes.add(clienteFisico1);
            int escolha;
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

                String escolhaStr = JOptionPane.showInputDialog(null, menu);
                escolha = Integer.parseInt(escolhaStr);

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