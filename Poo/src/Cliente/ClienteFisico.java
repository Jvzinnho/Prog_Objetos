package Cliente;

public class ClienteFisico extends Cliente {

    private String CPF;
    private int qtdMaximaParcelas;

    public ClienteFisico(String nome, String dataCadastro, String CPF, int qtdMaximaParcelas, String rua, String numero, String bairro, String cep, String cidade, String estado) {
        super(nome, dataCadastro, rua, numero, bairro, cep, cidade, estado);
        this.CPF = CPF;
        this.qtdMaximaParcelas = qtdMaximaParcelas;
    }
    public String toString(){
        return super.toString() + "CPF:" + CPF + "\nQuantidade maxima de parcelas:" + qtdMaximaParcelas + getNome();
    }
}
