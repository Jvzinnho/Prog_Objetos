public class ClienteFisico extends Cliente {

    private String CPF;
    private int qtdMaximaParcelas;

    public ClienteFisico(String nome, String dataCadastro, String CPF, int qtdMaximaParcelas, String endereco) {
        super(nome, endereco, dataCadastro);
        this.CPF = CPF;
        this.qtdMaximaParcelas = qtdMaximaParcelas;
    }
    public String paraString(){
        return super.paraString() + "CPF:" + CPF + "\nQuantidade maxima de parcelas:" + qtdMaximaParcelas;
    }
}
