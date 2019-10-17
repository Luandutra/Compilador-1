package SINTATICO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

public class analiseSintatica{
    
    private static Map<String, Map<String, Integer>> tabelaSintatica;
    private static LinkedList<String> listaProducao;
    
    public analiseSintatica(){
        this.tabelaSintatica = new HashMap<>();
        this.listaProducao = new LinkedList<>();
    }
    
    public static Map<String, Map<String, Integer>> getTabelaSintatica() {
        return tabelaSintatica;
    }

    public static void setTabelaSintatica(Map<String, Map<String, Integer>> aTabelaSintatica) {
        tabelaSintatica = aTabelaSintatica;
    }

    public static LinkedList<String> getListaProducao() {
        return listaProducao;
    }

    public static void setListaProducao(LinkedList<String> aListaProducao) {
        listaProducao = aListaProducao;
    }
    
    public static void analisadorSintatico(ArrayList<String> argumentos, LinkedList<String> listaTokens){
        
        mapaTabela mt = new mapaTabela();
        setTabelaSintatica(mt.tabelaSintatica());
        ArrayList<String> log = new ArrayList<>();
        boolean conclusao = false;
        
        LinkedList<String> listaProducao = new LinkedList<>();
        listaProducao.add("PROGRAMA"); 

        while (!conclusao){
            if(listaTokens.isEmpty() && listaProducao.isEmpty()){
                System.out.println("\nAnálise sintática concluida com sucesso, nenhum erro encontrado!\n");
                conclusao = true;
            } else{ 
                log.add("\nToken no começo da lista: "+listaTokens.peek());
                log.add("Produção no começo da lista: "+listaProducao.peek()+"\n");
                if(listaTokens.peek().equals(listaProducao.peek())){
                    log.add("Removeu o token do começo da lista: "+listaTokens.peek()+"\n"+"Removeu a produção do começo da lista: "+listaProducao.peek()+"\n");
                    listaTokens.pop();
                    listaProducao.pop();
                }
                else if(getTabelaSintatica().containsKey(listaTokens.peek())){
                    Map<String, Integer> mapaInterno = (getTabelaSintatica().get(listaTokens.peek()));
                    if(mapaInterno.containsKey(listaProducao.peek())){
                        setListaProducao(SINTATICO.producaoTabela.producoes(mapaInterno.get(listaProducao.peek())));
                        log.add("Removeu a produção do começo da lista: "+listaProducao.peek()+"\n");
                        listaProducao.pop();
                        if(!getListaProducao().isEmpty()){
                            for(int x = 0; x < getListaProducao().size(); x++){
                                listaProducao.addFirst(getListaProducao().get(x));
                                log.add("Adicionou a produção ao começo da lista: "+getListaProducao().get(x));
                            }
                        }
                    } else{
                        System.out.println("\nErro sintático, token: "+listaTokens.peek()+" em posição irregular\n");
                        conclusao = true;
                        return;
                    }
                } else{
                    System.out.println("\nErro sintático, token: "+listaTokens.peek()+" em posição irregular\n");
                    conclusao = true;
                    return;
                }
            }
        }
        if(argumentos.contains("-ls") | argumentos.contains("-tudo")){
            System.out.println("\n==================================================================\n");
            System.out.println("==============================LOG=================================\n");
            System.out.println("==================================================================\n");
            for(int x = 0; x < log.size(); x++){
                System.out.println(log.get(x));
            }
        }
    }
}