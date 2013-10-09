/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stewart
 */
public class Backjack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database d;
        try {
            d = new Database();
            start(d);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Backjack.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }

    private static void start(Database d) { 
        int tableCount = 1;
        for (int i = 0; i < tableCount; i++) {
            new Thread(new TableRunnable(d)).start();
        }    
    }
}
