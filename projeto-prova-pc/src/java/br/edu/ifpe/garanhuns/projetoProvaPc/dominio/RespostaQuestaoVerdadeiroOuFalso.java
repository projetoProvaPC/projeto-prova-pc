package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

/**
 * @author lucas
 */
public class RespostaQuestaoVerdadeiroOuFalso extends RespostaQuestao<QuestaoVerdadeiroOuFalso>{

    private boolean [] resposta;

    public RespostaQuestaoVerdadeiroOuFalso(QuestaoVerdadeiroOuFalso questao, boolean [] resposta) throws Exception {
        super(questao);
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
