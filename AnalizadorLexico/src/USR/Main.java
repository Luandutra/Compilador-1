package USR;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{
        
        String arquivo = "C:\\Users\\DKtga\\Desktop\\Analizador Lexico\\Config\\fatorial.txt";
        
        try {
            ArrayList<String> arq = IO.Leitura.lerArquivo(arquivo);
            if(!arq.isEmpty()){
                if(!arquivo.isEmpty() && !arquivo.isBlank()){
                    System.out.println(IO.Leitura.confirmaPalavra(arq));
                } else{
                    System.out.println("Erro: Palavra esta vazio ou em branco.");
                }
            } else{
                System.out.println("Erro: Arquivo de configuração vazio.");
            }
        } catch (Exception e) {
            System.out.println("Erro: Problema na leitura.\n" + e);
        }
    }
}