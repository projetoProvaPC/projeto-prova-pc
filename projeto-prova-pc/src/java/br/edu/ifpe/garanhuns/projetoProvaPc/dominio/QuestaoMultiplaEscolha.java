package br.edu.ifpe.garanhuns.projetoProvaPc.dominio;

import javax.persistence.*;

/** * @author lucas
 */
@Entity
@Table ( name = "QustãoMultiplaEscolha")
public class QuestaoMultiplaEscolha extends Questao {

    // qual das 5 é a correta? (de 0 a 4, inclusive)
    @Column
    private char correta;
    
    // O contrutor aceita um array de 5 alternativas com 4 falsas e uma correta
    // Em qualquer outro caso lança uma exceção
    public QuestaoMultiplaEscolha( String enunciado, int pontuacao, 
            Afirmacao [] alternativas) throws Exception {
        super(enunciado, pontuacao);
       
        
        // Devem ter 5 alternativas
        if(alternativas.length!=5) 
            throw new Exception("Quantidade de questoes errada! n = " + alternativas.length);
        
        boolean temUmaCorreata = false;
        
        for(char r = 'a'; r <= 'e'; r++) {
            Afirmacao a = alternativas[r - 'a'];
            // Só pode ter uma correta
            if(a.veracidade() && !temUmaCorreata ) {
                temUmaCorreata = true;
                correta = r;
            } else if (a.veracidade()) 
                throw new Exception ("Só pode haver uma alternativa correta");
            super.add(a);
        }
      
        // Deve ter pelo menos uma correta
        if(!temUmaCorreata)
            throw new Exception("Não tem nenhuma alternativa correta");
        
    }

    @Override
    public String toString() {
        return "QuestaoMultiplaEscolha{" + "enunciado=" + super.getEnunciado() + "correta=" + correta + '}';
    }
     
    
    
    public char correta ()  {
        return  (char) ('a'  + correta);
    }
    
    public Afirmacao getAlterntiva(char a) {
        return super.getAfirmacao(a - 'a');
    }
    
    public boolean isCorrect (char a) {
        return correta == a;
    }
    
}
