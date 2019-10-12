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
        LinkedList<String> listaProducao = new LinkedList<>();
        listaProducao.add("PROGRAMA");

        while (!conclusao){
            if(listaTokens.isEmpty() && listaProducao.isEmpty()){
                System.out.println("\nAnálise sintática concluida com sucesso, nenhum erro encontrado!\n");
                conclusao = true;
            } else{
                lg.add(new log(listaTokens.peek(), listaProducao.peek()));             
                if(listaTokens.peek().equals(listaProducao.peek())){
                    listaTokens.pop();
                    listaProducao.pop();
                }
                else if(getTabelaSintatica().containsKey(listaTokens.peek())){
                    Map<String, Integer> mapaInterno = (getTabelaSintatica().get(listaTokens.peek()));
                    if(mapaInterno.containsKey(listaProducao.peek())){
                        setListaProducao(SINTATICO.producaoTabela.producoes(mapaInterno.get(listaProducao.peek())));
                        listaProducao.pop();
                        if(!getListaProducao().isEmpty()){
                            Collections.reverse(getListaProducao());
                            for(int x = 0; x < getListaProducao().size(); x++){
                                listaProducao.addFirst(getListaProducao().get(x));
                            }
                        }
                    } else{
                        System.out.println("Erro sintático, token: "+listaTokens.peek()+" em posição irregular\n");
                        conclusao = true;
                        return;
                    }
                } else {
                    System.out.println("Erro sintático, token: "+listaTokens.peek()+" em posição irregular\n");
                    conclusao = true;
                    return;
                }
            }
        }
        if(argumentos.contains("-ls") | argumentos.contains("-tudo")){
            System.out.println("==================================================================\n");
            System.out.println("==============================LOG=================================\n");
            for(log l : lg){
                System.out.println("==================================================================\n");
                System.out.println("Token no começo da fila: "+l.getToken()+ "\n" + "Produção no começo da fila: "+l.getCodigo()+"\n");
            }
        }
    }
}