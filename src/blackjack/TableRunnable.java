/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;


/**
 *
 * @author Stewart
 */
public class TableRunnable implements Runnable {

    Database database;
    
    TableRunnable(Database d) {
        database = d;
    }

    @Override
    public void run() {
        Table t = new Table(database);
        Dealer d = new Dealer();
        t.dealer = d;
        PlayerThatAlwaysSits p = new PlayerThatAlwaysSits();
        t.players.add(p);
        t.play();
    }
    
}
