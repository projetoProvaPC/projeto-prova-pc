/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.repositorios;

import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.Professor;
import java.util.List;

/**
 *
 * @author lucas
 */
public class RepositorioProfessorMemoria extends RepositorioMemoria<Professor> implements RepositorioProfessor {

    @Override
    public Professor recuperarPorSiap(int siap) {
        List<Professor> recuperar = super.recuperar();
        for (Professor p : recuperar)
            if(p.getSiap()==siap)
                return p;
        return null;
    }
    
}
