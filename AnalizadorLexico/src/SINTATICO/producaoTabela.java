package SINTATICO;

import java.util.LinkedList;

public class producaoTabela {
    
    public static LinkedList<String> producoes(int numeroProducao){
        
        LinkedList<String> listaProducao = new LinkedList<>();
        
        switch(numeroProducao){
            
            case 0:
                listaProducao.clear();
                listaProducao.add("TK_inicio");
                listaProducao.add("LISTA_COMANDOS");
                listaProducao.add("TK_fim");
                return listaProducao;
                
            case 1:
                listaProducao.clear();
                listaProducao.add("COMANDOS");
                listaProducao.add("LISTA_COMANDOS");
                return listaProducao;
                
            case 2:
                listaProducao.clear();
                return listaProducao;
                
            case 3:
                listaProducao.clear();
                listaProducao.add("LEIA");
                listaProducao.add("TK_abreparent");
                listaProducao.add("ATRIBUTO");
                listaProducao.add("TK_fechaparent");
                listaProducao.add("FINALLINHA");
                return listaProducao;
                
            case 4:
                listaProducao.clear();
                listaProducao.add("ESCREVA");
                listaProducao.add("TK_abreparent");
                listaProducao.add("ATRIBUTO");
                listaProducao.add("TK_fechaparent");
                listaProducao.add("FINALLINHA");
                return listaProducao;
                
            case 5:
                listaProducao.clear();
                listaProducao.add("ENQUANTO");
                listaProducao.add("TK_abreparent");
                listaProducao.add("EXPRESSAO");
                listaProducao.add("TK_fechaparent");
                listaProducao.add("INICIOBLOCO");
                listaProducao.add("LISTA_COMANDOS");
                listaProducao.add("FINALBLOCO");
                return listaProducao;
                
            case 6:
                listaProducao.clear();
                listaProducao.add("SE");
                listaProducao.add("TK_abreparent");
                listaProducao.add("EXPRESSAO");
                listaProducao.add("TK_fechaparent");
                listaProducao.add("INICIOBLOCO");
                listaProducao.add("LISTA_COMANDOS");
                listaProducao.add("SENAO");
                listaProducao.add("FINALBLOCO");
                return listaProducao;
                
            case 7:
                listaProducao.clear();
                listaProducao.add("TK_senao");
                listaProducao.add("INICIOBLOCO");
                listaProducao.add("LISTA_COMANDOS");
                listaProducao.add("FINALBLOCO");
                return listaProducao;
                
            case 8:
                listaProducao.clear();
                return listaProducao;
                
            case 9:
                listaProducao.clear();
                listaProducao.add("VARIAVEL");
                listaProducao.add("ARGUMENTOEXP");
                return listaProducao;
                
            case 10:
                listaProducao.clear();
                listaProducao.add("SIMBOLO");
                listaProducao.add("VARNUMERO");
                return listaProducao;
                
            case 11:
                listaProducao.clear();
                listaProducao = null;
                return listaProducao;
                
            case 12:
                listaProducao.clear();
                listaProducao.add("TK_variavel");
                listaProducao.add("ARGUMENTO");
                listaProducao.add("FINALLINHA");
                return listaProducao;
                
            case 13:
                listaProducao.clear();
                listaProducao.add("TK_igual");
                listaProducao.add("ARGUMENTOAUX");
                return listaProducao;
                
            case 14:
                listaProducao.clear();
                listaProducao.add("ITERACAO");
                return listaProducao;
                
            case 15:
                listaProducao.clear();
                listaProducao.add("TIPOVARIAVEL");
                listaProducao.add("VARIAVEL");
                listaProducao.add("ATRIBUICAO");
                listaProducao.add("FINALLINHA");
                return listaProducao;
                
            case 16:
                listaProducao.clear();
                listaProducao.add("TK_igual");
                listaProducao.add("ARGUMENTOAUX");
                return listaProducao;
                
            case 17:
                listaProducao.clear();
                return listaProducao;
                
            case 18:
                listaProducao.clear();
                listaProducao.add("EXPMATVARNUM");
                return listaProducao;
                
            case 19:
                listaProducao.clear();
                listaProducao.add("TK_abreparent");
                listaProducao.add("STRING");
                listaProducao.add("TK_fechaparent");
                return listaProducao;
                
            case 20:
                listaProducao.clear();
                listaProducao.add("VARNUMERO");
                listaProducao.add("EXPRESSAOMAT");
                return listaProducao;
                
            case 21:
                listaProducao.clear();
                listaProducao.add("SIMBOLORMAT");
                listaProducao.add("EXPMATVARNUM");
                return listaProducao;
                
            case 22:
                listaProducao.clear();
                return listaProducao;
                
            case 23:
                listaProducao.clear();
                listaProducao.add("STRING");
                return listaProducao;
                
            case 24:
                listaProducao.clear();
                listaProducao.add("NUMERO");
                return listaProducao;
                
            case 25:
                listaProducao.clear();
                listaProducao.add("VARIAVEL");
                return listaProducao;
                
            case 26:
                listaProducao.clear();
                listaProducao.add("NUMERO");
                return listaProducao;
                
            case 27:
                listaProducao.clear();
                listaProducao.add("VARIAVEL");
                return listaProducao;
                
            case 28:
                listaProducao.clear();
                listaProducao.add("TK_numpos");
                return listaProducao;
                
            case 29:
                listaProducao.clear();
                listaProducao.add("TK_numneg");
                return listaProducao;
                
            case 30:
                listaProducao.clear();
                listaProducao.add("TK_maior");
                return listaProducao;
                
            case 31:
                listaProducao.clear();
                listaProducao.add("TK_menor");
                return listaProducao;
                
            case 32:
                listaProducao.clear();
                listaProducao.add("TK_diferente");
                return listaProducao;
                
            case 33:
                listaProducao.clear();
                listaProducao.add("TK_igualigual");
                return listaProducao;
                
            case 34:
                listaProducao.clear();
                listaProducao.add("TK_soma");
                return listaProducao;
                
            case 35:
                listaProducao.clear();
                listaProducao.add("TK_sub");
                return listaProducao;
                
            case 36:
                listaProducao.clear();
                listaProducao.add("TK_mult");
                return listaProducao;
                
            case 37:
                listaProducao.clear();
                listaProducao.add("TK_div");
                return listaProducao;
                
            case 38:
                listaProducao.clear();
                listaProducao.add("TK_incremento");
                return listaProducao;
                
            case 39:
                listaProducao.clear();
                listaProducao.add("TK_decremento");
                return listaProducao;
                
            case 40:
                listaProducao.clear();
                listaProducao.add("TK_leia");
                return listaProducao;
                
            case 41:
                listaProducao.clear();
                listaProducao.add("TK_escreva");
                return listaProducao;
                
            case 42:
                listaProducao.clear();
                listaProducao.add("TK_string");
                return listaProducao;
                
            case 43:
                listaProducao.clear();
                listaProducao.add("TK_int");
                return listaProducao;
                
            case 44:
                listaProducao.clear();
                listaProducao.add("TK_variavel");
                return listaProducao;
                
            case 45:
                listaProducao.clear();
                listaProducao.add("TK_se");
                return listaProducao;
                
            case 46:
                listaProducao.clear();
                listaProducao.add("TK_enquanto");
                return listaProducao;
                
            case 47:
                listaProducao.clear();
                listaProducao.add("TK_iniciobloco");
                return listaProducao;
                
            case 48:
                listaProducao.clear();
                listaProducao.add("TK_fimbloco");
                return listaProducao;
                
            case 49:
                listaProducao.clear();
                listaProducao.add("TK_finallinha");
                return listaProducao;
        }  
        return listaProducao = null;
    }
}