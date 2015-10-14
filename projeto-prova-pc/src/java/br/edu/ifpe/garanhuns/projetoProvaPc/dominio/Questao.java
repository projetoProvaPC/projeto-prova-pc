package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// QUEM É ISSO??
/**
 *
 * @author 20141D12GR0416
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

// tem que ser abstract por que não pode ter uma questão que não seja nem de V/F
// nem de multipla escolha
@MappedSuperclass
public abstract class Questao implements Serializable{
    
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String enunciado;
    @Column
    private int pontuacao;
    @OneToMany ( cascade = CascadeType.ALL )
    private List<Afirmacao> afirmacoes = new ArrayList<>();

    public Questao() {
    }
    
    public Questao(String enunciado, int pontuacao) {
        //this.id = -1;
        this.enunciado = enunciado;
        this.pontuacao = pontuacao;
    }
    
    public Questao(String enunciado, int pontuacao, List<Afirmacao> afirmacoes) {
        this(enunciado,pontuacao);
        this.afirmacoes = afirmacoes;
    }
    
     public String getEnunciado() {
        return enunciado;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    protected boolean add(Afirmacao e) {
        return afirmacoes.add(e);
    }

    protected boolean remove(Afirmacao o) {
        return afirmacoes.remove(o);
    }

    // Recupera uma afirmacao
    //  As subclasses decidem se vão ou não deixar isso público
    protected Afirmacao getAfirmacao(int i) {
        return afirmacoes.get(i);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public List<Afirmacao> getAfirmacoes() {
        List<Afirmacao> as = new LinkedList<>();
        for (Afirmacao afirmacao : this.afirmacoes) {
            as.add(afirmacao);
        }
        return as;
    }

}
