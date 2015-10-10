/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.repositorios;

import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.AplicacaoDaProva;

/**
 *
 * @author lucas
 */
public class RepositorioAplicacaoDaProvaDB extends RepositorioDB<AplicacaoDaProva> implements RepositorioAplicacaoDaProva {

    @Override
    protected String getClasse() {
        return "AplicacaoDaProva";
    }

    @Override
    public AplicacaoDaProva recuperarPorSenha(String senha) {
        return (AplicacaoDaProva) super.dao.recover("from "+getClasse()+" where senha = :param",senha).get(0);
    }

}
