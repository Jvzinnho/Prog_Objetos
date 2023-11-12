package Cliente;

public class ClienteFisico extends Cliente {

    private String CPF;

    private int qtdMaximaParcelas;

    public ClienteFisico(String nome, String dataCadastro, String CPF, int qtdMaximaParcelas, String rua, String numero, String bairro, String cep, String cidade, String estado) {
        super(nome, dataCadastro, rua, numero, bairro, cep, cidade, estado);
        this.CPF = CPF;
        this.qtdMaximaParcelas = qtdMaximaParcelas;
    }
    public String paraString(){
        return "Nome: " + getNome() + "\nCPF: " + getCPF();
    }

    public String getCPF() {
        return CPF;
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
