/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.fachada;

import br.edu.ifpe.garanhuns.projetoProvaPc.builders.ProvaBuilder;
import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.*;
import br.edu.ifpe.garanhuns.projetoProvaPc.repositorios.Repositorio;
import br.edu.ifpe.garanhuns.projetoProvaPc.repositorios.RepositorioMemoria;
import br.edu.ifpe.garanhuns.projetoProvaPc.excecoes.AutenticacaoFalhouException;
import br.edu.ifpe.garanhuns.projetoProvaPc.excecoes.IdNaoDisponivelException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public final class Fachada {
    
    private RandomString rs = new RandomString(5);
    
    private static Fachada instance = null;
    
    private Fachada() {
        try {
            adicionarProfessor(123,"123");
        } catch (IdNaoDisponivelException ex) {
            Logger.getLogger(Fachada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Fachada getInstance() {
        if(instance==null) instance = new Fachada();
        return instance;
    }
    
    //  Repositorios
    private String tipo;
    private final Repositorio<Prova> provas = new RepositorioMemoria<>();
    private final Repositorio<Professor> professores = new RepositorioMemoria<>();
    private final Repositorio<AplicacaoDaProva> aplicacoes_das_provas = new RepositorioMemoria<>();
    
    // Isso aqui tem que ser melhorado!
    private final HashMap <String,AplicacaoDaProva> senhas = new HashMap<>();
   
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
 
    public void adicionar (Autenticacao a, ProvaBuilder pb) {
        try {
            if (a != null ) {
                pb.setProfessor(a.getProfessor());
                if (pb!=null) 
                    provas.adicionar(pb.build());
            }
        } catch (IdNaoDisponivelException ex) {
            Logger.getLogger(Fachada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Professor recuperarProfessor(int siap) {
        return professores.recuperar(siap);
    }

    public void adicionarProfessor(int siap, String senha) throws IdNaoDisponivelException {
        Professor p = new Professor(siap,senha);
        professores.adicionar(p);
    }

    public AplicacaoDaProva criarAplicacaoProva(Prova p, String turma) {
        AplicacaoDaProva a = new AplicacaoDaProva(this.aplicacoes_das_provas.proxId(), p, gerarSenha(), turma);
        try {
            this.aplicacoes_das_provas.adicionar(a);
            this.senhas.put(a.getSenha(), a);
        } catch (IdNaoDisponivelException ex) {
            Logger.getLogger(Fachada.class.getName()).log(Level.SEVERE, null, ex); // mudar
        }
        return a;
    }

    private String gerarSenha() {
        return rs.nextString();
    }

    public AplicacaoDaProva responderProva(String matricula, String senha) {
        return this.senhas.get(senha);
    }

    public List<Prova> recuperarTodasAsProvas(Autenticacao a) {
        List<Prova> provas = new LinkedList<>();
        Professor professor = a.getProfessor();
        
        for (Prova prova : this.provas.recuperar()) {
            if(prova.getProfessor().equals(professor)) 
                provas.add(prova);
        }
        return provas;
    }

    public List<AplicacaoDaProva> recuperarAplicaoDaProva(Autenticacao a) throws AutenticacaoFalhouException {
        if(a==null) throw new AutenticacaoFalhouException();
        List<AplicacaoDaProva> provas = new LinkedList<>();
        Professor professor = a.getProfessor();
        
        for (AplicacaoDaProva prova : this.aplicacoes_das_provas.recuperar()) {
            if(prova.getProfessor().equals(professor)) 
                provas.add(prova);
        }
        return provas;
    }

    public Object recuperarRespostasAplicacaoDaProva(AplicacaoDaProva ap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
