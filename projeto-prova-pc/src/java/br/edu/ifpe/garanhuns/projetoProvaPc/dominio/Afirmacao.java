package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// comentário
@Entity
@Table ( name = "afirmacao" )
public class Afirmacao implements Serializable{
    
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String texto;
    @Column
    private boolean veracidade;

    public Afirmacao() {
    }
    
    public Afirmacao(String texto, boolean veracidade){
        ///this.id = -1;
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
