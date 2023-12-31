package Produto;

public class Produto {
    private String codigo;
    private String nomeProduto;
    private String descricao;
    private double preco;

    public Produto(String codigo, String nomeProduto, String descricao, double preco) {
        this.codigo = codigo;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String paraString() {
        return "Código: " + getCodigo() + "\nNome do produto: " + getNomeProduto() +
                "\nDescrição: " + getDescricao() + "\nPreço: " + getPreco();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return getNomeProduto();
    }

}
