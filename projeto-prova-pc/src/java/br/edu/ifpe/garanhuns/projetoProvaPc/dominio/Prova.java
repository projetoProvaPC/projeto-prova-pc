/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

class Prova {
    
    private int id;
    private String tema;
    private List<Questao> questoes;
    
    public Prova(int id, String tema) {
        this.tema = tema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean contains(Questao o) {
        return questoes.contains(o);
    }

    public Iterator<Questao> iterator() {
        return questoes.iterator();
    }

    public boolean add(Questao e) {
        return questoes.add(e);
    }

    public boolean remove(Questao o) {
        return questoes.remove(o);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.tema);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prova other = (Prova) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.tema, other.tema)) {
            return false;
        }
        return true;
    }
    
}
