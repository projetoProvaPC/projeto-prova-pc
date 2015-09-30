/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.fachada;

import br.edu.ifpe.garanhuns.projetoProvaPc.builders.ProvaBuilder;
import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.Prova;
import br.edu.ifpe.garanhuns.projetoProvaPc.estrutura.repositorios.Repositorio;
import br.edu.ifpe.garanhuns.projetoProvaPc.estrutura.repositorios.RepositorioMemoria;
import br.edu.ifpe.garanhuns.projetoProvaPc.excecoes.AutenticacaoFalhouException;
import br.edu.ifpe.garanhuns.projetoProvaPc.excecoes.IdNaoDisponivelException;
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
    
    //  Repositorios
    Repositorio<Prova> provas = new RepositorioMemoria<>();
   
    // Os métodos hahahaha
    public Autenticacao autenticar(String nome, String senha) throws AutenticacaoFalhouException {
        return new Autenticacao(nome,senha);
    }

    private void adicionar(Prova p) throws IdNaoDisponivelException {
        provas.adicionar(p);
    }

    public int getProvaProxId() {
        return provas.proxId();
    }
    
    public ProvaBuilder getProvaBuilder() {
        return new ProvaBuilder();
    }
 
    public void adicionar (ProvaBuilder pb) {
        try {
            if (pb!=null) provas.adicionar(pb.build());
        } catch (IdNaoDisponivelException ex) {
            Logger.getLogger(Fachada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
