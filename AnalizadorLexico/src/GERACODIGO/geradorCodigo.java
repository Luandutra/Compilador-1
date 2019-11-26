package GERACODIGO;

import LEXICO.tokens;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class geradorCodigo {
    
    public static void geracaoCodigo(ArrayList<String> argumentos, ArrayList<tokens> token){
        ArrayList<String> codigo = new ArrayList<>();
        String valor1 = "";
        String valor2 = "";
        int cont = 0;
        
        for(tokens t : token){
            if(t.getNome().equals("TK_inicio")){
                codigo.add(".386");
                codigo.add(".model flat, stdcall");
                codigo.add("option casemap: none");
                codigo.add("");
                codigo.add("include \\masm32\\include\\windows.inc");
                codigo.add("include \\masm32\\include\\user32.inc");
                codigo.add("include \\masm32\\include\\kernel32.inc");
                codigo.add("includelib \\masm32\\lib\\user32.lib");
                codigo.add("includelib \\masm32\\lib\\kernel32.lib");
                codigo.add("");
            }
        }
        
        for(tokens t : token){
            if(t.getNome().equals("TK_escreva")){
                for(tokens t1 : token){
                    if(t1.getNome().equals("TK_string")){
                        int indexAtual = token.indexOf(t1);
                        codigo.add(".data");
                        codigo.add("szCaption   db  'PROGAMA', 0");
                        codigo.add("szText      db  "+"'"+token.get(indexAtual).getLexemas()+"'"+", 0");
                        codigo.add("");
                    }
                }
            }
        }
        
        codigo.add(".code");
        codigo.add("start:");
        
        for(tokens t : token){
            if(t.getNome().equals("TK_leia")){
                int indexAtual = token.indexOf(t);
                if(token.get(indexAtual + 2).getLexemas().equals("TK_variavel")){
                    codigo.add("mov eax, " + token.get(indexAtual + 2).getLexemas());
                }
            }
        }
        
        cont = 0;
        for(tokens t : token){
            if(t.getNome().equals("TK_mult")){
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
                    if(token.get(indexAtual - 1).getNome().equals("TK_numpos") 
                            | token.get(indexAtual - 1).getNome().equals("TK_neg")){
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
                    if(token.get(indexAtual + 1).getNome().equals("TK_numpos") 
                            | token.get(indexAtual - 1).getNome().equals("TK_neg")){
                        int indexAtual1 = token.indexOf(t);
                        valor2 = token.get(indexAtual1 + 1).getLexemas();
                    }
                }
                if(cont <= 0){
                    codigo.add("mov eax, " + valor1);
                    codigo.add("mov ebx, " + valor2);
                    codigo.add("imul eax, ebx");
                    cont++;
                }else{
                    codigo.add("mov ebx, " + valor2);
                    codigo.add("imul eax, ebx");
                    cont++;
                }
            }
        }
        
        cont = 0;
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
                    if(token.get(indexAtual - 1).getNome().equals("TK_numpos") 
                            | token.get(indexAtual - 1).getNome().equals("TK_neg")){
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
                    if(token.get(indexAtual + 1).getNome().equals("TK_numpos") 
                            | token.get(indexAtual - 1).getNome().equals("TK_neg")){
                        int indexAtual1 = token.indexOf(t);
                        valor2 = token.get(indexAtual1 + 1).getLexemas();
                    }
                }               
                if(cont <= 0){
                    codigo.add("mov eax, " + valor1);
                    codigo.add("mov ebx, " + valor2);
                    codigo.add("add eax, ebx");
                    cont++;
                }else{
                    codigo.add("mov ebx, " + valor2);
                    codigo.add("add eax, ebx");
                    cont++;
                }
            }
        }
        
        cont = 0;
        for(tokens t : token){
            if(t.getNome().equals("TK_sub")){
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
                    if(token.get(indexAtual - 1).getNome().equals("TK_numpos") 
                            | token.get(indexAtual - 1).getNome().equals("TK_neg")){
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
                    if(token.get(indexAtual + 1).getNome().equals("TK_numpos") 
                            | token.get(indexAtual - 1).getNome().equals("TK_neg")){
                        int indexAtual1 = token.indexOf(t);
                        valor2 = token.get(indexAtual1 + 1).getLexemas();
                    }
                } 
                if(cont <= 0){
                    codigo.add("mov eax, " + valor1);
                    codigo.add("mov ebx, " + valor2);
                    codigo.add("sub eax, ebx");
                    cont++;
                }else{
                    codigo.add("mov ebx, " + valor2);
                    codigo.add("sub eax, ebx");
                    cont++;
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
       
        try {
            FileWriter arquivo = new FileWriter("codigo.asm");
            try (PrintWriter gravaArquivo = new PrintWriter(arquivo)) {
                for(int i = 0; i < codigo.size(); i++){
                    gravaArquivo.println(codigo.get(i));
                }
            }
            System.out.println("\nGeração de codigo realizada com sucesso.");
        } catch (IOException e){
            System.out.println("ERRO: Problema na criação do arquivo -> "+e);
        }
    }
}