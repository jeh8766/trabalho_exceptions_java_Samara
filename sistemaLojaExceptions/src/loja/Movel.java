package loja;

public class Movel extends Produto {

    String categoria;

    public Movel(String nome, double preco, double quantidade, String categoria) {
        super(nome, preco, quantidade);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String exibirInformacoes () {
        return "O produto é: " + this.nome + ". A categoria é: "+ this.categoria;
    }

}