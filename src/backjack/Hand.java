/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backjack;

import java.util.ArrayList;

/**
 *
 * @author Stewart
 */
class Hand {

    public ArrayList<Card> cards;
    
    Hand(Card randomCard, Card otherRandomCard) {
        cards = new ArrayList();
        cards.add(randomCard);
        cards.add(otherRandomCard);
    }
    
    public int hardValue () {
        int totalValue = 0;
        for (Card c : cards) {
            totalValue = totalValue + c.value(true);
        }
        return totalValue;
    }   
    
    public int softValue () {
        int totalValue = 0;
        for (Card c : cards) {
            totalValue = totalValue + c.value(false);
        }
        return totalValue;
    }
    
    public int realValue () {
        if (hardValue() > 21) 
            return softValue();
        else
            return hardValue();
       
    }

    boolean bust() {
        return softValue() > 21;
    }

    boolean blackjack() {
        return hardValue() == 21 || softValue() == 21;
    }

    boolean beats(Hand hand) {
        return hand.realValue() < this.realValue();
    }
    
    @Override
    public String toString() {
        String s = "";
        for (Card c : cards) {
            s = s +  c.toString();
        }
        
        return s;
    }
}