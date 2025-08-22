package loja;

public class EletroDomestico extends Produto{
    private int voltagem;

    public EletroDomestico(String nome, double preco, double quantidade, int voltagem) {
        super(nome, preco, quantidade);
        this.voltagem = voltagem;
    }

    public int getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(int voltagem) {
        this.voltagem = voltagem;
    }

    public String exibirInformacoes () {
        return "O produto é: " + this.nome + ". A voltagem é: "+ this.voltagem;
    }
}
