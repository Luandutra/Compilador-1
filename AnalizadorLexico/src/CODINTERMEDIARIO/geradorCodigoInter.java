package CODINTERMEDIARIO;

public class geradorCodigoInter {
    
}

/*

=================================================BACKUP=================================================

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
        String sinal = "";
        int controle = 0;
        int contSe = 0;
        int contEnq = 0;
        int numMsg = 0;
        int indexAtual = 0;
        boolean liberaSe = false;
        boolean liberaEnq = false;
        
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
        
        controle = 0;
        log.add("\nBloco geral de operadores matematicos:");
        log.add("Buscando operadores matematicos.");
        for(tokens t : token){
            if(t.getNome().equals("TK_mult") | t.getNome().equals("TK_soma") 
                    | t.getNome().equals("TK_div") | t.getNome().equals("TK_sub") 
                    | t.getNome().equals("TK_leia")){
                log.add("Encontrou operadores matematicos.");
                if(controle <= 0){
                    log.add("Inclui uma variavel para armazenamento em memoria.\n");
                    codigo.add("var dd 1");
                    controle++;
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
                        indexAtual = token.indexOf(t1);
                        codigo.add("msg"+ numMsg + " db " + token.get(indexAtual).getLexemas() + ",13,10,0");
                        numMsg++;
                    }
                }
            }
        }
        
        log.add("\nInicia uma seção de código.");
        codigo.add("");
        codigo.add(".code");
        codigo.add("start:");
        
        controle = 0;
        for(tokens t : token){
            log.add("\nBloco TK_leia:");
            log.add("Buscando token leia.");
            if(t.getNome().equals("TK_leia")){
                indexAtual = token.indexOf(t);
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
        
            controle = 0;
            if(t.getNome().equals("TK_se")){
                indexAtual = token.indexOf(t);
                if(token.get(indexAtual + 2).getNome().equals("TK_variavel")){
                    String variavel = token.get(indexAtual + 2).getLexemas();
                    for(tokens t1 : token){
                        if(t1.getLexemas().equals(variavel)){
                            int indexAtual1 = token.indexOf(t1);
                            if(token.get(indexAtual1 - 1).getNome().equals("TK_int")){
                                valor1 = token.get(indexAtual1 + 2).getLexemas();
                            }
                        }
                    }
                } else{
                    if(token.get(indexAtual + 2).getNome().equals("TK_numpos") 
                            | token.get(indexAtual + 2).getNome().equals("TK_neg")){
                        valor1 = token.get(indexAtual + 2).getLexemas();
                    }
                }
                if(token.get(indexAtual + 3).getNome().equals("TK_igualigual") 
                        | token.get(indexAtual + 3).getNome().equals("TK_maior") 
                        | token.get(indexAtual + 3).getNome().equals("TK_menor")){
                    sinal = token.get(indexAtual + 3).getLexemas();
                    if(token.get(indexAtual + 4).getNome().equals("TK_variavel")){
                        String variavel2 = token.get(indexAtual + 4).getLexemas();
                        for(tokens t2 : token){
                            if(t2.getLexemas().equals(variavel2)){
                                int indexAtual2 = token.indexOf(t2);
                                if(token.get(indexAtual2 - 1).getNome().equals("TK_int")){
                                    valor2 = token.get(indexAtual2 + 2).getLexemas();
                                }
                            }
                        }
                    }
                } else{
                    if(token.get(indexAtual + 4).getNome().equals("TK_numpos") 
                            | token.get(indexAtual + 4).getNome().equals("TK_neg")){
                        valor2 = token.get(indexAtual + 4).getLexemas();
                    }
                }
                if(controle <= 0){
                    log.add("Incluindo codigo alimentado.");
                    codigo.add("mov eax, " + valor1);
                    codigo.add("mov ebx, " + valor2);
                    codigo.add(".if eax " + sinal + " ebx");
                    controle++;
                    contSe++;
                }
            }
        
            controle = 0;
            log.add("\nBloco TK_mult:");
            log.add("Buscando token de multiplicação.");
            if(t.getNome().equals("TK_mult")){
                log.add("Encontrou token de multiplicação.");
                indexAtual = token.indexOf(t);
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
                if(controle <= 0){
                    log.add("Incluindo codigo alimentado.");
                    codigo.add("mov eax, " + valor1);
                    codigo.add("mov ebx, " + valor2);
                    codigo.add("imul eax, ebx");
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
                    controle++;
                }else{
                    codigo.add("mov ebx, " + valor2);
                    codigo.add("imul eax, ebx");
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
                    controle++;
                }
            }
        
            controle = 0;
            log.add("\nBloco TK_div:");
            log.add("Buscando token de divisão.");
            if(t.getNome().equals("TK_div")){
                log.add("Encontrou token de divisão.");
                indexAtual = token.indexOf(t);
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
                if(controle <= 0){
                    log.add("Incluindo codigo alimentado.");
                    codigo.add("mov eax, " + valor1);
                    codigo.add("mov ebx, " + valor2);
                    codigo.add("sub edx, edx");
                    codigo.add("div ebx");
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
                    controle++;
                }else{
                    codigo.add("mov ebx, " + valor2);
                    codigo.add("sub edx, edx");
                    codigo.add("div ebx");
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
                    controle++;
                }
            }

            controle = 0;
            log.add("\nBloco TK_soma:");
            log.add("Buscando token de soma.");
            if(t.getNome().equals("TK_soma")){
                log.add("Encontrou token de soma.");
                indexAtual = token.indexOf(t);
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
                if(controle <= 0){
                    log.add("Incluindo codigo alimentado.");
                    codigo.add("mov eax, " + valor1);
                    codigo.add("mov ebx, " + valor2);
                    codigo.add("add eax, ebx");
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
                    controle++;
                }else{
                    codigo.add("mov ebx, " + valor2);
                    codigo.add("add eax, ebx");
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
                    controle++;
                }
            }

            controle = 0;
            log.add("\nBloco TK_sub:");
            log.add("Buscando token de subtração.");
            if(t.getNome().equals("TK_sub")){
                log.add("Encontrou token de subtração.");
                indexAtual = token.indexOf(t);
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
                if(controle <= 0){
                    log.add("Incluindo codigo alimentado.");
                    codigo.add("mov eax, " + valor1);
                    codigo.add("mov ebx, " + valor2);
                    codigo.add("sub eax, ebx");
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
                    controle++;
                }else{
                    codigo.add("mov ebx, " + valor2);
                    codigo.add("sub eax, ebx");
                    codigo.add("mov var, eax");
                    codigo.add("mov eax, var");
                    controle++;
                }
            }
        
            log.add("\nBloco TK_string:");
            log.add("Buscando token de string.");
            if(t.getNome().equals("TK_string")){
                log.add("Encontrou token de string.");
                log.add("Incluindo codigo alimentado.");
                codigo.add("printf(\"A mensagem e: %s\", addr msg)");
                codigo.add("printf(\"\\n\")");
            }
                
            log.add("\nBloco TK_escreva:");
            log.add("Buscando token de escreva.");
            if(t.getNome().equals("TK_escreva")){
                log.add("Encontrou token de string.");
                indexAtual = token.indexOf(t);
                if(token.get(indexAtual + 2).getNome().equals("TK_variavel")){
                    log.add("Encontrou token de variavel.");
                    log.add("Incluindo codigo alimentado.");
                    if(liberaSe = true){
                        codigo.add("printf(\"%d\", eax)");
                        codigo.add("printf(\"\\n\")");
                    }else{
                        codigo.add("printf(\"O valor e: %d\", var)");
                        codigo.add("printf(\"\\n\")");
                    }
                }
            }
        
            log.add("\nBloco TK_leia:");
            log.add("Buscando token de leia.");
            if(t.getNome().equals("TK_leia")){
                log.add("Encontrou token de leia.");
                log.add("Incluindo codigo alimentado.");
                codigo.add("printf(\"O valor e: %d\", var)");
                codigo.add("printf(\"\\n\")");
            }
               
            log.add("\nBloco TK_fim:");
            log.add("Buscando token de fim.");
            if(t.getNome().equals("TK_fim")){
                log.add("Encontrou token de fim.");
                log.add("Incluindo codigo alimentado.");
                if(liberaSe = true){
                    while (contSe > 0) {
                        codigo.add(".endif");
                        contSe--;
                    }
                }
                if(liberaEnq = true){
                    while (contEnq > 0) {
                        codigo.add(".endw");
                        contEnq--;
                    }
                }
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


            if(t.getNome().equals("TK_variavel")){
                indexAtual = token.indexOf(t);
                if(token.get(indexAtual + 1).getNome().equals("TK_incremento")){
                    String variavel = token.get(indexAtual).getLexemas();
                    for(tokens t1 : token){
                        if(t1.getLexemas().equals(variavel)){
                            int indexAtual1 = token.indexOf(t1);
                            valor1 = token.get(indexAtual1).getLexemas();
                        }
                    }
                    codigo.add("mov ecx, " + valor1);
                    codigo.add("inc ecx");
                    controle++; 
                }
            }



            if(t.getNome().equals("TK_variavel")){
                indexAtual = token.indexOf(t);
                if(token.get(indexAtual + 1).getNome().equals("TK_incremento")){
                    codigo.add("inc eax");
                }
            }



            if(t.getNome().equals("TK_variavel")){
                indexAtual = token.indexOf(t);
                if(token.get(indexAtual + 1).getNome().equals("TK_incremento")){
                    codigo.add("inc eax");
                }
            }


*/