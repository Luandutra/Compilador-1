package USR;

import java.io.IOException;
import java.util.ArrayList;

public class Comeco {
    public static void main(String[] args) throws IOException{

        ArrayList<String> arguemtos = new ArrayList<>();

        String reservadas = "C:\\Users\\DKtga\\Desktop\\Analizador Lexico\\Config\\reservadas.txt";

        String arquivo = "C:\\Users\\DKtga\\Desktop\\Analizador Lexico\\Config\\fatorial.txt";

        boolean arg = false;

        if(args.length > 0){
            for(int x = 0; x < args.length; x++){
                arguemtos.add(args[x]);
            }
        }

        if(arguemtos.contains("-tl")){
            arg = true;
        }else{
            arg = false;
        }

        try {

            ArrayList<String> arq = IO.Leitura.lerArquivo(arquivo);
            ArrayList<String> res = IO.Leitura.lerArquivo(reservadas);

            if(!arq.isEmpty()){
                if(!arquivo.isEmpty() && !reservadas.isEmpty()){
                    REGEX.ExpressaoRegular.ComparadorRegex(arg, arguemtos, res, arq);
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