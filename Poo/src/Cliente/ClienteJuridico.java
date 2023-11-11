package Cliente;

public class ClienteJuridico extends Cliente{
    private String CNPJ;
    private String razaoSocial;
    private int prazoMaximoPagamento;

    public ClienteJuridico(String nome, String rua, String numero, String bairro, String cep, String cidade, String estado, String dataCadastro, String CNPJ, String razaoSocial, int prazoMaximoPagamento) {
        super(nome, rua, numero, bairro, cep, cidade, estado, dataCadastro);
        this.CNPJ = CNPJ;
        this.razaoSocial = razaoSocial;
        this.prazoMaximoPagamento = prazoMaximoPagamento;
    }
    public String paraString(){
        return super.paraString() + "\nCNPJ:" + CNPJ + "\nRazao Social:" + razaoSocial + "\nPrazo maximo para pagamento:" + prazoMaximoPagamento;
    }
}