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
      Afirmacao a = afirmacoes.get(i);
      correta[i] = afirmacoes.get(i).veracidade();
      super.add(afirmacoes.get(i));
    }
    
  }

  

}
