/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Stewart
 */
class Table {
    Dealer dealer;
    ArrayList<Player> players;
    Database db;
    
    public Table(Database d) {
        players = new ArrayList();
        db = d;
    }

    void play() {
        while(continuePlay()) {
            playHand();
        }
    }

    private boolean continuePlay() {
        return true;
    }

    
    private void playHand() {
        //players place bets
        for(Player p : players) {
            p.placeBet();
        }
        
        //dealer deals
        dealer.hand = new Hand(randomCard(), randomCard());
        
        //move around the table and play hands
        for(Player p : players) {
            //create a new hand for the player
            p.hand = new Hand(randomCard(), randomCard());
            
            // lets pay the player that got a black jack
            if(p.hand.blackjack()) {
                p.cash = (int) (p.cash + p.betAmount * 1.6);
                db.saveHand(p.hand, dealer.hand);
                p.hand = null;
            } else {
                //in this case the player has not got a blackjack
                while(p.action(dealer.hand.cards.get(1)) == Actions.HIT) {
                    //loop while the player want's to hit
                    p.hand.cards.add(randomCard());

                    //tesk if the player has bust
                    if (p.hand.bust()) {
                        //lets remove the bet from the player
                        dealer.takeCurrentBet(p);

                        //also take their hand
                        db.saveHand(p.hand, dealer.hand);
                        p.hand = null;
                        break;
                    }
                }       
            }  
        }
        
        //dealer plays
        while(dealer.action() == Actions.HIT){
            dealer.hand.cards.add(randomCard());
            if (dealer.hand.bust()) {
                //pay players
                for (Player p : players) {
                    if(p.hand != null && !p.hand.bust()) {
                        p.cash = p.cash + p.betAmount;
                        db.saveHand(p.hand, dealer.hand);                        
                        p.hand = null;
                    }

                    // stop hitting
                    break;
                }
            }
        }

        // by this stage all players have sat. Including the dealer.
        for (Player p : players ) {
            if(p.hand != null) {
                //if the player wins
                if (p.hand.beats(dealer.hand)) {
                    p.cash = p.cash + p.betAmount;
                } else if (dealer.hand.beats(p.hand)) {
                    p.cash = p.cash - p.betAmount;
                    p.betAmount = 0;
                }
                
                db.saveHand(p.hand, dealer.hand);
                p.hand = null;
            }
        } 
    }
    
    private Card randomCard() {
        Card c = new Card();
        //should really have random suits here
        c.suit = Suit.getRandom();
        Random rand = new Random();
        int r = rand.nextInt(13);
        
        if (r == 0)
            r = 1;
        
        if(r == 1) {
            c.type = Type.ACE;
            c.valueValue = 1;
        } else if (r == 11) {
            c.type = Type.JACK;
            c.valueValue = 10;
        } else if (r == 12) {
            c.type = Type.QUEEN;
            c.valueValue = 10;
        } else if (r == 13) {
            c.type = Type.KING;
            c.valueValue = 10;
        } else {
            c.type = Type.VALUE;
            c.valueValue = r;
        }
        
        return c;
    }
}