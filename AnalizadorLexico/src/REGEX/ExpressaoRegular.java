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

                Pattern pattern = Pattern.compile("[a-z]");
                Matcher matcher = pattern.matcher(listaPalavras.get(y)[z]);
                if(matcher.find()){
                    if(listaPalavras.get(y)[z].matches("inicio")){
                        tolkens.add(new Tolkens("TK_inicio", "Inicio do programa", y, z));
                    }

                    if(listaPalavras.get(y)[z].matches("fim")){
                        tolkens.add(new Tolkens("TK_fim", "Fim do programa", y, z));
                    }

                    if(listaPalavras.get(y)[z].matches("inteiro")){
                        tolkens.add(new Tolkens("TK_inteiro", "Tipo de variavel", y, z));
                    }

                    if(listaPalavras.get(y)[z].matches("leia")){
                        tolkens.add(new Tolkens("TK_leia", "Input", y, z));
                    }

                    if(listaPalavras.get(y)[z].matches("escreva")){
                        tolkens.add(new Tolkens("TK_escreva", "Output", y, z));
                    }

                    if(listaPalavras.get(y)[z].matches("enquanto")){
                        tolkens.add(new Tolkens("TK_enquanto", "Estrutura de repetição", y, z));
                    }

                    if(listaPalavras.get(y)[z].matches("se")){
                        tolkens.add(new Tolkens("TK_se", "Estrutura condicional", y, z));
                    }

                    if(listaPalavras.get(y)[z].matches("senao")){
                        tolkens.add(new Tolkens("TK_senao", "Estrutura condicional", y, z));
                    }
                }


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
                    tolkens.add(new Tolkens("TK_string", "String", y, z));
                }


                if(palavraReservada.contains(listaPalavras.get(y)[z])){
                }else {
                    Pattern pattern1 = Pattern.compile("^[a-zA-Z]");
                    Matcher matcher1 = pattern1.matcher(listaPalavras.get(y)[z]);
                    if(matcher1.find()){
                        tolkens.add(new Tolkens("TK_variavel", "Variavel", y, z));
                    }
                }


                Pattern pattern3 = Pattern.compile("[0-9]");
                Matcher matcher3 = pattern3.matcher(listaPalavras.get(y)[z]);
                if(matcher3.find()){
                    tolkens.add(new Tolkens("TK_numpos", "Numero positivo", y, z));
                }

                Pattern pattern4 = Pattern.compile("-[0-9]");
                Matcher matcher4 = pattern4.matcher(listaPalavras.get(y)[z]);
                if(matcher4.find()){
                    tolkens.add(new Tolkens("TK_numneg", "Numero negativo", y, z));
                }

                if(listaPalavras.get(y)[z].matches(";")){
                    tolkens.add(new Tolkens("TK_finallinha", "Fim de linha", y, z));
                }

                if(listaPalavras.get(y)[z].matches("\\(")){
                    tolkens.add(new Tolkens("TK_abreparent", "Abre parênteses", y, z));
                }

                if(listaPalavras.get(y)[z].matches("\\)")){
                    tolkens.add(new Tolkens("TK_fechaparent", "Fecha parênteses", y, z));
                }

                if(listaPalavras.get(y)[z].matches("\\{")){
                    tolkens.add(new Tolkens("TK_iniciobloco", "Abre bloco de codigo", y, z));
                }

                if(listaPalavras.get(y)[z].matches("}")){
                    tolkens.add(new Tolkens("TK_fimbloco", "Fecha bloco de codigo", y, z));
                }

                if(listaPalavras.get(y)[z].matches("=")){
                    tolkens.add(new Tolkens("TK_igual", "Atribuição", y, z));
                }

                if(listaPalavras.get(y)[z].matches("==")){
                    tolkens.add(new Tolkens("TK_igualigual", "Comparação", y, z));
                }

                if(listaPalavras.get(y)[z].matches(">")){
                    tolkens.add(new Tolkens("TK_maior", "Sinal de maior", y, z));
                }

                if(listaPalavras.get(y)[z].matches("<")){
                    tolkens.add(new Tolkens("TK_menor", "Sinal de menor", y, z));
                }

                if(listaPalavras.get(y)[z].matches("<>")){
                    tolkens.add(new Tolkens("TK_diferente", "Sinal de diferente", y, z));
                }

                if(listaPalavras.get(y)[z].matches("\\+\\+]")){
                    tolkens.add(new Tolkens("TK_incremento", "Sinal de incremento", y, z));
                }

                if(listaPalavras.get(y)[z].matches("--")){
                    tolkens.add(new Tolkens("TK_decremento", "Sinal de decremento", y, z));
                }

                if(listaPalavras.get(y)[z].matches("\\+")){
                    tolkens.add(new Tolkens("TK_soma", "Sinal de soma", y, z));
                }

                if(listaPalavras.get(y)[z].matches("\\*")){
                    tolkens.add(new Tolkens("TK_mult", "Sinal de multiplicação", y, z));
                }

                if(listaPalavras.get(y)[z].matches("/")){
                    tolkens.add(new Tolkens("TK_div", "Sinal de divisão", y, z));
                }

                if(listaPalavras.get(y)[z].matches("-")){
                    tolkens.add(new Tolkens("TK_sub", "Sinal de subtração", y, z));
                }


                /*
                if(matcher2.find()){
                }else {
                    if(palavraProblema.contains(listaPalavras.get(y)[z])){
                        System.out.println("ERRO LEXICO: Foi encontrado um caractere não permitido na "+"Linha: "+y+" e Coluna: "+z);
                        return;
                    }
                }

                 */
            }
        }


        if(arg == false){

            for(Tolkens t : tolkens){
                System.out.println("Tolken: "+t.getNome()+" - "+"Descrição: "+t.getDescricao()+" - "+"Linha: "+t.getLinha()+" - "+"Coluna: "+t.getColuna());
            }

        }
    }
}