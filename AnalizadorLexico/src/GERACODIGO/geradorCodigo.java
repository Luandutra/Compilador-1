package GERACODIGO;

import LEXICO.tokens;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class geradorCodigo{
    
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
                codigo.add("include \\masm32\\include\\masm32rt.inc");
                codigo.add("");
                codigo.add(".data");
            }
        }
        
        cont = 0;
        for(tokens t : token){
            if(t.getNome().equals("TK_mult") | t.getNome().equals("TK_soma") 
                    | t.getNome().equals("TK_div") | t.getNome().equals("TK_sub") 
                    | t.getNome().equals("TK_leia")){
                if(cont <= 0){
                    codigo.add("var dd 1");
                    cont++;
                }
            }
        }
        
        cont = 0;
        for(tokens t : token){
            if(t.getNome().equals("TK_escreva")){
                for(tokens t1 : token){
                    if(t1.getNome().equals("TK_string")){
                        int indexAtual = token.indexOf(t1);
                        codigo.add("msg  db  "+token.get(indexAtual).getLexemas()+",13,10,0");
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
                if(token.get(indexAtual + 2).getNome().equals("TK_variavel")){
                    codigo.add("mov eax, " + token.get(indexAtual + 2).getLexemas());
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
                }
                else if(token.get(indexAtual + 2).getNome().equals("TK_numpos") 
                        | token.get(indexAtual + 2).getNome().equals("TK_numneg") ){
                    valor1 = token.get(indexAtual + 2).getLexemas();
                    codigo.add("mov eax, " + valor1);
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
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
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
                    cont++;
                }else{
                    codigo.add("mov ebx, " + valor2);
                    codigo.add("imul eax, ebx");
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
                    cont++;
                }
            }
        }
        
        cont = 0;
        for(tokens t : token){
            if(t.getNome().equals("TK_div")){
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
                    codigo.add("sub edx, edx");
                    codigo.add("div ebx");
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
                    cont++;
                }else{
                    codigo.add("mov ebx, " + valor2);
                    codigo.add("sub edx, edx");
                    codigo.add("div ebx");
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
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
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
                    cont++;
                }else{
                    codigo.add("mov ebx, " + valor2);
                    codigo.add("add eax, ebx");
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
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
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
                    cont++;
                }else{
                    codigo.add("mov ebx, " + valor2);
                    codigo.add("sub eax, ebx");
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
                    cont++;
                }
            }
        }
        
        for(tokens t : token){
            if(t.getNome().equals("TK_string")){
                codigo.add("printf(\"A mensagem e: %s\", addr msg)");
                codigo.add("printf(\"\\n\")");
            }
        }
        
        for(tokens t : token){
            if(t.getNome().equals("TK_escreva")){
                int indexAtual = token.indexOf(t);
                if(token.get(indexAtual + 2).getNome().equals("TK_variavel")){
                    codigo.add("printf(\"O valor e: %d\", var)");
                    codigo.add("printf(\"\\n\")");
                }
            }
        }
        
        for(tokens t : token){
            if(t.getNome().equals("TK_leia")){
                codigo.add("printf(\"O valor e: %d\", var)");
                codigo.add("printf(\"\\n\")");
            }
        }

       for(tokens t : token){
            if(t.getNome().equals("TK_fim")){
                codigo.add("inkey");
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
            System.out.println("ERRO: Problema na criação do arquivo -> \n"+e);
        }
    }
}