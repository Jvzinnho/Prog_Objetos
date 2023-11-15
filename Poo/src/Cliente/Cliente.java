package Cliente;

public class Cliente extends Endereco{

    private String nome;
    private  Endereco endereco;
    private String dataCadastro;

    public Cliente(String nome, String rua, String numero, String bairro, String cep, String cidade, String estado, String dataCadastro) {
        super(rua, numero, bairro, cep, cidade, estado);
        this.nome = nome;
        this.dataCadastro = dataCadastro;
    }

    public static int getDadosFormatados() {
        return 0;
    }

    public String paraString(){
        return "Nome:" + getNome() + "\nCliente.Endereco:" + getEndereco().paraString() + "\nData de Cadastro:" + getDataCadastro();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
