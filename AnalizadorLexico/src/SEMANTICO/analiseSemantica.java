package SEMANTICO;

import LEXICO.tokens;
import java.util.ArrayList;

public class analiseSemantica {
    
    static String msg = "";
    static boolean erro = false;
    
    public static void analizadorSemantico(ArrayList<tokens> token){
        variaveisIniciadas(token);
        //variaveisRepetidas(token);
        //divisaoZero(token);
    }
    
    public static void variaveisIniciadas(ArrayList<tokens> token){
        
        ArrayList<String> varGeral = new ArrayList<>();
        ArrayList<String> varIniciadas = new ArrayList<>();
        
        for(tokens t : token){
            if(t.getNome().equals("TK_variavel")){
                varGeral.add(t.getNome());
                varGeral.add(t.getLexemas());
                int index = token.indexOf(t);
                if(token.get(index - 1).getNome().equals("TK_int")){
                    varIniciadas.add(t.getNome());
                    varIniciadas.add(t.getLexemas());
                }
            }
        }
        
        varGeral.removeAll(varIniciadas);
        
        if(varGeral.isEmpty()){
            erro = false;
            msg += ("\nAnálise semântica concluida com sucesso, todas as variáveis iniciadas!\n");
            imprimeMSG(erro, msg);
        } else{
            erro = true;
            msg += ("\nERRO SEMÂNTICO\n");
            msg += ("\nVariavel: "+varGeral+" não iniciada!");
            imprimeMSG(erro, msg);
        }
    }
    
    public static void variaveisRepetidas(ArrayList<tokens> token){
        
    }
    
    public static void divisaoZero(ArrayList<tokens> token){
        
    }
    
    public static void imprimeMSG(boolean erro, String msg){
        if(erro == false){
            System.out.println(msg);
        } else{
            System.out.println(msg);
            return;
        }
    }
}