package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

import br.edu.ifpe.garanhuns.projetoProvaPc.repositorios.Persistivel;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table (name = "prova")
public class Prova implements Persistivel<Prova> , Serializable{

    @Id
    @GeneratedValue
    private long id;
    @Column
    private String tema;
    @OneToMany ( cascade = CascadeType.ALL )
    private List<QuestaoMultiplaEscolha> questoes = new ArrayList<>();
    @ManyToOne
    private Professor professor;

    public Prova() {
    }
    
    public Prova(String tema) {
        //this.id = -1;
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
    
    public List<Questao> getQuestoes() {
        List<Questao> qs = new LinkedList<>();
        for (QuestaoMultiplaEscolha questaoMultiplaEscolha : this.questoes) {
            qs.add(questaoMultiplaEscolha);
        }
        return qs;
    }
    
}
