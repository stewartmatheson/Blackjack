/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backjack;

/**
 *
 * @author Stewart
 */
public class Backjack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Table t = new Table();
        Dealer d = new Dealer();
        t.dealer = d;
        PlayerThatAlwaysSits p = new PlayerThatAlwaysSits();
        t.players.add(p);
        t.play();
    }

    private static boolean playing() {
        return true;
    }
}
