/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.builders;

import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.*;
import br.edu.ifpe.garanhuns.projetoProvaPc.excecoes.IdNaoDisponivelException;
import br.edu.ifpe.garanhuns.projetoProvaPc.fachada.Fachada;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lucas
 */
public class ProvaBuilder {

    private String tema;
    private Set<QuestaoMultiplaEscolha> questoes = new HashSet<QuestaoMultiplaEscolha>();
    
    // Para contruir questoes de multiplaEscolha
    private String enunciado;
    private int pontuacao;
    private Set<Afirmacao> afirmacoes = new HashSet<Afirmacao>();
    private Professor prof;
    
    public ProvaBuilder() {
    }

    public Professor getProfessor() {
        return prof;
    }

    public void setProfessor(Professor prof) {
        this.prof = prof;
    }
    
    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTema() {
        return tema;
    }
    
    public void adicionarQuestao(String enunciado, int pontuacao) {
        this.enunciado = enunciado;
    }
    
    public void adicionarAlternativa(boolean veracidade, String afirmativa) {
        Afirmacao a = new Afirmacao(afirmativa,veracidade);
        afirmacoes.add(a);
    }
    
    public void buildQuestao() throws Exception {
        QuestaoMultiplaEscolha q = new QuestaoMultiplaEscolha(enunciado, pontuacao,afirmacoes.toArray(new Afirmacao [0]));
        questoes.add(q);
        afirmacoes.clear();
        this.enunciado = null;
    }
    
    public Prova build() {
        Prova p = new Prova(this.prof.proximoIdProva(), tema);
        for (QuestaoMultiplaEscolha questaoMultiplaEscolha : questoes) {
            p.add(questaoMultiplaEscolha);
        }
        prof.adicionarProva(p);
        return p;
    }
    
}
