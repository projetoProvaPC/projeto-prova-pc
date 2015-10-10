/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

import br.edu.ifpe.garanhuns.projetoProvaPc.fachada.Logger;
import br.edu.ifpe.garanhuns.projetoProvaPc.fachada.LoggerNivel;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author lucas
 */
@Entity
@Table (name = "reposta_questao_multipla_escolha")
public class RespostaQuestaoMultiplaEscolha extends RespostaQuestao<QuestaoMultiplaEscolha> implements Serializable {
    @Column
    private char resposta;
    
    private String prefixo = "RespostaQuestaoMultiplaEscolha::";

    public RespostaQuestaoMultiplaEscolha() {}

    public RespostaQuestaoMultiplaEscolha(QuestaoMultiplaEscolha questao, char resposta)/* throws Exception */ {
        super(questao);
        this.resposta = resposta;
        Logger.getInstance().print(LoggerNivel.DEBUG, prefixo + "chamou super(questao)\n" 
                + "::params::questao= " + questao.toString());
        /*if(resposta > 'e')
            throw new Exception("Reposta inválida");*/
    }
    
    @Override
    public double calcularPontuacao() {
        // ou tudo ou nada
        return super.getQuestao().isCorrect(resposta) ? 1 : 0;
    }

    @Override
    public String getResposta() {
        return new String() + resposta;
        
    }
    
}
