package REGEX;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExpressaoRegular {
    
    public static void OrganizadorRegex(boolean arg, ArrayList<String> arq) {
        
        ArrayList<String[]> listaPalavras = new ArrayList<>();
        ArrayList<Tolkens> tolkens = new ArrayList<>();
        String palavrasReservadas[] = {"inicio", "fim", "inteiro", "leia", "escreva", "enquanto", "se", "senao"};
        
        if(arg == false){
         
            for(int x = 0; x < arq.size() - 1; x++){
                listaPalavras.add(arq.get(x).split(" "));
            }
            
            for(int y = 0; y < listaPalavras.size(); y++){
                for(int z = 0; z < listaPalavras.get(y).length; z++){
                    
                    Pattern pattern = Pattern.compile("[a-z]");
                    Matcher matcher = pattern.matcher(listaPalavras.get(y)[z]);
                    if(matcher.find()){
                        if(listaPalavras.get(y)[z].contains("inicio")){
                            tolkens.add(new Tolkens("TK_inicio", "Inicio do programa", y, z));
                        }
                        if(listaPalavras.get(y)[z].contains("fim")){
                            tolkens.add(new Tolkens("TK_fim", "Fim do programa", y, z));
                        }                       
                        if(listaPalavras.get(y)[z].contains("inteiro")){
                            tolkens.add(new Tolkens("TK_inteiro", "Tipo de variavel", y, z));
                        }                       
                        if(listaPalavras.get(y)[z].contains("leia")){
                            tolkens.add(new Tolkens("TK_leia", "Input", y, z));
                        }                       
                        if(listaPalavras.get(y)[z].contains("escreva")){
                            tolkens.add(new Tolkens("TK_escreva", "Output", y, z));
                        }                        
                        if(listaPalavras.get(y)[z].contains("enquanto")){
                            tolkens.add(new Tolkens("TK_enquanto", "Estrutura de repetição", y, z));
                        }                        
                        if(listaPalavras.get(y)[z].contains("se")){
                            tolkens.add(new Tolkens("TK_se", "Estrutura condicional", y, z));
                        }                       
                        if(listaPalavras.get(y)[z].contains("senao")){
                            tolkens.add(new Tolkens("TK_senao", "Estrutura condicional", y, z));
                        }
                    }
                    
                    Pattern pattern1 = Pattern.compile("[0-9]");
                    Matcher matcher1 = pattern1.matcher(listaPalavras.get(y)[z]);
                    if(matcher1.find()){
                        tolkens.add(new Tolkens("TK_numpos", "Numero positivo", y, z));
                    }
                    
                    Pattern pattern2 = Pattern.compile("-[0-9]");
                    Matcher matcher2 = pattern2.matcher(listaPalavras.get(y)[z]);
                    if(matcher2.find()){
                        tolkens.add(new Tolkens("TK_numneg", "Numero negativo", y, z));
                    }
                    
                    Pattern pattern3 = Pattern.compile("[\"_._\"]");
                    Matcher matcher3 = pattern3.matcher(listaPalavras.get(y)[z]);
                    if(matcher3.find()){
                        tolkens.add(new Tolkens("TK_string", "String", y, z));
                    }
                    
                    Pattern pattern4 = Pattern.compile("[a-z]");
                    Matcher matcher4 = pattern4.matcher(listaPalavras.get(y)[z]);
                    if(matcher4.find()){
                        for(int k = 0; k < palavrasReservadas.length; k++){
                            if(listaPalavras.get(y)[z] != palavrasReservadas[k]){
                                tolkens.add(new Tolkens("TK_variavel", "Variavel", y, z));
                            }
                        }
                    }
                    
                    if(listaPalavras.get(y)[z].contains(";")){
                        tolkens.add(new Tolkens("TK_finallinha", "Fim de linha", y, z));
                    }
                    
                    if(listaPalavras.get(y)[z].contains("(")){
                        tolkens.add(new Tolkens("TK_abreparent", "Abre parênteses", y, z));
                    }
                    
                    if(listaPalavras.get(y)[z].contains(")")){
                        tolkens.add(new Tolkens("TK_fechaparent", "Fecha parênteses", y, z));
                    }
                    
                    if(listaPalavras.get(y)[z].contains("{")){
                        tolkens.add(new Tolkens("TK_iniciobloco", "Abre bloco de codigo", y, z));
                    }
                    
                    if(listaPalavras.get(y)[z].contains("}")){
                        tolkens.add(new Tolkens("TK_fimbloco", "Fecha bloco de codigo", y, z));
                    }
                    
                    if(listaPalavras.get(y)[z].contains("=")){
                        tolkens.add(new Tolkens("TK_igual", "Atribuição", y, z));
                    }
                    
                    if(listaPalavras.get(y)[z].contains("==")){
                        tolkens.add(new Tolkens("TK_igualigual", "Comparação", y, z));
                    }
                    
                    if(listaPalavras.get(y)[z].contains(">")){
                        tolkens.add(new Tolkens("TK_maior", "Sinal de maior", y, z));
                    }
                    
                    if(listaPalavras.get(y)[z].contains("<")){
                        tolkens.add(new Tolkens("TK_menor", "Sinal de menor", y, z));
                    }
                    
                    if(listaPalavras.get(y)[z].contains("<>")){
                        tolkens.add(new Tolkens("TK_diferente", "Sinal de diferente", y, z));
                    }
                    
                    if(listaPalavras.get(y)[z].contains("++")){
                        tolkens.add(new Tolkens("TK_incremento", "Sinal de incremento", y, z));
                    }
                    
                    if(listaPalavras.get(y)[z].contains("--")){
                        tolkens.add(new Tolkens("TK_decremento", "Sinal de decremento", y, z));
                    }
                    
                    if(listaPalavras.get(y)[z].contains("+")){
                        tolkens.add(new Tolkens("TK_soma", "Sinal de soma", y, z));
                    }
                    
                    if(listaPalavras.get(y)[z].contains("-")){
                        tolkens.add(new Tolkens("TK_sub", "Sinal de subtração", y, z));
                    }
                    
                    if(listaPalavras.get(y)[z].contains("*")){
                        tolkens.add(new Tolkens("TK_mult", "Sinal de multiplicação", y, z));
                    }
                    
                    if(listaPalavras.get(y)[z].contains("/")){
                        tolkens.add(new Tolkens("TK_div", "Sinal de divisão", y, z));
                    }
                }
            }
            
            for(Tolkens t : tolkens){
                System.out.println("Tolken: "+t.getNome()+" -"+" Descrição: "+t.getDescricao()+" -"+" Linha: "+t.getLinha()+" -"+" Coluna: "+t.getColuna());
            }
        }
    }
}