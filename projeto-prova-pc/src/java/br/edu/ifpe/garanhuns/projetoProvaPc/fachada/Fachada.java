/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.fachada;

import br.edu.ifpe.garanhuns.projetoProvaPc.excecoes.AutenticacaoFalhouException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class Fachada {
    
    private static Fachada instance = null;
    
    private Fachada() {}
    
    public static Fachada getInstance() {
        if(instance==null) instance = new Fachada();
        return instance;
    }
    
    // Os métodos hahahaha
    public Autenticacao autenticar(String nome, String senha) throws AutenticacaoFalhouException {
        return new Autenticacao(nome,senha);
    }
    
}
