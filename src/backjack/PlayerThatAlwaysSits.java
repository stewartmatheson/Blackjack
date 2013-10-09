/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backjack;

/**
 *
 * @author Stewart
 */
class PlayerThatAlwaysSits extends Player {

    public PlayerThatAlwaysSits() {
    }

    @Override
    Actions action(Card dealerFirstCard) {
        return Actions.SIT;
    }

    @Override
    void placeBet() {
        if(betAmount == 20)
            return;
        else
            betAmount = 20;
    }

    
}
