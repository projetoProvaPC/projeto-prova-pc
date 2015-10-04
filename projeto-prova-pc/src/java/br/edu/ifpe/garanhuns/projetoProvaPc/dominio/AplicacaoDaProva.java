package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;


import br.edu.ifpe.garanhuns.projetoProvaPc.repositorios.Persistivel;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 20141D12GR0416
 */
public class AplicacaoDaProva implements Persistivel<AplicacaoDaProva> {
    
    private int id;
    private Prova prova;
    private Date data;
    private String senha;
    private String turma;

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
    
    

}
