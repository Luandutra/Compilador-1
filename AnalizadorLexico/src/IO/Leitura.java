package IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Leitura {
    
    public static ArrayList<String> lerArquivo(String endereco){
        
        ArrayList<String> leituraConfiguracao = new ArrayList<>();
        
        try {
            FileReader arquivo = new FileReader(endereco);
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            String linha = "";
            try {                
                while (linha != null) {
                   linha = lerArquivo.readLine();
                   leituraConfiguracao.add(linha + "\n");
                }
                arquivo.close();
                return leituraConfiguracao;
            } catch (IOException e) {
                System.out.println("Erro: Problema na leitura.\n" + e);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Aquivo não encontado.\n" + e);
        }
        return leituraConfiguracao;
    }
    
    
    public static String confirmaPalavra(ArrayList<String> arq) {
        return null;
    }   
}