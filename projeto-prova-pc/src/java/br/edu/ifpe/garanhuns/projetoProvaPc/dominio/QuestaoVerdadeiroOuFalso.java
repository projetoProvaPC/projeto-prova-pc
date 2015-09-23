package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

/** * @author lucas
 */
public class QuestaoVerdadeiroOuFalso extends Questao {
    
  private boolean [] correta;

  public QuestaoVerdadeiroOuFalso (String enunciado, int pontuacao, 
            Afirmacao [] afirmacoes) throws Exception {
    super(enunciado,pontuacao);
    
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

  

}
