package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;


import br.edu.ifpe.garanhuns.projetoProvaPc.repositorios.Persistivel;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 20141D12GR0416
 */
@Table (name = "aplicacao_da_prova")
@Entity
public class AplicacaoDaProva implements Persistivel<AplicacaoDaProva> {
    
    @Id
    private int id;
    @ManyToOne
    private Prova prova;
    @Column
    private Date data;
    @Column
    private String senha;
    @Column
    private String turma;
    @OneToMany
    List<RespostaProva> respostas = new LinkedList<>();

    public AplicacaoDaProva() {
    }

    // essa senha tem que ser gerada automaticamente
    // vamos ver depois como fazer isso
    public AplicacaoDaProva(int id, Prova prova, String senha, String turma) {
        this.id = id;
        this.senha = senha;
        this.turma = turma;
        this.prova = prova;
    }

    public Date getData() {
        return data;
    }

    public String getSenha() {
        return senha;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTurma() {
        return turma;
    }

    public Prova getProva() {
        return prova;
    }

    public Object getTema() {
        return this.prova.getTema();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void alterar(AplicacaoDaProva t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Professor getProfessor() {
        return this.prova.getProfessor();
    }

    public List<RespostaProva> recuperarRespostas() {
        List<RespostaProva> rc = new LinkedList<>();
        for (RespostaProva respostaProva : respostas) {
            rc.add(respostaProva);
        }
        return rc;
    }
    
    

}
