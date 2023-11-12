package AcoesCliente;

import Cliente.Cliente;
import Cliente.ClienteFisico;
import Cliente.ClienteJuridico;

import javax.swing.*;
import java.util.List;

public class DeletaClienteCpfCnpj {

    public static void escolhaOpcao(List<Cliente> clientes) {
        String[] options = {"Cliente Físico", "Cliente Jurídico"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Escolha o tipo de cliente para deletar:",
                "Deletar Cliente",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        // Verificar a escolha do usuário
        if (choice == 0) {
            // Cliente Físico
            deletarClienteFisicoPorCpf(clientes);
        } else if (choice == 1) {
            deletarClienteJuridicoPorCnpj(clientes);
        } else {
            // Usuário cancelou
            JOptionPane.showMessageDialog(null, "Operação cancelada");
        }
    }

    public static void deletarClienteFisicoPorCpf(List<Cliente> clientes) {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente físico:");
        for (Cliente cliente : clientes) {
            if (cliente instanceof ClienteFisico) {
                ClienteFisico clienteFisico = (ClienteFisico) cliente;
                if (clienteFisico.getCPF().equals(cpf)) {
                    clientes.remove(clienteFisico);
                    JOptionPane.showMessageDialog(null, "Cliente físico com CPF: " + cpf + " removido com sucesso.");
                    return; // Sai do loop após remover o cliente
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente físico com CPF: " + cpf + " não encontrado.");
    }

    public static void deletarClienteJuridicoPorCnpj(List<Cliente> clientes) {
        String cnpj = JOptionPane.showInputDialog("Digite o CNPJ do cliente jurídico:");
        for (Cliente cliente : clientes) {
            if (cliente instanceof ClienteJuridico) {
                ClienteJuridico clienteJuridico = (ClienteJuridico) cliente;
                if (clienteJuridico.getCNPJ().equals(cnpj)) {
                    clientes.remove(clienteJuridico);
                    JOptionPane.showMessageDialog(null, "Cliente jurídico com CNPJ: " + cnpj + " removido com sucesso.");
                    return; // Sai do loop após remover o cliente
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente jurídico com CNPJ: " + cnpj + " não encontrado.");
    }
}
