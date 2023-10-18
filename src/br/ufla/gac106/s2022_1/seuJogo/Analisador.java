package br.ufla.gac106.s2022_1.seuJogo;

public class Analisador {
    private PalavrasComando palavrasDeComando;

    public Analisador() {
        palavrasDeComando = new PalavrasComando();
    }

    public Comando pegarComando(String linhaParametro) {
        String linha;
        String palavra1 = null;
        String palavra2 = null;

        //System.out.print("> ");
        
        linha = linhaParametro;

        String[] palavras = linha.trim().split("\\s+");

        if (palavras.length >= 1) {
            palavra1 = palavras[0];
        }
        if (palavras.length >= 2) {
            palavra2 = palavras[1];
        }

        if (palavrasDeComando.ehComando(palavra1)) {
            return new Comando(palavra1, palavra2);
        } else {
            return new Comando(null, palavra2);
        }
    }

    public String palavrasComando() {

        return palavrasDeComando.comandosValidos();
    }
}