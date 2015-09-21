package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

/**
 * @author lucas
 * @param <T>
 */

// IMPORTANTE!
// Esta classe guarda a resposta de um aluno a uma determinada questão
// É abstract por que pode ser RepostaQuestaoMultiplaEscolha ou
// RepostaQuestaoVerdadeiroOuFalso
public abstract class RespostaQuestao<T extends Questao> {
    
    private T questao;

    public RespostaQuestao(T questao) {
        this.questao = questao;
    }

    public T getQuestao() {
        return questao;
    }

    protected void setQuestao(T questao) {
        this.questao = questao;
    }
    
    public abstract double calcularPontuacao();
    
    public abstract String getResposta();
    
}
