package SINTATICO;

import java.util.LinkedList;

public class producaoTabela {
    
    public static LinkedList<String> producoes(int numeroProducao){
        
        LinkedList<String> listaProducao = null;
        
        switch(numeroProducao){
            
            case 0:
                listaProducao.add("TK_inicio");
                listaProducao.add("LISTA_COMANDOS");
                listaProducao.add("TK_fim");
                break;
                
            case 1:
                listaProducao.add("COMANDOS");
                listaProducao.add("LISTA_COMANDOS");
                break;
                
            case 2:
                listaProducao = null;
                break;
                
            case 3:
                listaProducao.add("LEIA");
                listaProducao.add("TK_abreparent");
                listaProducao.add("ATRIBUTO");
                listaProducao.add("TK_fechaparent");
                listaProducao.add("FINALLINHA");
                break;
                
            case 4:
                listaProducao.add("ESCREVA");
                listaProducao.add("TK_abreparent");
                listaProducao.add("ATRIBUTO");
                listaProducao.add("TK_fechaparent");
                listaProducao.add("FINALLINHA");
                break;
                
            case 5:
                listaProducao.add("ENQUANTO");
                listaProducao.add("TK_abreparent");
                listaProducao.add("EXPRESSAO");
                listaProducao.add("TK_fechaparent");
                listaProducao.add("INICIOBLOCO");
                listaProducao.add("LISTA_COMANDOS");
                listaProducao.add("FINALBLOCO");
                break;
                
            case 6:
                listaProducao.add("SE");
                listaProducao.add("TK_abreparent");
                listaProducao.add("EXPRESSAO");
                listaProducao.add("TK_fechaparent");
                listaProducao.add("INICIOBLOCO");
                listaProducao.add("LISTA_COMANDOS");
                listaProducao.add("SENAO");
                listaProducao.add("FINALBLOCO");
                break;
                
            case 7:
                listaProducao.add("TK_senao");
                listaProducao.add("INICIOBLOCO");
                listaProducao.add("LISTA_COMANDOS");
                listaProducao.add("FINALBLOCO");
                break;
                
            case 8:
                listaProducao = null;
                break;
                
            case 9:
                listaProducao.add("VARIAVEL");
                listaProducao.add("ARGUMENTOEXP");
                break;
                
            case 10:
                listaProducao.add("SIMBOLO");
                listaProducao.add("VARNUMERO");
                break;
                
            case 11:
                listaProducao = null;
                break;
                
            case 12:
                listaProducao.add("TK_variavel");
                listaProducao.add("ARGUMENTO");
                listaProducao.add("FINALLINHA");
                break;
                
            case 13:
                listaProducao.add("TK_igual");
                listaProducao.add("ARGUMENTOAUX");
                break;
                
            case 14:
                listaProducao.add("ITERACAO");
                break;
                
            case 15:
                listaProducao.add("TIPOVARIAVEL");
                listaProducao.add("VARIAVEL");
                listaProducao.add("ATRIBUICAO");
                listaProducao.add("FINALLINHA");
                break;
                
            case 16:
                listaProducao.add("TK_igual");
                listaProducao.add("ARGUMENTOAUX");
                break;
                
            case 17:
                listaProducao = null;
                break;
                
            case 18:
                listaProducao.add("EXPMATVARNUM");
                break;
                
            case 19:
                listaProducao.add("TK_abreparent");
                listaProducao.add("STRING");
                listaProducao.add("TK_fechaparent");
                break;
                
            case 20:
                listaProducao.add("VARNUMERO");
                listaProducao.add("EXPRESSAOMAT");
                break;
                
            case 21:
                listaProducao.add("SIMBOLORMAT");
                listaProducao.add("EXPMATVARNUM");
                break;
                
            case 22:
                listaProducao = null;
                break;
                
            case 23:
                listaProducao.add("STRING");
                break;
                
            case 24:
                listaProducao.add("NUMERO");
                break;
                
            case 25:
                listaProducao.add("VARIAVEL");
                break;
                
            case 26:
                listaProducao.add("NUMERO");
                break;
                
            case 27:
                listaProducao.add("VARIAVEL");
                break;
                
            case 28:
                listaProducao.add("TK_numpos");
                break;
                
            case 29:
                listaProducao.add("TK_numneg");
                break;
                
            case 30:
                listaProducao.add("TK_maior");
                break;
                
            case 31:
                listaProducao.add("TK_menor");
                break;
                
            case 32:
                listaProducao.add("TK_diferente");
                break;
                
            case 33:
                listaProducao.add("TK_igualigual");
                break;
                
            case 34:
                listaProducao.add("TK_soma");
                break;
                
            case 35:
                listaProducao.add("TK_sub");
                break;
                
            case 36:
                listaProducao.add("TK_mult");
                break;
                
            case 37:
                listaProducao.add("TK_div");
                break;
                
            case 38:
                listaProducao.add("TK_incremento");
                break;
                
            case 39:
                listaProducao.add("TK_decremento");
                break;
                
            case 40:
                listaProducao.add("TK_leia");
                break;
                
            case 41:
                listaProducao.add("TK_escreva");
                break;
                
            case 42:
                listaProducao.add("TK_string");
                break;
                
            case 43:
                listaProducao.add("TK_int");
                break;
                
            case 44:
                listaProducao.add("TK_variavel");
                break;
                
            case 45:
                listaProducao.add("TK_se");
                break;
                
            case 46:
                listaProducao.add("TK_enquanto");
                break;
                
            case 47:
                listaProducao.add("TK_iniciobloco");
                break;
                
            case 48:
                listaProducao.add("TK_fimbloco");
                break;
                
            case 49:
                listaProducao.add("TK_finallinha");
                break;
        }  
        return listaProducao;
    }
}