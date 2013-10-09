/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Stewart
 */
abstract class Player {
    public Hand hand;
    public int betAmount;
    int cash;
    abstract Actions action(Card dealerFirstCard);
    abstract void placeBet();
}
