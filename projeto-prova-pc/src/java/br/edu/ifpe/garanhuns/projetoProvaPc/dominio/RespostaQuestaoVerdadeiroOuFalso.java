package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

import javax.persistence.*;

/**
 * @author lucas
 */
@Entity
@Table (name = "RespostaQuestaoVerdadeiroOuFalso")
public class RespostaQuestaoVerdadeiroOuFalso extends RespostaQuestao<QuestaoVerdadeiroOuFalso>{

    
    private boolean [] resposta;

    public RespostaQuestaoVerdadeiroOuFalso(int id, QuestaoVerdadeiroOuFalso questao, boolean [] resposta) throws Exception {
        super(id,questao);
    }
    
    @Override
    public double calcularPontuacao() {
        // ou tudo ou nada
        return super.getQuestao().getPercentualCorreto(resposta) * super.getQuestao().getPontuacao();
    }

    @Override
    public String getResposta() {
        return new String() + resposta;
    }
    
}
