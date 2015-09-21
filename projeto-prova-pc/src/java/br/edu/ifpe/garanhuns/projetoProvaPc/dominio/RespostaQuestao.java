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
    private Aluno aluno;

    public T getQuestao() {
        return questao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    protected void setQuestao(T questao) {
        this.questao = questao;
    }

    protected void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public abstract double calcularPontuacao();
    
}
