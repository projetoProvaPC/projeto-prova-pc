package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// comentário
@Entity
@Table ( name = "afirmacao" )
public class Afirmacao {
    
    @Id
    @Column
    private int id;
    @Column
    private String texto;
    @Column
    private boolean veracidade;
    
    public Afirmacao(int id, String texto, boolean veracidade){
        this.id = id;
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

    public int getId() {
        return id;
    }
 
    
    
}
