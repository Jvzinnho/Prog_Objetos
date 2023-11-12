package Produto;

import java.util.Date;

public class ProdutoPerecivel extends Produto{
    private boolean perecivel;
    private String validade;

    public ProdutoPerecivel(String codigo, String nomeProduto, String descricao, double preco, boolean perecivel, String validade) {
        super(codigo, nomeProduto, descricao, preco);
        this.perecivel = perecivel;
        this.validade = validade;
    }

    public String paraString() {
        return "Código: " + getCodigo() + "\nNome do produto: " + getNomeProduto() + "\nDescrição: " + getDescricao() +
                    "\nPreço: " + getPreco() + "\nValidade: " + getValidade();
    }

    public boolean isPerecivel() {
        return perecivel;
    }

    public void setPerecivel(boolean perecivel) {
        perecivel = perecivel;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
}
