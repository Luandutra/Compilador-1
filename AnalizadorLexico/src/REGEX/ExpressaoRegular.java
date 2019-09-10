package REGEX;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExpressaoRegular {

    public static void ComparadorRegex(boolean arg, ArrayList<String> argumento, ArrayList<String> palavraProblema, ArrayList<String> palavraReservada, ArrayList<String> arq){

        ArrayList<String[]> listaPalavras = new ArrayList<>();
        ArrayList<Tolkens> tolkens = new ArrayList<>();

        boolean modoString = false;
        String texto = "";

        for(int x = 0; x < arq.size() - 1; x++){
            listaPalavras.add(arq.get(x).split(" "));
        }

        for(int y = 0; y < listaPalavras.size(); y++){
            for(int z = 0; z < listaPalavras.get(y).length; z++){

                Pattern pattern2 = Pattern.compile("[\"]");
                Matcher matcher2 = pattern2.matcher(listaPalavras.get(y)[z]);
                if(matcher2.find()){
                    modoString = true;
                    tolkens.add(new Tolkens("TK_string", texto, y, z));
                    while (modoString){
                        if (!listaPalavras.get(y)[z].endsWith("\"")){
                            texto += " " + listaPalavras.get(y)[z];
                        }else {
                            texto += " "+ listaPalavras.get(y)[z];
                            modoString = false;
                        }
                        z++;
                    }
                }

                Pattern pattern4 = Pattern.compile("-[0-9]");
                Matcher matcher4 = pattern4.matcher(listaPalavras.get(y)[z]);
                if(matcher4.find()){
                    tolkens.add(new Tolkens("TK_numneg", listaPalavras.get(y)[z], y, z));

                } else{

                    Pattern pattern3 = Pattern.compile("[0-9]");
                    Matcher matcher3 = pattern3.matcher(listaPalavras.get(y)[z]);
                    if(matcher3.find()){
                        tolkens.add(new Tolkens("TK_numpos", listaPalavras.get(y)[z], y, z));

                    } else{

                        if(listaPalavras.get(y)[z].matches(";")){
                            tolkens.add(new Tolkens("TK_finallinha", listaPalavras.get(y)[z], y, z));

                        } else{

                            if(listaPalavras.get(y)[z].matches("\\(")){
                                tolkens.add(new Tolkens("TK_abreparent", listaPalavras.get(y)[z], y, z));

                            } else{

                                if(listaPalavras.get(y)[z].matches("\\)")){
                                    tolkens.add(new Tolkens("TK_fechaparent", listaPalavras.get(y)[z], y, z));

                                } else{

                                    if(listaPalavras.get(y)[z].matches("\\{")){
                                        tolkens.add(new Tolkens("TK_iniciobloco", listaPalavras.get(y)[z], y, z));

                                    } else{

                                        if(listaPalavras.get(y)[z].matches("}")){
                                            tolkens.add(new Tolkens("TK_fimbloco", listaPalavras.get(y)[z], y, z));

                                        } else{

                                            if(listaPalavras.get(y)[z].matches("=")){
                                                tolkens.add(new Tolkens("TK_igual", listaPalavras.get(y)[z], y, z));

                                            } else{

                                                if(listaPalavras.get(y)[z].matches("==")){
                                                    tolkens.add(new Tolkens("TK_igualigual", listaPalavras.get(y)[z], y, z));

                                                } else{

                                                    if(listaPalavras.get(y)[z].matches(">")){
                                                        tolkens.add(new Tolkens("TK_maior", listaPalavras.get(y)[z], y, z));

                                                    } else{

                                                        if(listaPalavras.get(y)[z].matches("<")){
                                                            tolkens.add(new Tolkens("TK_menor", listaPalavras.get(y)[z], y, z));

                                                        } else{

                                                            if(listaPalavras.get(y)[z].matches("<>")){
                                                                tolkens.add(new Tolkens("TK_diferente", listaPalavras.get(y)[z], y, z));

                                                            } else{

                                                                if(listaPalavras.get(y)[z].matches("\\+\\+]")){
                                                                    tolkens.add(new Tolkens("TK_incremento", listaPalavras.get(y)[z], y, z));

                                                                } else{

                                                                    if(listaPalavras.get(y)[z].matches("--")){
                                                                        tolkens.add(new Tolkens("TK_decremento", listaPalavras.get(y)[z], y, z));

                                                                    } else{

                                                                        if(listaPalavras.get(y)[z].matches("\\+")){
                                                                            tolkens.add(new Tolkens("TK_soma", listaPalavras.get(y)[z], y, z));

                                                                        } else{

                                                                            if(listaPalavras.get(y)[z].matches("\\*")){
                                                                                tolkens.add(new Tolkens("TK_mult", listaPalavras.get(y)[z], y, z));

                                                                            } else{

                                                                                if(listaPalavras.get(y)[z].matches("/")){
                                                                                    tolkens.add(new Tolkens("TK_div", listaPalavras.get(y)[z], y, z));

                                                                                } else{

                                                                                    if(listaPalavras.get(y)[z].matches("-")){
                                                                                        tolkens.add(new Tolkens("TK_sub", listaPalavras.get(y)[z], y, z));

                                                                                    } else{

                                                                                        if(palavraReservada.contains(listaPalavras.get(y)[z])){
                                                                                            Pattern pattern = Pattern.compile("[a-z]");
                                                                                            Matcher matcher = pattern.matcher(listaPalavras.get(y)[z]);
                                                                                            if(matcher.find()){
                                                                                                if(listaPalavras.get(y)[z].matches("inicio")){
                                                                                                    tolkens.add(new Tolkens("TK_inicio", listaPalavras.get(y)[z], y, z));
                                                                                                }

                                                                                                if(listaPalavras.get(y)[z].matches("fim")){
                                                                                                    tolkens.add(new Tolkens("TK_fim", listaPalavras.get(y)[z], y, z));
                                                                                                }

                                                                                                if(listaPalavras.get(y)[z].matches("inteiro")){
                                                                                                    tolkens.add(new Tolkens("TK_inteiro", listaPalavras.get(y)[z], y, z));
                                                                                                }

                                                                                                if(listaPalavras.get(y)[z].matches("leia")){
                                                                                                    tolkens.add(new Tolkens("TK_leia", listaPalavras.get(y)[z], y, z));
                                                                                                }

                                                                                                if(listaPalavras.get(y)[z].matches("escreva")){
                                                                                                    tolkens.add(new Tolkens("TK_escreva", listaPalavras.get(y)[z], y, z));
                                                                                                }

                                                                                                if(listaPalavras.get(y)[z].matches("enquanto")){
                                                                                                    tolkens.add(new Tolkens("TK_enquanto", listaPalavras.get(y)[z], y, z));
                                                                                                }

                                                                                                if(listaPalavras.get(y)[z].matches("se")){
                                                                                                    tolkens.add(new Tolkens("TK_se", listaPalavras.get(y)[z], y, z));
                                                                                                }

                                                                                                if(listaPalavras.get(y)[z].matches("senao")){
                                                                                                    tolkens.add(new Tolkens("TK_senao", listaPalavras.get(y)[z], y, z));
                                                                                                }
                                                                                            }

                                                                                        } else{

                                                                                            Pattern pattern1 = Pattern.compile("^[a-zA-Z]");
                                                                                            Matcher matcher1 = pattern1.matcher(listaPalavras.get(y)[z]);
                                                                                            if(matcher1.find()){
                                                                                                tolkens.add(new Tolkens("TK_variavel", listaPalavras.get(y)[z], y, z));

                                                                                            } else{

                                                                                                System.out.println("ERRO LEXICO: Caractere(s): "+listaPalavras.get(y)[z]+" não permitido na "+"Linha: "+y+" e Coluna: "+z);
                                                                                                return;
                                                                                            }

                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if(arg == false){

            for(Tolkens t : tolkens){
                System.out.println("Tolken: "+t.getNome()+" -> "+"Lexema: "+t.getLexemas()+" -> "+"Linha: "+t.getLinha()+" -> "+"Coluna: "+t.getColuna()+"\n");
            }

        }
    }
}