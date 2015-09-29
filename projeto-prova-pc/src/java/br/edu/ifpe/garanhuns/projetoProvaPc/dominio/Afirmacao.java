package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

// comentário

public class Afirmacao {
    private String texto;
    private boolean veracidade;
    
    public Afirmacao(String texto, boolean veracidade){
        this.texto = texto;
        this.veracidade = veracidade;
    }

    public String getTexto() {
        return texto;
    }

    public boolean veracidade() {
        return veracidade;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setVeracidade(boolean veracidade) {
        this.veracidade = veracidade;
    }
    
}
