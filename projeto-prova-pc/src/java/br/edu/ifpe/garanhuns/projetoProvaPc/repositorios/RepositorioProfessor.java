/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.repositorios;

import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.Professor;

/**
 *
 * @author lucas
 */
public interface RepositorioProfessor extends Repositorio<Professor>{
    public Professor recuperarPorSiap(int siap);
}
