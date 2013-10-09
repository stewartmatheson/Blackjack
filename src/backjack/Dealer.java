/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backjack;

/**
 *
 * @author Stewart
 */
class Dealer {
    public Hand hand;
    
    
    void takeCurrentBet(Player p) {
        p.cash = p.cash - p.betAmount;
    }

    Actions action() {
        if (hand.softValue() > 16)
            return Actions.SIT;
        else
            return Actions.HIT;
    }
    
}
