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
public interface RepositorioAplicacaoDaProva extends Repositorio<AplicacaoDaProva> {
    
    public AplicacaoDaProva recuperarPorSenha(String senha);
    
}
