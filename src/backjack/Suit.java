/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backjack;

/**
 *
 * @author Stewart
 */
public enum Suit {
    HARTS,
    CLUBS,
    SPADES,
    DIAMONDS;
    
    public static Suit getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
