package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

import br.edu.ifpe.garanhuns.projetoProvaPc.estrutura.repositorios.Persistivel;
import java.util.*;

public class Prova implements Persistivel<Prova>{

    private int id;
    private String tema;
    private ArrayList<Questao> questoes = new ArrayList<Questao>();
    private Professor professor;

    public Prova(int id, String tema, Professor professor) {
	this.id = id;
        this.tema = tema;
	this.professor = professor;
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

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void alterar(Prova t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
