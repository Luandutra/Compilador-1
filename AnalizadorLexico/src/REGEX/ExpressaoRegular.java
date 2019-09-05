package REGEX;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExpressaoRegular {
    
    public static String Regex(boolean arg, ArrayList<String> arq) {
        
        String linha;

        ArrayList<String> tolkens = new ArrayList<>();
        
        if(arg == false){
            
            for(int x = 0; x < arq.size() - 1; x++){
                
                linha = arq.get(x);

                if(linha.contains("inicio")){
                    tolkens.add("TK_inicio" + ", na linha: " + x + "\n");
                }
                
                if(linha.contains("fim")){
                    tolkens.add("TK_fim" + ", na linha: " + x + "\n");
                }
                
                if(linha.contains("inteiro")){
                    tolkens.add("TK_int" + ", na linha: " + x + "\n");
                }
                
                if(linha.contains("leia")){
                    tolkens.add("TK_leia" + ", na linha: " + x + "\n");
                }
                
                if(linha.contains("escreva")){
                    tolkens.add("TK_escreva" + ", na linha: " + x + "\n");
                }
                
                if(linha.contains("=")){
                    tolkens.add("TK_iqual" + ", na linha: " + x + "\n");
                }
                
                if(linha.contains(";")){
                    tolkens.add("TK_finallinha" + ", na linha: " + x + "\n");
                }
                
                if(linha.contains("enquanto")){
                    tolkens.add("TK_enquanto" + ", na linha: " + x + "\n");
                }
                
                if(linha.contains("(")){
                    tolkens.add("TK_abreparent" + ", na linha: " + x + "\n");
                }
                
                if(linha.contains(")")){
                    tolkens.add("TK_fechaparent" + ", na linha: " + x + "\n");
                }
                
                Pattern pattern = Pattern.compile("[\"_._\"]");
                Matcher matcher = pattern.matcher(linha);
                if(matcher.find()){
                    tolkens.add("TK_string" + ", na linha: " + x + "\n");
                }
                
                /*
                Pattern pattern1 = Pattern.compile("[ a-z|a-z ]");
                Matcher matcher1 = pattern1.matcher(linha);
                if(matcher1.find()){
                    tolkens.add("TK_variavel" + ", na linha: " + x + "\n");
                }
                */
                
            }
        }
        
        System.out.println(tolkens);
        return null;
    }
}