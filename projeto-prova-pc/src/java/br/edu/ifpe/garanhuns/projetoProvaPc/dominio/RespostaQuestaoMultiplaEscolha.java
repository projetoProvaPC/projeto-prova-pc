/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

import br.edu.ifpe.garanhuns.projetoProvaPc.fachada.Logger;
import br.edu.ifpe.garanhuns.projetoProvaPc.fachada.LoggerNivel;
import javax.persistence.*;

/**
 *
 * @author lucas
 */
@Table (name = "RespostaQuestaoMultiplaEscolha")
@Entity
public class RespostaQuestaoMultiplaEscolha extends RespostaQuestao<QuestaoMultiplaEscolha>{
    @Column
    private char resposta;
    
    private String prefix = "RespostaQuestaoMultiplaEscolha::";

    public RespostaQuestaoMultiplaEscolha(QuestaoMultiplaEscolha questao, char resposta)/* throws Exception */ {
        super(questao);
        this.resposta = resposta;
        Logger.getInstance().print(LoggerNivel.DEBUG, prefix + "chamou super(questao)\n" 
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
