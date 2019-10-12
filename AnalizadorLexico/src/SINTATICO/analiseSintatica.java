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
        boolean conclusao = false;
        ArrayList<log> lg = new ArrayList<>();
        LinkedList<String> listaCodigo = new LinkedList<>();
        listaCodigo.add("PROGRAMA");

        while (!conclusao){
            if(listaTokens.isEmpty() && listaCodigo.isEmpty()){
                System.out.println("\nAnálise sintática concluida, nenhum erro encontrado.");
                conclusao = true;
            } else{
                lg.add(new log(listaTokens.peek(), listaCodigo.peek()));             
                if(listaTokens.peek().equals(listaCodigo.peek())){
                    listaTokens.pop();
                    listaCodigo.pop();
                }
                else if(getTabelaSintatica().containsKey(listaTokens.peek())){
                    Map<String, Integer> mapaInterno = (getTabelaSintatica().get(listaTokens.peek()));
                    if(mapaInterno.containsKey(listaCodigo.peek())){
                        setListaProducao(SINTATICO.producaoTabela.producoes(mapaInterno.get(listaCodigo.peek())));
                        listaCodigo.pop();
                        if(!getListaProducao().isEmpty()){
                            Collections.reverse(getListaProducao());
                            for(int x = 0; x < getListaProducao().size(); x++){
                                listaCodigo.addFirst(getListaProducao().get(x));
                            }
                        }
                    } else{
                        System.out.println("Erro sintática, token: "+listaTokens.peek()+" em posição irregular\n");
                        conclusao = true;
                        return;
                    }
                } else {
                    System.out.println("Erro sintática, token: "+listaTokens.peek()+" em posição irregular\n");
                    conclusao = true;
                    return;
                }
            }
        }
        if(argumentos.contains("-ls") | argumentos.contains("-tudo")){
            for(log l : lg){
                System.out.println("===========================================================================================\n");
                System.out.println("Token no começo da fila: "+l.getToken()+ "\n" + "Codigo no começo da fila: "+l.getCodigo()+"\n");
            }
        }
    }
}