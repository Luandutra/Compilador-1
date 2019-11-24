package GERACODIGO;

import LEXICO.tokens;
import java.util.ArrayList;

public class geradorCodigo {
    
    public static void geracaoCodigo(ArrayList<String> argumentos, ArrayList<tokens> token){
        ArrayList<String> codigo = new ArrayList<>();
        
        codigo.add(".386");
        codigo.add(".model flat, stdcall");
        codigo.add("option casemap: none");
        codigo.add("include \\masm32\\include\\windows.inc");
        codigo.add("include \\masm32\\include\\user32.inc");
        codigo.add("include \\masm32\\include\\kernel32.inc");
        codigo.add("includelib \\masm32\\lib\\user32.lib");
        codigo.add("includelib \\masm32\\lib\\kernel32.lib");
        
        /*
        for(tokens t : token){
            if(t.getNome().equals("TK_variavel")){
                codigo.add(".data");
                // definição de variaveis?
            }
        }
        */
        
        for(tokens t : token){
            if(t.getNome().equals("TK_inicio")){
                codigo.add(".code");
                codigo.add("start:");
            }
        }
        
        for(tokens t : token){
            if(t.getNome().equals("TK_soma")){
                int indexAtual = token.indexOf(t);
                codigo.add("mov eax, " + token.get(indexAtual - 1).getLexemas());
                codigo.add("mov ebx, " + token.get(indexAtual + 2).getLexemas());
                codigo.add("add eax, abx");
                while (token.get(indexAtual + 1).getLexemas().equals("TK_soma")) {
                    codigo.add("mov ebx, " + token.get(indexAtual + 1).getLexemas());
                    codigo.add("add eax, abx");
                }
            }
        }

       for(tokens t : token){
            if(t.getNome().equals("TK_fim")){
                codigo.add("invoke ExitProcess, NULL");
                codigo.add("end start");
            }
        } 
    }
}