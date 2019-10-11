package SINTATICO;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

public class analiseSintatica{
    
    private static Map<String, Map<String, Integer>> tabelaSintatica;
    
    public static Map<String, Map<String, Integer>> getTabelaSintatica() {
        return tabelaSintatica;
    }

    public static void setTabelaSintatica(Map<String, Map<String, Integer>> aTabelaSintatica) {
        tabelaSintatica = aTabelaSintatica;
    }
    
    public analiseSintatica(){
        this.tabelaSintatica = new HashMap<>();
    }
    
    public static void analisadorSintatico(LinkedList<String> listaTokens){
        
        mapaTabela mt = new mapaTabela();
        setTabelaSintatica(mt.tabelaSintatica());
        
        LinkedList<String> listaCodigo = null;
        LinkedList<String> listaProducao = null;
        Map<String, Integer> segundoMapa;
        String msg = null;
        boolean conclusao = false;
        
        //Collections.reverse(listaTokens);
        
        listaCodigo.add("$");
        listaCodigo.add("PROGRAMA");
        
        System.out.println("\nInicio da Análise Sintática\n");
        
        while (!conclusao){
            if(listaTokens.isEmpty() && listaCodigo.isEmpty()){
                System.out.println("\n"+msg+"\n");
                System.out.println("\nAnálise sintática concluida, nehum erro encontrado.");
                conclusao = true;
            } else{
                msg += "==============================================";
                msg += "Topo da lista de tokens: " + listaTokens.peek();
                msg += "Topo da lista de codigo: " + listaCodigo.peek();               
                if(listaTokens.peek().equals(listaCodigo.peek())){
                    listaTokens.pop();
                    listaCodigo.pop();
                }
                else if(getTabelaSintatica().containsKey(listaTokens.peek())){
                    segundoMapa = getTabelaSintatica().get(listaTokens.peek());
                    if(segundoMapa.containsKey(listaCodigo.peek())){
                        listaProducao = SINTATICO.producaoTabela.producoes(segundoMapa.get(listaCodigo.peek()));
                        listaCodigo.pop();
                        if(!listaProducao.isEmpty()){
                            for(int x = 0; x < listaProducao.size(); x++){
                                listaCodigo.add(listaProducao.get(x));
                            }
                        }
                    } else{
                        System.out.println("\nERRO\n");
                        System.out.println("Token: "+listaTokens.peek());
                        conclusao = true;
                    }
                } else {
                    System.out.println("\nERRO\n");
                    System.out.println("Token: "+listaTokens.peek());
                    conclusao = true;
                }
            }
        }
        System.out.println(msg);
    }
}