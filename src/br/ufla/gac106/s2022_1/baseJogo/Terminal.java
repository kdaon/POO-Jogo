package br.ufla.gac106.s2022_1.baseJogo;
import java.util.Scanner;
public class Terminal implements InterfaceUsuario {
    private Scanner entrada = new Scanner(System.in);
    @Override
    public void exibirMensagem(String mensagem) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void continuarMensagem(String mensagem) {
        System.out.println(mensagem);
        
    }

    @Override
    public String obterComando() {
        // TODO Auto-generated method stub
        String linha;
        linha = entrada.nextLine();
        return linha;
    }

    @Override
    public String obterInformacao(String instrucao) {
        // TODO Auto-generated method stub
        
        return null;
    }

    @Override
    public void ambienteAtualMudou(EntidadeGrafica ambiente) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void jogadorPegouItem(EntidadeGrafica item) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void jogadorDescartouItem(EntidadeGrafica item) {
        // TODO Auto-generated method stub
        
    }
    
}
