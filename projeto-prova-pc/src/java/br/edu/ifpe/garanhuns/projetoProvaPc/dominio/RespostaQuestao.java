package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

import javax.persistence.*;

/**
 * @author lucas
 * @param <T>
 */

// IMPORTANTE!
// Esta classe guarda a resposta de um aluno a uma determinada questão
// É abstract por que pode ser RepostaQuestaoMultiplaEscolha ou
// RepostaQuestaoVerdadeiroOuFalso
@MappedSuperclass
public abstract class RespostaQuestao<T extends Questao> {
    
    @Id
    @GeneratedValue
    private long id = -1;
    
    @ManyToOne
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
}
