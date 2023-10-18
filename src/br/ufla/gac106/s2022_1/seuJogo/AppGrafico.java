package br.ufla.gac106.s2022_1.seuJogo;

import br.ufla.gac106.s2022_1.baseJogo.InterfaceUsuario;
import br.ufla.gac106.s2022_1.baseJogo.Tela;

public class AppGrafico {
    public static void main(String[] args) throws Exception {
        InterfaceUsuario interfaceUser = new Tela("De Volta Para o Futuro");
        Jogo jogo = Jogo.getInstancia(interfaceUser);
        try{
		    jogo.jogar();
        }catch(Exception e){
            interfaceUser.exibirMensagem("Aconteceu um erro inesperado, por favor feche o jogo e o abra novamente!");
        }
    }
}
