package br.ufla.gac106.s2022_1.seuJogo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Arquivo {
    private String nomeArquivo;
    FileWriter arquivo;
    public Arquivo(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }

    public void salvar(String dados) throws IOException{
        arquivo = new FileWriter("Documentos/"+nomeArquivo+".txt");
        PrintWriter gravarArq = new PrintWriter(arquivo);
        gravarArq.println(dados);
        arquivo.close();
    }


    public String carregamento(){
        String dados = "";
        try {
            FileReader arquivo = new FileReader("Documentos/"+nomeArquivo+".txt");
            BufferedReader lerArq = new BufferedReader(arquivo);
      
            String linha = lerArq.readLine();
            while (linha != null) {
              dados = dados + linha;
              linha = lerArq.readLine();
            }
            arquivo.close();
          } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
            e.getMessage());
            return "30";
          }
        return dados;
    }
}
