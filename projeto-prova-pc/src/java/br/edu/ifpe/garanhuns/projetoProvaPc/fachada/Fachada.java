/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.fachada;

import br.edu.ifpe.garanhuns.projetoProvaPc.builders.ProvaBuilder;
import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.AplicacaoDaProva;
import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.Professor;
import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.Prova;
import br.edu.ifpe.garanhuns.projetoProvaPc.estrutura.repositorios.Repositorio;
import br.edu.ifpe.garanhuns.projetoProvaPc.estrutura.repositorios.RepositorioMemoria;
import br.edu.ifpe.garanhuns.projetoProvaPc.excecoes.AutenticacaoFalhouException;
import br.edu.ifpe.garanhuns.projetoProvaPc.excecoes.IdNaoDisponivelException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class Fachada {
    
    private RandomString rs = new RandomString(5);
    
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

    public void adicionarProfessor(int siap, String senha) {
        Professor p = new Professor(siap,senha);
        try {
            professores.adicionar(p);
        } catch (Exception e) { // não tem muito o que fazer kkk depois concertamos!
            return;
        }
    }

    public AplicacaoDaProva criarAplicacaoProva(Prova p, String turma) {
        return new AplicacaoDaProva(p, gerarSenha(), turma);
    }

    private String gerarSenha() {
        return rs.nextString();
    }

    public AplicacaoDaProva responderProva(String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Prova> recuperarTodasAsProvas(Professor professor) {
        /*List<Prova> provas = new LinkedList<>();
        
        for (Prova prova : this.provas.recuperar()) {
            if(prova.getProfessor().equals(professor)) 
                provas.add(prova);
        }
        return provas;*/
        return this.provas.recuperar();
    }
    
}
