package SINTATICO;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class analiseSintatica{
    
    private Map<String, Map<String, Integer>> tabelaSintatica;
    
    public Map<String, Map<String, Integer>> getTabelaSintatica() {
        return tabelaSintatica;
    }

    public void setTabelaSintatica(Map<String, Map<String, Integer>> tabelaSintatica) {
        this.tabelaSintatica = tabelaSintatica;
    }
    
    public analiseSintatica(){
        this.tabelaSintatica = new HashMap<>();
    }
    
    public void geraTabela(){
        mapaTabela m = new mapaTabela();
        setTabelaSintatica(m.tabelaSintatica());
    }
    
    public static void analisadorSintatico(LinkedList<String> listaTokens){
        
        LinkedList<String> listaCodigo = null;
        String msg = null;
        boolean fim = false;
        
        listaTokens.add("$");
        listaTokens.add("PROGRAMA");
        
        System.out.println("\nInicio da Análise Sintática\n");
        
        while (!fim){
            
            if(listaTokens.isEmpty() && listaCodigo.isEmpty()){
                System.out.println("\n"+msg+"\n");
                System.out.println("\nAnálise sintática concluida, nehum erro encontrado.");
                fim = true;
            } else{
                msg += "==============================================";
                msg += "Topo da lista de tokens: " + listaTokens.peek();
                msg += "Topo da lista de codigo: " + listaCodigo.peek();
                
                if(fim){
                    
                }
            }
        }
    }
}