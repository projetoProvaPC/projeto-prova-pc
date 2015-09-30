/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.fachada;

import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.Professor;
import br.edu.ifpe.garanhuns.projetoProvaPc.excecoes.AutenticacaoFalhouException;

/**
 *
 * @author lucas
 */
public class Autenticacao {
    
    public Autenticacao(int codigo, String senha) throws AutenticacaoFalhouException{
        Fachada f = Fachada.getInstance();
        Professor p = f.recuperarProfessor(codigo);
        if(!p.testarSenha(senha)) {
            throw new AutenticacaoFalhouException();
        }
    }

}
