package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;


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
public class AplicacaoDaProva {
    
    private Prova prova;
    private Date data;
    private String senha;
    private Disciplina disciplina;

    // essa senha tem que ser gerada automaticamente
    // vamos ver depois como fazer isso
    public AplicacaoDaProva(Date data, String senha) {
        this.data = data;
        this.senha = senha;
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

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina d) {
        this.disciplina = d;
    }
}
