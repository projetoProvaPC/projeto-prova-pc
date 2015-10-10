package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

import java.io.Serializable;
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
public abstract class RespostaQuestao<T extends Questao> implements Serializable{
    
    @Id
    @GeneratedValue
    private long id;
    
    @ManyToOne
    private T questao;

    public RespostaQuestao() {
    }
    
    public RespostaQuestao(T questao) {
        //this.id=-1;
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
