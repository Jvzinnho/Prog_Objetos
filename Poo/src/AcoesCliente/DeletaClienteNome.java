package AcoesCliente;
import Cliente.Cliente;

import javax.swing.*;
import java.util.List;

public class DeletaClienteNome {

    public static void deletarClientePorNome(List<Cliente> clientes) {
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
        Cliente clienteRemover = null;

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                clienteRemover = cliente;
                break;
            }
        }

        if (clienteRemover != null) {
            clientes.remove(clienteRemover);
            JOptionPane.showMessageDialog(null, "Cliente com nome '" + nome + "' removido com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente com nome '" + nome + "' não encontrado.");
        }
    }
}
