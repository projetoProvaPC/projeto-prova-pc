package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

import java.util.*;

public class Prova {

    private String tema;
    private ArrayList<Questao> questoes = new ArrayList<Questao>();

    public Prova(String tema) {
        this.tema = tema;
    }
    
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public boolean isEmpty() {
        return questoes.isEmpty();
    }

    public boolean add(Questao e) {
        return questoes.add(e);
    }

    public boolean remove(Questao o) {
        return questoes.remove(o);
    }

    public Iterator<Questao> iterator() {
        return questoes.iterator();
    }

    
    
}
