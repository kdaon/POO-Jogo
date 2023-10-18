package br.ufla.gac106.s2022_1.seuJogo;
import java.util.HashMap;

import br.ufla.gac106.s2022_1.baseJogo.EntidadeGrafica;

import java.util.ArrayList;

public class Ambiente extends EntidadeGrafica{
    private String descricao;
    private HashMap<String, Ambiente> saidas;
    private String saidaBloqueada;
    private String itemDeDesbloqueioSaida;
    private String fraseBloqueio;
    private ArrayList<Item> itens;

    public Ambiente(String descricao,String caminho) {
        super(caminho);
        this.descricao = descricao;
        saidas = new HashMap<String, Ambiente>();
        itens = new ArrayList<>();
    }

    public Ambiente(String descricao, Item item,String caminho) {
        this(descricao, caminho);
        itens.add(item);
    }

    public Ambiente(String descricao, Item primeiroItem, Item segundoItem,String caminho) {
        this(descricao, caminho);
        itens.add(primeiroItem);
        itens.add(segundoItem);
    }

    public Ambiente getAmbiente(String direcao) {
        if (direcao.equals(saidaBloqueada)) {
            return null;
        } else {
            return saidas.get(direcao);
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public Personagem getPersonagem(){
        return null;
    }

    public boolean verificaPersonagemAmbiente() {

        return false;
    }

    public String getDescricaoPersonagem() {
        return null;
    }

    public void ajustarSaida(String direcao, Ambiente ambiente) {
        saidas.put(direcao, ambiente);
    }

    public void ajustarSaidaBloqueada(String direcao, Ambiente ambiente, String itemDeDesbloqueio, String fraseBloqueio) {
        ajustarSaida(direcao, ambiente);
        saidaBloqueada = direcao;
        itemDeDesbloqueioSaida = itemDeDesbloqueio;
        this.fraseBloqueio = fraseBloqueio;
    }

    public String getfraseBloqueio(){
        return fraseBloqueio;
    }
    public boolean bloqueiaEssaPassagem(String direcao){
        return false;
    }
    public boolean verificaSaidaBloqueada(String direcao) {
        if (direcao.equals(saidaBloqueada)) {
            return true;
        }
        return false;
    }

    public String getSaidas() {
        String textoSaidas = "";
        for (String direcao : saidas.keySet()) {
            textoSaidas = textoSaidas + direcao + " ";
        }
        return textoSaidas;
    }

    public String getDescricaoItens() {
        String listaDescricaoItens = "";

        if (temItem()) {
            for (Item item : itens) {
                listaDescricaoItens += "Nome do item: " + item.getNome() + "\n" +
                        "Descrição do item: " + item.getDescricao() + "\n";
            }
        }

        return "O ambiente possui os seguintes itens -> " + "\n"
                + listaDescricaoItens;
    }

    public boolean usarItem(Item item) {
        if (item.getNome().equals(itemDeDesbloqueioSaida)) {
            saidaBloqueada = null;
            return true;
        }
        return false;
    }

    public String getDescricaoSaidas() {
        return "As saídas são: " + getSaidas() + "\n";
    }

    public boolean temItem() {
        return !itens.isEmpty();
    }

    public Item getItem(String nomeItem) {
        if (temItem()) {
            for (Item item : itens) {
                if (item.getNome().equals(nomeItem)) {
                    return item;
                }
            }
        }
        return null;
    }

    public String getDescricaoLonga() {
        if (temItem()) {
            return this.getDescricao() + "\n"+
                    getDescricaoItens() + "\n";
        } else {
            return this.getDescricao() + "\n"
                    + "Não há itens aqui" +"\n";
        }
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(String nomeItem) {
        Item itemRemover = getItem(nomeItem);
        itens.remove(itemRemover);
    }

    public void InimigoMorreu(){

    }

    @Override
    public String getNome() {
        // TODO Auto-generated method stub
        return null;
    }
}
