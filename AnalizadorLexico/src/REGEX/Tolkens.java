package REGEX;

public class Tolkens {
    
    private String nome;
    private String descricao;
    private int linha;
    private int coluna;
    
    public Tolkens(String nome, String descricao, int linha, int coluna) {
        this.nome = nome;
        this.descricao = descricao;
        this.linha = linha;
        this.coluna = coluna;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }
}