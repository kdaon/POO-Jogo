package br.ufla.gac106.s2022_1.seuJogo;

public class PalavrasComando {

    private static final String[] comandosValidos = {
            "ir", "sair", "ajuda", "observar", "pegar", "largar", "usar", "conversar", "trocar"
    };

    public boolean ehComando(String umaString) {
        for (int i = 0; i < comandosValidos.length; i++) {
            if (comandosValidos[i].equals(umaString))
                return true;
        }
        return false;
    }

    public String comandosValidos() {
        String palavrasComando = "";
        for (String palavra : comandosValidos) {
            palavrasComando += palavra + " ";
        }
        return palavrasComando;
    }
}