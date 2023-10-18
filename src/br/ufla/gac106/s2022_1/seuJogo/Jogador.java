package br.ufla.gac106.s2022_1.seuJogo;

import java.util.ArrayList;

public class Jogador {
    private String nome;
    private ArrayList<Item> itens;
    private Ambiente ambienteAtual;
    private int contadorMovimentacoes = 0;

    public Jogador(String nome) {
        this.nome = nome;
        itens = new ArrayList<>();
    }

    public Ambiente getAmbienteAtual() {
        return ambienteAtual;
    }

    public void setAmbienteAtual(Ambiente ambiente) {
        this.ambienteAtual = ambiente;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeItensEstaCarregando() {
        String nomeItens = "";
        if (itens.size() != 0) {
            for (Item item : itens) {
                nomeItens = item.getNome() + ", " + nomeItens;
            }
            return nomeItens;
        }
        return null;
    }

    public boolean adicionaItem(Item item) {
        if (itens.size() < 2 && item != null) {
            itens.add(item);
            return true;
        }
        return false;
    }

    public Item removeItem(String item) {
        Item itemRetornar = null;
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getNome().equals(item)) {
                itemRetornar = itens.remove(i);
            }

        }
        return itemRetornar;
    }

    public boolean temItem() {
        return itens.size() != 0;
    }

    public Item retornaItemPeloNome(String nomeItem) {
        Item itemRetornar = null;
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getNome().equals(nomeItem)) {
                itemRetornar = itens.get(i);
            }

        }
        return itemRetornar;
    }

    public int getcontadorMovimentacoes(){
        return contadorMovimentacoes;
    } 

    public void incrementarContadorMovimentos(){
        contadorMovimentacoes = contadorMovimentacoes +1;
    }
}
