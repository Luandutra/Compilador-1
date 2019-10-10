package SINTATICO;

import java.util.ArrayList;
import java.util.LinkedList;

public class analiseSintatica{
    
    LinkedList<String> listaCodigo;
    
    public static void analisadorSintatico(boolean argumento, ArrayList<String> argumentos, LinkedList<String> listaTokens) {
        
        listaTokens.add("$");
        listaTokens.add("PROGRAMA");
    }
}