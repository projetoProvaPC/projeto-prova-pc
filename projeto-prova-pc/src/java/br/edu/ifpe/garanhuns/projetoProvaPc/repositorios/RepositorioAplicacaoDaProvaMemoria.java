/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.repositorios;

import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.AplicacaoDaProva;
import java.util.List;

/**
 *
 * @author lucas
 */
public class RepositorioAplicacaoDaProvaMemoria 
                            extends RepositorioMemoria<AplicacaoDaProva> 
                            implements RepositorioAplicacaoDaProva {

    @Override
    public AplicacaoDaProva recuperarPorSenha(String senha) {
        if(senha==null) throw new NullPointerException("RepositorioAplicacaoDaProvaMemoria::recuperarPorSenha::param::senha==null");
        List<AplicacaoDaProva> as = super.recuperar();
        
        for (AplicacaoDaProva a : as)
            if (senha.equals(a.getSenha())) 
                return a; 
        return null;
    }
    
}
