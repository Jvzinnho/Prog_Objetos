public class Cliente{
    private String nome;
    private  Endereco endereco;
    private String dataCadastro;

    public Cliente(String nome, String rua, String numero, String bairro, String cep, String cidade, String estado, String dataCadastro) {

        this.nome = nome;
        this.dataCadastro = dataCadastro;
    }
    public String paraString(){
        return "Nome:" + nome + "\nEndereco:" + endereco.paraString() + "\nData de Cadastro:" + dataCadastro;
    }
}
