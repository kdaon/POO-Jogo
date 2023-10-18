package br.ufla.gac106.s2022_1.seuJogo;

import br.ufla.gac106.s2022_1.baseJogo.EntidadeGrafica;

public class Item extends EntidadeGrafica{
    private String nome;
    private String descricao;
    private boolean itemCarregavel;
    public Item(String nome, String descricao, boolean itemCarregavel, String caminhoImagem) {
        super(caminhoImagem);
        this.nome = nome;
        this.descricao = descricao;
        this.itemCarregavel = itemCarregavel;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Boolean eItemCarregavel() {
        return itemCarregavel;
    }

}
