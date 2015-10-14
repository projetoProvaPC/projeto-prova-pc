/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.repositorios;

import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.Afirmacao;
import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.Professor;
import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.Prova;
import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.Questao;

/**
 *
 * @author lucas
 */
public class RepositorioProfessorDB extends RepositorioDB<Professor> implements RepositorioProfessor {

    @Override
    public Professor recuperarPorSiap(int siap) {
        return (Professor) super.dao.recover("from " + getClasse() + " where siap=" + siap).get(0);
    }

    @Override
    protected String getClasse() {
        return Professor.class.getName();
    }
    
}
