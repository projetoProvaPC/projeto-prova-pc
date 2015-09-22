package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

/**
 *
 * @author lucas
 */
public class RespostaQuestaoMultiplaEscolha extends RespostaQuestao<QuestaoVerdadeiroOuFalso>{

    private boolean [] resposta;

    public RespostaQuestaoMultiplaEscolha(QuestaoVerdadeiroOuFalso questao, boolean [] resposta) throws Exception {
        super(questao);
        if(resposta.length > 5)
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
