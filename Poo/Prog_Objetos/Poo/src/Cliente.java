public class Cliente {
    private String nome;
    private Endereco endereco;
    private String dataCadastro;

    public Cliente(String nome, Endereco endereco, String dataCadastro) {
        this.nome = nome;
        this.endereco = endereco;
        dataCadastro = dataCadastro;
    }
    public String paraString(){
        return "Nome:" + nome + "\nCliente.Endereco:" + endereco.paraString() + "\nData de Cadastro:" + dataCadastro;
    }
}
