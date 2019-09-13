package REGEX;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExpressaoRegular {

    public static void ComparadorRegex(boolean arg, ArrayList<String> argumento, ArrayList<String> palavraReservada, ArrayList<String> arq){

        ArrayList<String[]> listaPalavras = new ArrayList<>();
        ArrayList<Tokens> tokens = new ArrayList<>();

        boolean modoString = false;
        String texto = "";

        for(int x = 0; x < arq.size() - 1; x++){
            try {
                listaPalavras.add(arq.get(x).split(" "));
            }catch (Exception e){
                System.out.println("ERRO: Problema na divisao do arquivo\n" + e);
            }
        }

        for(int y = 0; y < listaPalavras.size(); y++){
            for(int z = 0; z < listaPalavras.get(y).length; z++){

                Pattern pattern2 = Pattern.compile("[\"]");
                Matcher matcher2 = pattern2.matcher(listaPalavras.get(y)[z]);
                if(matcher2.find()){
                    modoString = true;
                    while (modoString){
                        if (!listaPalavras.get(y)[z].endsWith("\"")){
                            texto += " " + listaPalavras.get(y)[z];
                        }else {
                            texto += " "+ listaPalavras.get(y)[z];
                            modoString = false;
                        }
                        z++;
                    }
                    tokens.add(new Tokens("TK_string", texto, y, z));
                    texto = "";
                }

                if(listaPalavras.get(y)[z].matches("-[0-9]+")){
                    tokens.add(new Tokens("TK_numneg", listaPalavras.get(y)[z], y, z));
                }

                else if (listaPalavras.get(y)[z].matches("[0-9]+")){
                    tokens.add(new Tokens("TK_numpos", listaPalavras.get(y)[z], y, z));
                }

                else if (listaPalavras.get(y)[z].matches(";")){
                    tokens.add(new Tokens("TK_finallinha", listaPalavras.get(y)[z], y, z));
                }

                else if (listaPalavras.get(y)[z].matches("\\(")){
                    tokens.add(new Tokens("TK_abreparent", listaPalavras.get(y)[z], y, z));
                }

                else if (listaPalavras.get(y)[z].matches("\\)")){
                    tokens.add(new Tokens("TK_fechaparent", listaPalavras.get(y)[z], y, z));
                }

                else if (listaPalavras.get(y)[z].matches("\\{")){
                    tokens.add(new Tokens("TK_iniciobloco", listaPalavras.get(y)[z], y, z));
                }

                else if (listaPalavras.get(y)[z].matches("}")){
                    tokens.add(new Tokens("TK_fimbloco", listaPalavras.get(y)[z], y, z));
                }

                else if (listaPalavras.get(y)[z].matches("=")){
                    tokens.add(new Tokens("TK_igual", listaPalavras.get(y)[z], y, z));
                }

                else if (listaPalavras.get(y)[z].matches("==")){
                    tokens.add(new Tokens("TK_igualigual", listaPalavras.get(y)[z], y, z));
                }

                else if (listaPalavras.get(y)[z].matches(">")){
                    tokens.add(new Tokens("TK_maior", listaPalavras.get(y)[z], y, z));
                }

                else if (listaPalavras.get(y)[z].matches("<")){
                    tokens.add(new Tokens("TK_menor", listaPalavras.get(y)[z], y, z));
                }

                else if (listaPalavras.get(y)[z].matches("<>")){
                    tokens.add(new Tokens("TK_diferente", listaPalavras.get(y)[z], y, z));
                }

                else if (listaPalavras.get(y)[z].matches("\\+\\+]")){
                    tokens.add(new Tokens("TK_incremento", listaPalavras.get(y)[z], y, z));
                }

                else if (listaPalavras.get(y)[z].matches("--")){
                    tokens.add(new Tokens("TK_decremento", listaPalavras.get(y)[z], y, z));
                }

                else if (listaPalavras.get(y)[z].matches("\\+")){
                    tokens.add(new Tokens("TK_soma", listaPalavras.get(y)[z], y, z));
                }
                else if (listaPalavras.get(y)[z].matches("\\*")){
                    tokens.add(new Tokens("TK_mult", listaPalavras.get(y)[z], y, z));
                }

                else if (listaPalavras.get(y)[z].matches("/")){
                    tokens.add(new Tokens("TK_div", listaPalavras.get(y)[z], y, z));
                }

                else if (listaPalavras.get(y)[z].matches("-")){
                    tokens.add(new Tokens("TK_sub", listaPalavras.get(y)[z], y, z));
                }

                else if (palavraReservada.contains(listaPalavras.get(y)[z])){
                    Pattern pattern = Pattern.compile("[a-z]");
                    Matcher matcher = pattern.matcher(listaPalavras.get(y)[z]);
                    if(matcher.find()){
                        if(listaPalavras.get(y)[z].matches("inicio")){
                            tokens.add(new Tokens("TK_inicio", listaPalavras.get(y)[z], y, z));
                        }

                        if(listaPalavras.get(y)[z].matches("fim")){
                            tokens.add(new Tokens("TK_fim", listaPalavras.get(y)[z], y, z));
                        }

                        if(listaPalavras.get(y)[z].matches("inteiro")){
                            tokens.add(new Tokens("TK_inteiro", listaPalavras.get(y)[z], y, z));
                        }

                        if(listaPalavras.get(y)[z].matches("leia")){
                            tokens.add(new Tokens("TK_leia", listaPalavras.get(y)[z], y, z));
                        }

                        if(listaPalavras.get(y)[z].matches("escreva")){
                            tokens.add(new Tokens("TK_escreva", listaPalavras.get(y)[z], y, z));
                        }

                        if(listaPalavras.get(y)[z].matches("enquanto")){
                            tokens.add(new Tokens("TK_enquanto", listaPalavras.get(y)[z], y, z));
                        }

                        if(listaPalavras.get(y)[z].matches("se")){
                            tokens.add(new Tokens("TK_se", listaPalavras.get(y)[z], y, z));
                        }

                        if(listaPalavras.get(y)[z].matches("senao")){
                            tokens.add(new Tokens("TK_senao", listaPalavras.get(y)[z], y, z));
                        }
                    }
                }

                else if (listaPalavras.get(y)[z].matches("[a-zA-Z]")){
                    tokens.add(new Tokens("TK_variavel", listaPalavras.get(y)[z], y, z));
                }

                else {
                    System.out.println("ERRO LEXICO: Caractere(s): "+listaPalavras.get(y)[z]+" não permitido, posição: "+"Linha: "+y+" e Coluna: "+z);
                    return;
                }

            }
        }

        if(arg == false){

            for(Tokens t : tokens){
                System.out.println("Tolken: "+t.getNome()+" -> "+"Lexema: "+t.getLexemas()+" -> "+"Linha: "+t.getLinha()+" -> "+"Coluna: "+t.getColuna()+"\n");
            }

        }
    }
}