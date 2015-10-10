/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.builders;

import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.AplicacaoDaProva;
import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.QuestaoMultiplaEscolha;
import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.RespostaProva;
import br.edu.ifpe.garanhuns.projetoProvaPc.dominio.RespostaQuestaoMultiplaEscolha;
import br.edu.ifpe.garanhuns.projetoProvaPc.fachada.Logger;
import br.edu.ifpe.garanhuns.projetoProvaPc.fachada.LoggerNivel;
import java.util.Iterator;

/**
 *
 * @author lucas
 */
public class RespostaProvaQuestaoMultiplaEscolhaBuilder {

    private String matricula;
    private AplicacaoDaProva ap;
    private RespostaProva rp;
    private String prefix = "RespostaProvaQuestaoMultiplaEscolhaBuilder::";
    
    public RespostaProvaQuestaoMultiplaEscolhaBuilder(String matricula, AplicacaoDaProva ap) {
        if(ap==null) throw new NullPointerException("RespostaProvaQuestaoMultiplaEscolhaBuilder::builder::ap==null");
        this.matricula = matricula;
        this.ap = ap;
        this.rp = new RespostaProva(matricula, ap);
    }

    public void responder(QuestaoMultiplaEscolha q, char resposta) {
        Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "reponder::criando nova RespostaQuestaoMultiplaEscolha \n" +
                "::arg::q=" + q.toString() +
                "::arg::reposta" + resposta
                );
        RespostaQuestaoMultiplaEscolha rq = new RespostaQuestaoMultiplaEscolha(q, resposta);
        
        Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "responder::chamando rp.adicionar\n"
                + "::params::q = a mesma dai de cima\n"
                + "::params::rq = a RespostaQuestaoMultiplaEscolha recem criada");
        rp.adiconar(q, rq);
    }

    public AplicacaoDaProva getAplicacao() {
        return ap;
    }

    public RespostaProva build() {
        return rp;
    }

    public Iterator<QuestaoMultiplaEscolha> iterator() {
        Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "iterator::fazendo ap.getProva().iterator()");
        return ap.getProva().iterator();
    }
    
}
