package GERACODIGO;

import LEXICO.tokens;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

public class geradorCodigo{
    
    public static void geracaoCodigo(ArrayList<String> argumentos, ArrayList<tokens> token){
        ArrayList<String> codigo = new ArrayList<>();
        LinkedList<String> log = new LinkedList<>();
        String valor1 = "";
        String valor2 = "";
        int cont = 0;
        
        for(tokens t : token){
            if(t.getNome().equals("TK_inicio")){
                log.add("Bloco inicial:");
                log.add("Inclui informações basicas como: conjunto de instruções, modelo de endereçamento, calling convention, headers, etc.");
                log.add("Inclui uma nova seção de dados.");
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
        log.add("\nBloco geral de operadores matematicos:");
        log.add("Buscando operadores matematicos.");
        for(tokens t : token){
            if(t.getNome().equals("TK_mult") | t.getNome().equals("TK_soma") 
                    | t.getNome().equals("TK_div") | t.getNome().equals("TK_sub") 
                    | t.getNome().equals("TK_leia")){
                log.add("Encontrou operadores matematicos.");
                if(cont <= 0){
                    log.add("Inclui uma variavel para armazenamento em memoria.\n");
                    codigo.add("var dd 1");
                    codigo.add("");
                    cont++;
                }
            }
        }
        
        log.add("\nBloco TK_escreva:");
        log.add("Buscando token escreva.");
        for(tokens t : token){
            if(t.getNome().equals("TK_escreva")){
                log.add("Encontrou token escreva.");
                for(tokens t1 : token){
                    if(t1.getNome().equals("TK_string")){
                        log.add("Inclui uma variavel tipo string.");
                        int indexAtual = token.indexOf(t1);
                        codigo.add("msg  db  "+token.get(indexAtual).getLexemas()+",13,10,0");
                        codigo.add("");
                    }
                }
            }
        }
        
        log.add("\nInicia uma seção de código.");
        codigo.add(".code");
        codigo.add("start:");
        
        log.add("\nBloco TK_leia:");
        log.add("Buscando token leia.");
        for(tokens t : token){
            if(t.getNome().equals("TK_leia")){
                int indexAtual = token.indexOf(t);
                if(token.get(indexAtual + 2).getNome().equals("TK_variavel")){
                    log.add("Encontrou token variavel.");
                    codigo.add("mov eax, " + token.get(indexAtual + 2).getLexemas());
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
                }
                else if(token.get(indexAtual + 2).getNome().equals("TK_numpos") 
                        | token.get(indexAtual + 2).getNome().equals("TK_numneg") ){
                    valor1 = token.get(indexAtual + 2).getLexemas();
                    log.add("Incluindo codigo alimentado.");
                    codigo.add("mov eax, " + valor1);
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
                }
            }
        }
        
        cont = 0;
        log.add("\nBloco TK_mult:");
        log.add("Buscando token de multiplicação.");
        for(tokens t : token){
            if(t.getNome().equals("TK_mult")){
                log.add("Encontrou token de multiplicação.");
                int indexAtual = token.indexOf(t);
                if(token.get(indexAtual - 1).getNome().equals("TK_variavel")){
                    log.add("Encontrou token de variavel.");
                    String variavel = token.get(indexAtual - 1).getLexemas();
                    for(tokens t1 : token){
                        if(t1.getLexemas().equals(variavel)){
                            int indexAtual1 = token.indexOf(t1);
                            if(token.get(indexAtual1 - 1).getNome().equals("TK_int")){
                                log.add("Encontrou token de declaração.");
                                valor1 = token.get(indexAtual1 + 2).getLexemas();
                            }
                        }
                    }
                } else{
                    if(token.get(indexAtual - 1).getNome().equals("TK_numpos") 
                            | token.get(indexAtual - 1).getNome().equals("TK_neg")){
                        log.add("Encontrou token de numero.");
                        int indexAtual1 = token.indexOf(t);
                        valor1 = token.get(indexAtual1 - 1).getLexemas();
                    }
                }
                if(token.get(indexAtual + 1).getNome().equals("TK_variavel")){
                    log.add("Encontrou token de variavel.");
                    String variavel = token.get(indexAtual + 1).getLexemas();
                    for(tokens t1 : token){
                        if(t1.getLexemas().equals(variavel)){
                            int indexAtual1 = token.indexOf(t1);
                            if(token.get(indexAtual1 - 1).getNome().equals("TK_int")){
                                log.add("Encontrou token de declaração.");
                                valor2 = token.get(indexAtual1 + 2).getLexemas();
                            }
                        }
                    }
                } else{
                    log.add("Buscando token de numero.");
                    if(token.get(indexAtual + 1).getNome().equals("TK_numpos") 
                            | token.get(indexAtual - 1).getNome().equals("TK_neg")){
                        log.add("Encontrou token de numero.");
                        int indexAtual1 = token.indexOf(t);
                        valor2 = token.get(indexAtual1 + 1).getLexemas();
                    }
                }
                if(cont <= 0){
                    log.add("Incluindo codigo alimentado.");
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
        log.add("\nBloco TK_div:");
        log.add("Buscando token de divisão.");
        for(tokens t : token){
            if(t.getNome().equals("TK_div")){
                log.add("Encontrou token de divisão.");
                int indexAtual = token.indexOf(t);
                if(token.get(indexAtual - 1).getNome().equals("TK_variavel")){
                    log.add("Encontrou token de variavel.");
                    String variavel = token.get(indexAtual - 1).getLexemas();
                    for(tokens t1 : token){
                        if(t1.getLexemas().equals(variavel)){
                            int indexAtual1 = token.indexOf(t1);
                            if(token.get(indexAtual1 - 1).getNome().equals("TK_int")){
                                log.add("Encontrou token de declaração.");
                                valor1 = token.get(indexAtual1 + 2).getLexemas();
                            }
                        }
                    }
                } else{
                    if(token.get(indexAtual - 1).getNome().equals("TK_numpos") 
                            | token.get(indexAtual - 1).getNome().equals("TK_neg")){
                        log.add("Encontrou token de numero.");
                        int indexAtual1 = token.indexOf(t);
                        valor1 = token.get(indexAtual1 - 1).getLexemas();
                    }
                }                
                if(token.get(indexAtual + 1).getNome().equals("TK_variavel")){
                    log.add("Encontrou token de variavel.");
                    String variavel = token.get(indexAtual + 1).getLexemas();
                    for(tokens t1 : token){
                        if(t1.getLexemas().equals(variavel)){
                            int indexAtual1 = token.indexOf(t1);
                            if(token.get(indexAtual1 - 1).getNome().equals("TK_int")){
                                log.add("Encontrou token de declaração.");
                                valor2 = token.get(indexAtual1 + 2).getLexemas();
                            }
                        }
                    }
                } else{
                    if(token.get(indexAtual + 1).getNome().equals("TK_numpos") 
                            | token.get(indexAtual - 1).getNome().equals("TK_neg")){
                        log.add("Encontrou token de numero.");
                        int indexAtual1 = token.indexOf(t);
                        valor2 = token.get(indexAtual1 + 1).getLexemas();
                    }
                }               
                if(cont <= 0){
                    log.add("Incluindo codigo alimentado.");
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
        log.add("\nBloco TK_soma:");
        log.add("Buscando token de soma.");
        for(tokens t : token){
            if(t.getNome().equals("TK_soma")){
                log.add("Encontrou token de soma.");
                int indexAtual = token.indexOf(t);
                if(token.get(indexAtual - 1).getNome().equals("TK_variavel")){
                    log.add("Encontrou token de variavel.");
                    String variavel = token.get(indexAtual - 1).getLexemas();
                    for(tokens t1 : token){
                        if(t1.getLexemas().equals(variavel)){
                            int indexAtual1 = token.indexOf(t1);
                            if(token.get(indexAtual1 - 1).getNome().equals("TK_int")){
                                log.add("Encontrou token de declaração.");
                                valor1 = token.get(indexAtual1 + 2).getLexemas();
                            }
                        }
                    }
                } else{
                    if(token.get(indexAtual - 1).getNome().equals("TK_numpos") 
                            | token.get(indexAtual - 1).getNome().equals("TK_neg")){
                        log.add("Encontrou token de numero.");
                        int indexAtual1 = token.indexOf(t);
                        valor1 = token.get(indexAtual1 - 1).getLexemas();
                    }
                }                
                if(token.get(indexAtual + 1).getNome().equals("TK_variavel")){
                    log.add("Encontrou token de variavel.");
                    String variavel = token.get(indexAtual + 1).getLexemas();
                    for(tokens t1 : token){
                        if(t1.getLexemas().equals(variavel)){
                            int indexAtual1 = token.indexOf(t1);
                            if(token.get(indexAtual1 - 1).getNome().equals("TK_int")){
                                log.add("Encontrou token de declaração.");
                                valor2 = token.get(indexAtual1 + 2).getLexemas();
                            }
                        }
                    }
                } else{
                    if(token.get(indexAtual + 1).getNome().equals("TK_numpos") 
                            | token.get(indexAtual - 1).getNome().equals("TK_neg")){
                        log.add("Encontrou token de numero.");
                        int indexAtual1 = token.indexOf(t);
                        valor2 = token.get(indexAtual1 + 1).getLexemas();
                    }
                }               
                if(cont <= 0){
                    log.add("Incluindo codigo alimentado.");
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
        log.add("\nBloco TK_sub:");
        log.add("Buscando token de subtração.");
        for(tokens t : token){
            if(t.getNome().equals("TK_sub")){
                log.add("Encontrou token de subtração.");
                int indexAtual = token.indexOf(t);
                if(token.get(indexAtual - 1).getNome().equals("TK_variavel")){
                    log.add("Encontrou token de variavel.");
                    String variavel = token.get(indexAtual - 1).getLexemas();
                    for(tokens t1 : token){
                        if(t1.getLexemas().equals(variavel)){
                            int indexAtual1 = token.indexOf(t1);
                            if(token.get(indexAtual1 - 1).getNome().equals("TK_int")){
                                log.add("Encontrou token de declaração.");
                                valor1 = token.get(indexAtual1 + 2).getLexemas();
                            }
                        }
                    }
                } else{
                    if(token.get(indexAtual - 1).getNome().equals("TK_numpos") 
                            | token.get(indexAtual - 1).getNome().equals("TK_neg")){
                        log.add("Encontrou token de numero.");
                        int indexAtual1 = token.indexOf(t);
                        valor1 = token.get(indexAtual1 - 1).getLexemas();
                    }
                } 
                if(token.get(indexAtual + 1).getNome().equals("TK_variavel")){
                    log.add("Encontrou token de variavel.");
                    String variavel = token.get(indexAtual + 1).getLexemas();
                    for(tokens t1 : token){
                        if(t1.getLexemas().equals(variavel)){
                            int indexAtual1 = token.indexOf(t1);
                            if(token.get(indexAtual1 - 1).getNome().equals("TK_int")){
                                log.add("Encontrou token de declaração.");
                                valor2 = token.get(indexAtual1 + 2).getLexemas();
                            }
                        }
                    }
                } else{
                    if(token.get(indexAtual + 1).getNome().equals("TK_numpos") 
                            | token.get(indexAtual - 1).getNome().equals("TK_neg")){
                        log.add("Encontrou token de numero.");
                        int indexAtual1 = token.indexOf(t);
                        valor2 = token.get(indexAtual1 + 1).getLexemas();
                    }
                } 
                if(cont <= 0){
                    log.add("Incluindo codigo alimentado.");
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
        
        log.add("\nBloco TK_string:");
        log.add("Buscando token de string.");
        for(tokens t : token){
            if(t.getNome().equals("TK_string")){
                log.add("Encontrou token de string.");
                log.add("Incluindo codigo alimentado.");
                codigo.add("printf(\"A mensagem e: %s\", addr msg)");
                codigo.add("printf(\"\\n\")");
            }
        }
        
        log.add("\nBloco TK_escreva:");
        log.add("Buscando token de escreva.");
        for(tokens t : token){
            if(t.getNome().equals("TK_escreva")){
                log.add("Encontrou token de string.");
                int indexAtual = token.indexOf(t);
                if(token.get(indexAtual + 2).getNome().equals("TK_variavel")){
                    log.add("Encontrou token de variavel.");
                    log.add("Incluindo codigo alimentado.");
                    codigo.add("printf(\"O valor e: %d\", var)");
                    codigo.add("printf(\"\\n\")");
                }
            }
        }
        
        log.add("\nBloco TK_leia:");
        log.add("Buscando token de leia.");
        for(tokens t : token){
            if(t.getNome().equals("TK_leia")){
                log.add("Encontrou token de leia.");
                log.add("Incluindo codigo alimentado.");
                codigo.add("printf(\"O valor e: %d\", var)");
                codigo.add("printf(\"\\n\")");
            }
        }
        
       log.add("\nBloco TK_fim:");
       log.add("Buscando token de fim.");
       for(tokens t : token){
            if(t.getNome().equals("TK_fim")){
                log.add("Encontrou token de fim.");
                log.add("Incluindo codigo alimentado.");
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
            log.addFirst("\n==============================LOG=================================\n");
            log.addFirst("\nGeração de codigo:");
            log.addLast("\nGeração de codigo realizada com sucesso!");
            if(argumentos.contains("-lgc") | argumentos.contains("-tudo")){
                for(int i = 0; i < log.size(); i++){
                    System.out.println(log.get(i));
                }
            } else{
                System.out.println("\nGeração de codigo realizada com sucesso!");
            }
        } catch (IOException e){
            System.out.println("ERRO: Problema na criação do arquivo -> \n"+e);
        }
    }
}