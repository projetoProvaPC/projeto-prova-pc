package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

import br.edu.ifpe.garanhuns.projetoProvaPc.repositorios.Persistivel;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Table (name = "Professor")
@Entity
public class Professor implements Persistivel<Professor> {

    @Id
    @GeneratedValue
    private long id = -1;
    @Column
    private int siap;
    @Column
    private String senha;
    @OneToMany
    private final List<Prova> provas = new LinkedList<>();
    @OneToMany
    private final List<AplicacaoDaProva> aplicacoes = new LinkedList<>();

    public Professor(int siap, String senha) {
        this.siap = siap;
        this.senha = senha;
    }

    public int getSiap() {
        return siap;
    }

    public void setSiap(int siap) {
        this.siap = siap;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean testarSenha(String senha) {
        return senha != null && senha.equals(this.senha);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public void alterar(Professor t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Prova> recuperarTodasProva() {
        List<Prova> ps = new LinkedList<>();
        for (Prova prova : this.provas) {
            ps.add(prova);
        }
        return ps;
    }

    public List<AplicacaoDaProva> recuperarTodasAplicacaoDeProva() {
        List<AplicacaoDaProva> as = new LinkedList<>();
        for (AplicacaoDaProva a : this.aplicacoes) {
            as.add(a);
        }
        return as;
    }

    public void adicionarProva(Prova p) {
        this.provas.add(p);
        p.setProfessor(this);
    }

    public void adicionarAplicacaoDaProva(AplicacaoDaProva a) {
        this.aplicacoes.add(a);
    }

}
