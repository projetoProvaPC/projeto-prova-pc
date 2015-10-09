package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

import br.edu.ifpe.garanhuns.projetoProvaPc.repositorios.Persistivel;
import java.util.*;
import javax.persistence.*;

@Entity
@Table (name = "prova")
public class Prova implements Persistivel<Prova>{

    @Id
    @GeneratedValue
    private long id = -1;
    @Column
    private String tema;
    @OneToMany
    private List<QuestaoMultiplaEscolha> questoes = new ArrayList<>();
    @ManyToOne
    private Professor professor;

    public Prova() {
    }
    
    public Prova(String tema) {
        this.tema = tema;
    }
    
    public Prova(String tema, List<QuestaoMultiplaEscolha> questoes) {
        this(tema);
        this.questoes = questoes;
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

    public boolean add(QuestaoMultiplaEscolha e) {
        return questoes.add(e);
    }

    public boolean remove(Questao o) {
        return questoes.remove(o);
    }

    public Iterator<QuestaoMultiplaEscolha> iterator() {
        return questoes.iterator();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public void alterar(Prova t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    
}
