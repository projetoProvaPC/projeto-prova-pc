package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author lucas
 */

//README

//Essa classe está no diagrama de classes como RespostaAlunoProva.
//Eu coloquei esse nome mais simples que é suficiente para indentificá-la.
//Essa classe tem uma função muito importante: no final, é ela quem 

// Ou RespostasAlunoProva
public class RespostaProva {

    // São a resposta de uma aluno
    private Aluno aluno;
    // Em uma determinada aplicação da prova
    private AplicacaoDaProva prova; //  isso também identifica a prova
    // Relaciona questoes com as repostas para elas!
    private final Map<Questao,RespostaQuestao> respostas;

    // Construtor simples
    public RespostaProva(Aluno aluno, AplicacaoDaProva prova) {
        this.aluno = aluno;
        this.prova = prova;
        this.respostas = new HashMap<>();
    }
    
    // Getters e setters
    // Evite usar esses setters, já que não é uma coisa legal de se mudar.
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public AplicacaoDaProva getProva() {
        return prova;
    }

    public void setProva(AplicacaoDaProva prova) {
        this.prova = prova;
    }
    
    // Métodos para lidar com as respotas: adicionar, remover, consultar, etc.
    
    // Recupera a resposta de uma pergunta.
    // Retorno NULL indica que o aluno não reposndeu essa pergunta
    public RespostaQuestao get (Questao q) {
        return respostas.get(q);
    }

    // Adiciona a respota a uma pergunta.
    // Na verdade, ele substitui, porque todas as perguntas já foram
    // adicionadas.
    public void adiconar(Questao q, RespostaQuestao r) {
        respostas.replace(q, r);
    }

    // Remove a respota
    // Na verdade, apenas substitui por NULL.
    public RespostaQuestao remover(Questao q) {
        return respostas.replace(q, null);
    }
    
    // Outros métodos relacionados as respostas
    public double pontuacao () {
        throw new UnsupportedOperationException(); // Operação não suportada.
    }
    
    // Outros métodos
    // Estou considerando que um aluno só pode responder a prova uma vez!
    // Portanto o hashCode() e equals() só levam o aluno e a prova em 
    // consideração.
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.aluno);
        hash = 67 * hash + Objects.hashCode(this.prova);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RespostaProva other = (RespostaProva) obj;
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.prova, other.prova)) {
            return false;
        }
        return true;
    }
    
    
}