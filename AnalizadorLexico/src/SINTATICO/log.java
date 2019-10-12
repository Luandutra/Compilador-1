package SINTATICO;

import java.util.LinkedList;

public class log {
    
    private String token;
    private String codigo;
    
    public log(String token, String codigo){
        this.token = token;
        this.codigo = codigo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}