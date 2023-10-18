package br.ufla.gac106.s2022_1.seuJogo;

import br.ufla.gac106.s2022_1.baseJogo.InterfaceUsuario;
import br.ufla.gac106.s2022_1.baseJogo.Terminal;

public class App {
    public static void main(String[] args) throws Exception {
        InterfaceUsuario interfaceUser = new Terminal();
        Jogo jogo = Jogo.getInstancia(interfaceUser);	
        try{
		    jogo.jogar();
        }catch(Exception e){
            System.out.println("Aconteceu um erro inesperado, por favor abra o jogo novamente!");
        }
    }
}
