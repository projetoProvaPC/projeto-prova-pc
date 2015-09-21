/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

/**
 *
 * @author lucas
 */
public class RespostaQuestaoMultiplaEscolha extends RespostaQuestao<QuestaoMultiplaEscolha>{

    private char resposta;

    public RespostaQuestaoMultiplaEscolha(QuestaoMultiplaEscolha questao, char resposta) throws Exception {
        super(questao);
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
