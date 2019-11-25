package GERACODIGO;

import LEXICO.tokens;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class geradorCodigo {
    
    public static void geracaoCodigo(ArrayList<String> argumentos, ArrayList<tokens> token){
        ArrayList<String> codigo = new ArrayList<>();
        String valor1 = "";
        String valor2 = "";
        int contSoma1 = 2;
        int contSoma2 = 3;
        
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
                if(token.get(indexAtual - 1).getNome().equals("TK_variavel")){
                    String variavel = token.get(indexAtual - 1).getLexemas();
                    for(tokens t1 : token){
                        if(t1.getLexemas().equals(variavel)){
                            int indexAtual1 = token.indexOf(t1);
                            if(token.get(indexAtual1 - 1).getNome().equals("TK_int")){
                                valor1 = token.get(indexAtual1 + 2).getLexemas();
                            }
                        }
                    }
                } else{
                    if(token.get(indexAtual - 1).getNome().equals("TK_numpos") | token.get(indexAtual - 1).getNome().equals("TK_neg")){
                        int indexAtual1 = token.indexOf(t);
                        valor1 = token.get(indexAtual1 - 1).getLexemas();
                    }
                }
                if(token.get(indexAtual + 1).getNome().equals("TK_variavel")){
                    String variavel = token.get(indexAtual + 1).getLexemas();
                    for(tokens t1 : token){
                        if(t1.getLexemas().equals(variavel)){
                            int indexAtual1 = token.indexOf(t1);
                            if(token.get(indexAtual1 - 1).getNome().equals("TK_int")){
                                valor2 = token.get(indexAtual1 + 2).getLexemas();
                            }
                        }
                    }
                } else{
                    if(token.get(indexAtual + 1).getNome().equals("TK_numpos") | token.get(indexAtual - 1).getNome().equals("TK_neg")){
                        int indexAtual1 = token.indexOf(t);
                        valor2 = token.get(indexAtual1 + 1).getLexemas();
                    }
                }

                codigo.add("mov eax, " + valor1);
                codigo.add("mov ebx, " + valor2);
                codigo.add("add eax, abx");
                
                /*
                while(token.get(indexAtual + contSoma1).getLexemas().equals("TK_soma")){
                    if(token.get(indexAtual + contSoma2).getNome().equals("TK_variavel")){
                    String variavel = token.get(indexAtual - 1).getNome();
                    for(tokens t1 : token){
                        if(t1.getNome().equals(variavel)){
                            int indexAtual1 = token.indexOf(t1);
                            valor1 = token.get(indexAtual1).getLexemas();
                        }
                    }
                } else{
                    if(token.get(indexAtual - 1).getNome().equals("TK_numpos") | token.get(indexAtual - 1).getNome().equals("TK_neg")){
                        int indexAtual1 = token.indexOf(t);
                        valor1 = token.get(indexAtual1 - 1).getLexemas();
                    }
                }
                    
                    codigo.add("mov ebx, " + valor2);
                    codigo.add("add eax, abx");
                    contSoma1 = contSoma1 + 2;
                    contSoma2 = contSoma2 + 3;
                }
                */
            }
        }
        
        /*
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
        */
        
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
       
        try {
            FileWriter arquivo = new FileWriter("teste.txt");
            PrintWriter gravaArquivo = new PrintWriter(arquivo);
            for(int i = 0; i < codigo.size(); i++){
                gravaArquivo.println(codigo.get(i));
            }
            gravaArquivo.close();
            System.out.println("Arquivo gravado com sucesso");
        } catch (Exception e) {
        }
    }
}