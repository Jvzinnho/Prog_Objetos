package Cliente;

public class ClienteJuridico extends Cliente{
    private String CNPJ;
    private String razaoSocial;
    private int prazoMaximoPagamento;

    //construtor que recebe as informacoes de cliente juridico juntamente com a classe principal de cliente
    public ClienteJuridico(String nome, String rua, String numero, String bairro, String cep, String cidade, String estado, String dataCadastro, String CNPJ, String razaoSocial, int prazoMaximoPagamento) {
        super(nome, rua, numero, bairro, cep, cidade, estado, dataCadastro);
        this.CNPJ = CNPJ;
        this.razaoSocial = razaoSocial;
        this.prazoMaximoPagamento = prazoMaximoPagamento;
    }
    // Método para obter uma representação em string do objeto ClienteJuridico

    public String paraString(){
        return "CNPJ:" + getCNPJ() + "\nRazao Social:" + getRazaoSocial() + "\nPrazo maximo para pagamento:" + getPrazoMaximoPagamento();
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getRazaoSocial() {

        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {

        this.razaoSocial = razaoSocial;
    }

    public int getPrazoMaximoPagamento() {

        return prazoMaximoPagamento;
    }

    public void setPrazoMaximoPagamento(int prazoMaximoPagamento) {
        this.prazoMaximoPagamento = prazoMaximoPagamento;
    }
}