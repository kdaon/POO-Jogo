package br.ufla.gac106.s2022_1.seuJogo;

public class Personagem {
    private String nome;
    private String fala;
    private Item item;
    private String itemTroca;
    public Personagem(String nome, String fala) {
        this.nome = nome;
        this.fala = fala;
    }
    public Personagem(String nome, String fala, Item item, String itemTroca) {
        this.nome = nome;
        this.fala = fala;
        this.item = item;
        this.itemTroca = itemTroca;
    }

    public String getNome() {
        return nome;
    }

    public String getFala() {
        return fala;
    }

    public Item trocar(String nomeItem) {
        if(item != null){
            if(itemTroca.equals(nomeItem)){
                Item itemAux;
                itemAux = item;
                itemTroca = null;
                trocarFala();
                return itemAux;
            }
        }
        return null;
    }

    private void trocarFala(){
        fala = "Obrigado pela troca Marty Mcfly!";
    }
    public boolean naoBloqueiaEssaPassagem(String direcao){
        return true;
    }

    public Boolean usarItem(String item){
        return false;
    }

    public boolean getEstaMorto() {
        return false;
    }
}
