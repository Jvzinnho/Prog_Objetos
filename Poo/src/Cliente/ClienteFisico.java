package Cliente;

public class ClienteFisico extends Cliente {
    //Valores com tipos especifo para cliente fisico
    private String CPF;

    private int qtdMaximaParcelas;

    // Construtor que recebe informações específicas de ClienteFisico e entao da classe princioal Cliente
    public ClienteFisico(String nome, String dataCadastro, String CPF, int qtdMaximaParcelas, String rua, String numero, String bairro, String cep, String cidade, String estado) {
        super(nome, dataCadastro, rua, numero, bairro, cep, cidade, estado);
        this.CPF = CPF;
        this.qtdMaximaParcelas = qtdMaximaParcelas;
    }
    // Método para obter uma representação em string do objeto ClienteFisico
    public String paraString(){

        return "Nome: " + getNome() + "\nCPF: " + getCPF();
    }

    public String getCPF() {
        return CPF;
    }

    public String getCpfCnpj() {
        return getCPF();
    }

    public void setCPF(String CPF) {

        this.CPF = CPF;
    }

    public int getQtdMaximaParcelas() {

        return qtdMaximaParcelas;
    }

    public void setQtdMaximaParcelas(int qtdMaximaParcelas) {

        this.qtdMaximaParcelas = qtdMaximaParcelas;
    }
}
