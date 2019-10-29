package SEMANTICO;

import LEXICO.tokens;
import java.util.ArrayList;

public class analiseSemantica {
    
    static ArrayList<String> arg = new ArrayList<>();
    static String msg = "";
    static boolean erro = false;
    
    public static void analizadorSemantico(ArrayList<String> argumentos, ArrayList<tokens> token){
        variaveisIniciadas(token);
        declaracaoVarRepetidas(token);
        //divisaoZero(token);
    }
    
    
    public static void variaveisIniciadas(ArrayList<tokens> token){
        msg = "";
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
            return;
        }
    }
    
    public static void declaracaoVarRepetidas(ArrayList<tokens> token){
        msg = "";
        ArrayList<String> var = new ArrayList<>();
        
        for(tokens t : token){
            if(t.getNome().equals("TK_variavel")){
                int index = token.indexOf(t);
                if(token.get(index - 1).getNome().equals("TK_int")){
                    var.add(t.getLexemas());
                }
            }
        }
        
        for(int i = 0; i < var.size(); i++){
            for(int j = 0; j < var.size(); j++){
                if(j != i){
                    if(var.get(i).equals(var.get(j))){
                        erro = true;
                        msg += ("\nERRO SEMÂNTICO\n");
                        msg += ("\nVariavel: "+var.get(i)+" possui mais de uma declaração!");
                        imprimeMSG(erro, msg);
                        return;
                    }
                }
            }
        }
        
        erro = false;
        msg += ("\nAnálise semântica concluida com sucesso, nenhuma declaração de variável duplicada!\n");
        imprimeMSG(erro, msg);
    }
    
    public static void divisaoZero(ArrayList<tokens> token){
        msg = "";
        ArrayList<String> div = new ArrayList<>();
        
        for(tokens t : token){
            if(t.getNome().equals("TK_div")){
                int index = token.indexOf(t);
                if(token.get(index + 1).getNome().equals("TK_variavel")){
                    div.add(t.getLexemas());
                    if(div.equals(0)){
                        erro = true;
                        msg += ("\nERRO SEMÂNTICO\n");
                        msg += ("\nDivisão por zero, "+"linha: "+t.getLinha()+" | "+"coluna: "+t.getColuna());
                        imprimeMSG(erro, msg);
                    }
                }
            }
        }
        
        erro = false;
        msg += ("\nAnálise semântica concluida com sucesso, nenhuma divisão por zero encontrada!\n");
        imprimeMSG(erro, msg);
    }
    
    public static void imprimeMSG(boolean erro, String msg){
        if(erro == false){
            System.out.println(msg);
        } else{
            System.out.println(msg);
        }
    }
}