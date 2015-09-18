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
import java.util.ArrayList;

// tem que ser abstract por que não pode ter uma questão que não seja nem de V/F
// nem de multipla escolha
public abstract class Questao {
    private String enunciado;
    private int pontuacao;
    private ArrayList<Afirmacao> alternativas;

    public Questao(String enunciado, int pontuacao) {
        this.enunciado = enunciado;
        this.pontuacao = pontuacao;
        this.alternativas = new ArrayList<>();
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
        return alternativas.add(e);
    }

    protected boolean remove(Afirmacao o) {
        return alternativas.remove(o);
    }
    
}
