package USR;

import java.io.IOException;
import java.util.ArrayList;

public class Comeco {
    public static void main(String[] args) throws IOException{

        ArrayList<String> arguemtos = new ArrayList<>();
        
        String reservadas = "C:\\Users\\Dheyk\\Desktop\\Analizador Lexico\\Config\\reservadas.txt";
        
        boolean arg = false;

        if(args.length > 0){
            for(int x = 0; x < args.length; x++){
                arguemtos.add(args[x]);
                System.out.println(arguemtos);
            }
        }
        
        String arquivo = arguemtos.get(0);

        if(arguemtos.contains("-lt")){
            arg = true;
        }else{
            arg = false;
        }

        try {

            ArrayList<String> arq = IO.leitura.lerArquivo(arquivo);
            ArrayList<String> res = IO.leitura.lerArquivo(reservadas);

            if(!arq.isEmpty()){
                if(!arquivo.isEmpty() && !reservadas.isEmpty()){
                    LEXICO.analiseLexica.ComparadorRegex(arg, arguemtos, res, arq);
                } else{
                    System.out.println("Erro: Arquivo esta vazio ou em branco.");
                }
            } else{
                System.out.println("Erro: Arquivo de configuração vazio.");
            }
        } catch (Exception e) {
            System.out.println("Erro: Problema na leitura do arquivo.\n" + e);
        }
    }
}