package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// comentário
@Entity
@Table ( name = "afirmacao" )
public class Afirmacao {
    
    @Id
    @GeneratedValue
    private long id = -1;
    @Column
    private String texto;
    @Column
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

    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
    
}
