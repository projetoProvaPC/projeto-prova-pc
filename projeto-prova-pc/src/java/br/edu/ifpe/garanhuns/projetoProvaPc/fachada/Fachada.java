/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.fachada;

import br.edu.ifpe.garanhuns.projetoProvaPc.builders.ProvaBuilder;
import br.edu.ifpe.garanhuns.projetoProvaPc.builders.RespostaProvaQuestaoMultiplaEscolhaBuilder;
import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.*;
import br.edu.ifpe.garanhuns.projetoProvaPc.excecoes.AutenticacaoFalhouException;
import br.edu.ifpe.garanhuns.projetoProvaPc.excecoes.IdNaoDisponivelException;
import br.edu.ifpe.garanhuns.projetoProvaPc.repositorios.RepositorioAplicacaoDaProva;
import br.edu.ifpe.garanhuns.projetoProvaPc.repositorios.RepositorioAplicacaoDaProvaDB;
import br.edu.ifpe.garanhuns.projetoProvaPc.repositorios.RepositorioAplicacaoDaProvaMemoria;
import br.edu.ifpe.garanhuns.projetoProvaPc.repositorios.RepositorioProfessor;
import br.edu.ifpe.garanhuns.projetoProvaPc.repositorios.RepositorioProfessorDB;
import br.edu.ifpe.garanhuns.projetoProvaPc.repositorios.RepositorioProfessorMemoria;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lucas
 */
public final class Fachada {
    
    private RandomString rs = new RandomString(5);
    
    private static Fachada instance = null;
    private String prefix = "Fachada::";
    
    private Fachada() {}
    
    public static Fachada getInstance() {
        if(instance==null) instance = new Fachada();
        return instance;
    }
    
    //  Repositorios
    private String tipo;
    private final RepositorioProfessor professores = new RepositorioProfessorDB();
    private final RepositorioAplicacaoDaProva aplicacoes_das_provas = new RepositorioAplicacaoDaProvaDB();
    
    // Isso aqui tem que ser melhorado!
    private final HashMap <String,AplicacaoDaProva> senhas = new HashMap<>();
   
    // Os métodos hahahaha
    public Autenticacao autenticar(int codigo, String senha) throws AutenticacaoFalhouException {
        return new Autenticacao(codigo,senha);
    }
    
    public ProvaBuilder getProvaBuilder() {
        return new ProvaBuilder();
    }
 
    public void adicionar (Autenticacao a, ProvaBuilder pb) throws AutenticacaoFalhouException {
        if(a==null) throw new AutenticacaoFalhouException("Fachada::adicionar::params:Autenticacao");
        
        pb.setProfessor(a.getProfessor());
        
        pb.build();
        
        this.professores.atualizar(a.getProfessor());
    }

    public Professor recuperarProfessor(int siap) {
        return professores.recuperarPorSiap(siap);
    }

    public void adicionarProfessor(int siap, String senha) throws IdNaoDisponivelException {
        Professor p = new Professor(siap,senha);
        professores.adicionar(p);
    }

    public AplicacaoDaProva criarAplicacaoProva(Prova p, String turma) {
        AplicacaoDaProva a = null;
        try {
            a = new AplicacaoDaProva(p, gerarSenha(), turma);
            this.aplicacoes_das_provas.adicionar(a);
            p.getProfessor().adicionarAplicacaoDaProva(a);
            this.professores.atualizar(p.getProfessor());
        } catch (IdNaoDisponivelException ex) {
            Logger.getInstance().print(LoggerNivel.ERRO, prefix + "criarAplicacaoProva::IdNaoDisponivelException");
        }
        return a;
    }

    private String gerarSenha() {
        return rs.nextString();
    }

    public AplicacaoDaProva responderProva(String matricula, String senha) {
        return this.aplicacoes_das_provas.recuperarPorSenha(senha);
    }

    public List<Prova> recuperarTodasAsProvas(Autenticacao a) {
        return a.getProfessor().recuperarTodasProva();
    }

    public List<AplicacaoDaProva> recuperarAplicaoDaProva(Autenticacao a) throws AutenticacaoFalhouException {
        if(a==null) throw new AutenticacaoFalhouException("Fachada::recuperarAplicacaoDaProva");
        return a.getProfessor().recuperarTodasAplicacaoDeProva();
    }

    public List<RespostaProva> recuperarRespostasAplicacaoDaProva(AplicacaoDaProva ap) {
        return ap.recuperarRespostas();
    }

    public RespostaProvaQuestaoMultiplaEscolhaBuilder getRespostaProvaQuestaoMultiplaEscolhaBuilder(String matricula, String senha) {
        AplicacaoDaProva ap = this.aplicacoes_das_provas.recuperarPorSenha(senha);
        Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "getRespostaProvaQuestaoMultiplaEscolhaBuilder::recuperando por senha");
        Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "getRespostaProvaQuestaoMultiplaEscolhaBuilder::ap::senha= " + ap.getSenha());
        Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "getRespostaProvaQuestaoMultiplaEscolhaBuilder::ap::turma= " + ap.getTurma());
        Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "getRespostaProvaQuestaoMultiplaEscolhaBuilder::ap::data= " + ap.getData());
        Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "getRespostaProvaQuestaoMultiplaEscolhaBuilder::ap::professor::siap= " + ap.getProfessor().getSiap());
        Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "getRespostaProvaQuestaoMultiplaEscolhaBuilder::ap::tema= " + ap.getTema());
        Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "getRespostaProvaQuestaoMultiplaEscolhaBuilder::criando nova RespostaProvaQuestaoMultiplaEscolhaBuilder pela matricula e pela AplicacaoDaProva recuperada");
        return new RespostaProvaQuestaoMultiplaEscolhaBuilder(matricula,ap);
    }

    public double adicionar(RespostaProvaQuestaoMultiplaEscolhaBuilder builder) {
        RespostaProva rp = builder.build();
        builder.getAplicacao().adicionar(rp);
        this.aplicacoes_das_provas.atualizar(builder.getAplicacao());
        return rp.pontuacao();
    }
    
    
}
