package br.ufla.gac106.s2022_1.seuJogo;

public class AmbientePossuiPersonagem extends Ambiente {
    private Personagem personagem;

    public AmbientePossuiPersonagem(String descricao, Personagem personagem, String caminho) {
        super(descricao, caminho);
        this.personagem = personagem;
    }

    public AmbientePossuiPersonagem(String descricao, Item item, Personagem personagem, String caminho) {
        super(descricao, item, caminho);
        this.personagem = personagem;
    }

    public AmbientePossuiPersonagem(String descricao, Item item1, Item item2, Personagem personagem, String caminho) {
        super(descricao, item1, item2 ,caminho);
        this.personagem = personagem;
    }

    @Override
    public boolean verificaPersonagemAmbiente() {
        return personagem != null;
    }
    @Override
    public String getDescricaoPersonagem() {
        return "O ambiente possui um personagem -> " + "\n"
                + "Nome do personagem: " + personagem.getNome() + "\n";
    }
    @Override
    public Personagem getPersonagem(){
        return personagem;
    }

    @Override
    public String getDescricaoLonga() {
        if (verificaPersonagemAmbiente()) {
            return  super.getDescricaoLonga() + getDescricaoPersonagem();
        } else {
            return super.getDescricaoLonga();
        }
    }

    @Override
    public void InimigoMorreu(){
        if(personagem.getEstaMorto()){
            personagem = null;
        }
    }
}
