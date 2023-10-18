package br.ufla.gac106.s2022_1.seuJogo;

public class PersonagemInimigo extends Personagem {
    private String itemDerrotar;
    private Direcao passagemQueBloqueia;
    private boolean estaMorto = false;
    public PersonagemInimigo(String nome, String fala, String itemDerrotar,Direcao passagemQueBloqueia) {
        super(nome, fala);
        this.itemDerrotar = itemDerrotar;
        this.passagemQueBloqueia = passagemQueBloqueia;
    }
    // @Override
    // public String getitemDerrotar() {
    //     return itemDerrotar;
    // }
    @Override
    public boolean naoBloqueiaEssaPassagem(String direcao){
        if(passagemQueBloqueia.getDescricao().equals(direcao)){
            return false;
        }
        return true;
    }
    @Override
    public Boolean usarItem(String item){
        if(item.equals(itemDerrotar)){
            estaMorto = true;
            return true;
        }
        return false;
    }
    @Override
    public boolean getEstaMorto() {
        return estaMorto;
    }
}

