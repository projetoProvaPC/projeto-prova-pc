/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.estrutura.repositorios;

import java.util.List;

/**
 *
 * @author lucas
 */
public interface Repositorio<Tipo extends Persistivel> {
    
    public void adicionar(Tipo t) throws IdNaoDisponivel;
    public Tipo remover(int id);
    public void alterar(Tipo t);
    public Tipo recuperar(int id);
    public List<Tipo> recuperar();
    public int proxId();
}
