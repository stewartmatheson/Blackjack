/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Stewart
 */
class Card {
    public Suit suit;
    public Type type;
    public int valueValue;
    
    int value(boolean hard) {
        if(type == Type.VALUE) {
            return valueValue;
        } else if (type == Type.JACK || 
                   type == Type.QUEEN || 
                   type == Type.KING) 
        {
            return 10;
        } else {
            if (hard) {
                return 11;
            } else {
                return 1;
            }
        }
    }
    
    @Override
    public String toString() {
        if (type == Type.JACK)
            return "J";
        
        if (type == Type.ACE)
            return "A";
        
        if (type == Type.QUEEN)
            return "Q";
        
        if (type == Type.KING)
            return "K";
        
        return new Integer(valueValue).toString();
    }
}