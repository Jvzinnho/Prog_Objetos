public class ClienteFisico extends Cliente {
    private String CPF;
    private int qtdMaximaParcelas;

    public ClienteFisico(String nome, Endereco endereco, String dataCadastro, String CPF, int qtdMaximaParcelas) {
        super(nome, endereco, dataCadastro);
        this.CPF = CPF;
        this.qtdMaximaParcelas = qtdMaximaParcelas;
    }
    public String paraString(){
        return super.paraString() + "CPF:" + CPF + "\nQuantidade maxima de parcelas:" + qtdMaximaParcelas;
    }
}
