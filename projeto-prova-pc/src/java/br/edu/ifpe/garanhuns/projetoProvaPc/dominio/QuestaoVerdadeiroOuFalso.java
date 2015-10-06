package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

import javax.persistence.*;

/** * @author lucas
 */
@Entity
@Table (name = "QuestaoVerdadeiroOuFalso")
public class QuestaoVerdadeiroOuFalso extends Questao {
   @Column 
  private boolean [] correta;

  public QuestaoVerdadeiroOuFalso (int id, String enunciado, int pontuacao, 
            Afirmacao [] afirmacoes) throws Exception {
    super(id,enunciado,pontuacao);
    
    if(afirmacoes == null || afirmacoes.length!=5)
      throw new Exception("Quantidade de afirmacoes errada.");
      
    for(int i = 0 ; i < 5 ; i++) {
      Afirmacao a = afirmacoes[i];
      correta[i] = a.veracidade();
      super.add(a);
    }
    
  }

    public double getPercentualCorreto(boolean [] repostas) {
        double r = 0;
        for (int i = 0; i < 5; i++) {
            if (!(correta[i] ^ repostas[i])) r += 0.20;
        }
        return r;
    }

    public boolean[] getCorreta() {
        return correta;
    }

  

}
