public class ClienteJuridico extends Cliente{
    private String CNPJ;
    private String razaoSocial;
    private int prazoMaximoPagamento;

    public ClienteJuridico(String nome, Endereco endereco, String dataCadastro, String CNPJ, String razaoSocial, int prazoMaximoPagamento) {
        super(nome, endereco, dataCadastro);
        this.CNPJ = CNPJ;
        this.razaoSocial = razaoSocial;
        this.prazoMaximoPagamento = prazoMaximoPagamento;
    }
    public String paraString(){
        return super.paraString() + "\nCNPJ:" + CNPJ + "\nRazao Social:" + razaoSocial + "\nPrazo maximo para pagamento:" + prazoMaximoPagamento;
    }
}
