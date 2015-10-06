/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

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

    public RespostaQuestaoMultiplaEscolha(int id,QuestaoMultiplaEscolha questao, char resposta) throws Exception {
        super(id,questao);
        if(resposta > 'e')
            throw new Exception("Reposta inválida");
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
