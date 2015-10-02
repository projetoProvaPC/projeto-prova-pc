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
    private String disciplina;

    // essa senha tem que ser gerada automaticamente
    // vamos ver depois como fazer isso
    public AplicacaoDaProva(Prova prova, String senha, String disciplina) {
        this.senha = senha;
        this.disciplina = disciplina;
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

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    public String getTurma() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
