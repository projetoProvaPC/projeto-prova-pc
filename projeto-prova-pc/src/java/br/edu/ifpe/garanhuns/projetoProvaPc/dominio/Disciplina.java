package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author lucas
 */
// Representa não só a "matéria" mas também a turma!
/* LPOOED para 2 TI Manha é um disciplina diferente
 * de LPOOED para 2 TI Tarde
**/
public class Disciplina {
    
    private String nome; // Ex: "Lingua Portuguesa II"
    
    // O código da turma. 
    // Não consegui um exemplo por que o Q está fora do ar. :(
    private String turma;
    
    // Quem ensina essa turma?
    private Professor prof; // Ou ministrante. Professor é melhor
    
    // Quem está matriculado na disciplina?
    private List<Aluno> alunos;
    // Não sei se isso é realmente necessário para nosso sistema.
    // Passível de modificações!
    
    // Construtor padrão
    public Disciplina(String nome, String turma, Professor professor) {
       this.nome = nome;
       this.turma = turma;
       this.prof = professor;
       this.alunos = new LinkedList<>(); // Achei melhor usar LinkedList
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getTurma() {
        return turma;
    }

    public Professor getProf() {
        return prof;
    }
    
    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public void setProf(Professor prof) {
        this.prof = prof;
    }
    
    // Métodos delegados de alunos
    public int quantidadeDeAlunos () {
        return alunos.size();
    }

    public boolean temALunos () {
        return ! alunos.isEmpty();
    }

    public boolean contains(Aluno a) {
        return alunos.contains(a);
    }

    public Iterator<Aluno> iterator() {
        return alunos.iterator();
    }

    public boolean add(Aluno a) {
        return alunos.add(a);
    }

    public boolean remove(Aluno a) {
        return alunos.remove(a);
    }
    
    // hashCode e equals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + Objects.hashCode(this.turma);
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
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.turma, other.turma)) {
            return false;
        }
        return true;
    }
    
}
