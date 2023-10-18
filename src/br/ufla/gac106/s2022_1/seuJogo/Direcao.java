package br.ufla.gac106.s2022_1.seuJogo;

public enum Direcao {
    NORTE("Norte"), SUL("Sul"), BAIXO("Baixo"), CIMA("Cima"), LESTE("Leste"), OESTE("Oeste"), PASSADO("Passado"), FUTURO("Futuro");

    private String descricao;

    Direcao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
