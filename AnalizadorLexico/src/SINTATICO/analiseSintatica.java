package SINTATICO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class analiseSintatica{
    
    private static LinkedList<String> listaCodigo;
    private Map<String, Map<String, Integer>> tabelaSintatica;
    
    public analiseSintatica(){
        this.listaCodigo = new LinkedList<>();
        this.tabelaSintatica = new HashMap<>();
    }
    
    public LinkedList<String> getListaCodigo() {
        return listaCodigo;
    }

    public void setListaCodigo(LinkedList<String> listaCodigo) {
        this.listaCodigo = listaCodigo;
    }

    public Map<String, Map<String, Integer>> getTabelaSintatica() {
        return tabelaSintatica;
    }

    public void setTabelaSintatica(Map<String, Map<String, Integer>> tabelaSintatica) {
        this.tabelaSintatica = tabelaSintatica;
    }
    
    
    public void analisadorSintatico(boolean argumento, ArrayList<String> argumentos, LinkedList<String> listaTokens) {

        boolean fim = false;
        tabela t = new tabela();
        setTabelaSintatica(t.mapaTabela());
        String msg = "";
        
        listaCodigo.add("$");
        listaCodigo.add("PROGRAMA");
        
        while (!fim) {
            
            if(listaTokens.isEmpty() && listaCodigo.isEmpty()){
                System.out.println("\nAnálise sintática concluida, nunhum erro encontrado.");
                fim = true;
            } else{
                
                msg += "\n";
                msg += "Topo da lista de tokens: " + listaTokens.peek()+"\n";
                msg += "Topo da lista de codigos: " + listaCodigo.peek();
                
                if(listaTokens.peek().contains(listaCodigo.peek())){
                    listaTokens.pop();
                    listaCodigo.pop();
                }
                
                else if(getTabelaSintatica().containsKey(listaTokens.peek())){
                    
                    Map<String, Integer> lista = getTabelaSintatica().get(listaTokens.peek());
                    
                    if(lista.containsKey(listaCodigo.peek())){
                        
                    }
                }
            }   
        }
    }
}