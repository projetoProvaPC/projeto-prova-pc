/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.fachada;

import br.edu.ifpe.garanhuns.projetoProvaPc.builders.ProvaBuilder;
import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.Professor;
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
    private String tipo;
    private final Repositorio<Prova> provas = new RepositorioMemoria<>();
    private final Repositorio<Professor> professores = new RepositorioMemoria<>();
   
    // Os métodos hahahaha
    public Autenticacao autenticar(int codigo, String senha) throws AutenticacaoFalhouException {
        return new Autenticacao(codigo,senha);
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

    Professor recuperarProfessor(int codigo) {
        return professores.recuperar(codigo);
    }

    public void adicionarProfessor(String nome, int siap, String senha) {
        Professor p = new Professor(nome,siap,senha);
        try {
            professores.adicionar(p);
        } catch (Exception e) { // não tem muito o que fazer kkk depois concertamos!
            return;
        }
    }
    
}
