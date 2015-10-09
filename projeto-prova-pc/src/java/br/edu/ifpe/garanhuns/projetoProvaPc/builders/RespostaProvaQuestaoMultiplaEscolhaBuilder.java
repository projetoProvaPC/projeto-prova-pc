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
import java.util.Iterator;

/**
 *
 * @author lucas
 */
public class RespostaProvaQuestaoMultiplaEscolhaBuilder {

    private String matricula;
    private AplicacaoDaProva ap;
    private RespostaProva rp;
    
    public RespostaProvaQuestaoMultiplaEscolhaBuilder(String matricula, AplicacaoDaProva ap) {
        this.matricula = matricula;
        this.ap = ap;
        this.rp = new RespostaProva(matricula, ap);
    }

    public void responder(QuestaoMultiplaEscolha q, char resposta) {
        RespostaQuestaoMultiplaEscolha rq = new RespostaQuestaoMultiplaEscolha(q, resposta);
        ap.adicionar(rp);
    }

    public AplicacaoDaProva getAplicacao() {
        return ap;
    }

    public RespostaProva build() {
        return rp;
    }

    public Iterator<QuestaoMultiplaEscolha> iterator() {
        return ap.getProva().iterator();
    }
    
}
