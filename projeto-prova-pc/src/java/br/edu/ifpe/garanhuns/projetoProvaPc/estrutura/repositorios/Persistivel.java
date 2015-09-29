/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.estrutura.repositorios;

/**
 *
 * @author lucas
 */
public interface Persistivel<Tipo> {
    public int getId();
    public void alterar(Tipo t);
}
