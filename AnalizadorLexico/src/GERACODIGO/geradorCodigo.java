package GERACODIGO;

import LEXICO.tokens;
import java.util.ArrayList;

public class geradorCodigo {
    
    public static void geracaoCodigo(ArrayList<String> argumentos, ArrayList<tokens> token){
        ArrayList<String> codigo = new ArrayList<>();
        
        for(tokens t : token){
            if(t.getNome().equals("TK_inicio")){
                codigo.add(".386");
                codigo.add(".model flat, stdcall");
                codigo.add("option casemap: none");
                codigo.add("include \\masm32\\include\\windows.inc");
                codigo.add("include \\masm32\\include\\user32.inc");
                codigo.add("include \\masm32\\include\\kernel32.inc");
                codigo.add("includelib \\masm32\\lib\\user32.lib");
                codigo.add("includelib \\masm32\\lib\\kernel32.lib");
            }
        }
        
        for(tokens t : token){
            if(t.getNome().equals("TK_escreva")){
                int indexAtual = token.indexOf(t);
                if(token.get(indexAtual + 2).getLexemas().equals("TK_string")){
                    codigo.add(".data");
                    codigo.add("szCaption   db  'PROGAMA', 0");
                    codigo.add("szText      db  "+"'"+token.get(indexAtual).getLexemas()+"'"+", 0");
                }
            }
        }
        
        codigo.add(".code");
        codigo.add("start:");
        
        for(tokens t : token){
            if(t.getNome().equals("TK_leia")){
                int indexAtual = token.indexOf(t);
                if(token.get(indexAtual + 1).getLexemas().equals("TK_variavel")){
                    codigo.add("mov eax, " + token.get(indexAtual).getLexemas());
                }
            }
        }
        
        /*
        for(tokens t : token){
            if(t.getNome().equals("TK_mult")){
                int indexAtual = token.indexOf(t);
                codigo.add("mov eax, " + token.get(indexAtual - 1).getLexemas());
                codigo.add("mov ebx, " + token.get(indexAtual + 2).getLexemas());
                codigo.add("add eax, abx");
                while (token.get(indexAtual + 1).getLexemas().equals("TK_mult")) {
                    codigo.add("mov ebx, " + token.get(indexAtual + 1).getLexemas());
                    codigo.add("add eax, abx");
                }
            }
        }
        
        for(tokens t : token){
            if(t.getNome().equals("TK_div")){
                int indexAtual = token.indexOf(t);
                codigo.add("mov eax, " + token.get(indexAtual - 1).getLexemas());
                codigo.add("mov ebx, " + token.get(indexAtual + 2).getLexemas());
                codigo.add("add eax, abx");
                while (token.get(indexAtual + 1).getLexemas().equals("TK_div")) {
                    codigo.add("mov ebx, " + token.get(indexAtual + 1).getLexemas());
                    codigo.add("add eax, abx");
                }
            }
        }
        */
        
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
            if(t.getNome().equals("TK_sub")){
                int indexAtual = token.indexOf(t);
                codigo.add("mov eax, " + token.get(indexAtual - 1).getLexemas());
                codigo.add("mov ebx, " + token.get(indexAtual + 2).getLexemas());
                codigo.add("sub eax, abx");
                while (token.get(indexAtual + 1).getLexemas().equals("TK_sub")) {
                    codigo.add("mov ebx, " + token.get(indexAtual + 1).getLexemas());
                    codigo.add("sub eax, abx");
                }
            }
        }
        
        for(tokens t : token){
            if(t.getNome().equals("TK_string")){
                codigo.add("invoke MessageBox, NULL, offset szText, offset szCaption, MB_OK");
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