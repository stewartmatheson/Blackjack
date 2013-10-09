/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import java.net.UnknownHostException;

/**
 *
 * @author Stewart
 */
public class Database {

    MongoClient client;
    private DBCollection handsCollection;
    
    public Database () throws UnknownHostException {
        client = new MongoClient("localhost", 27017 );
        client.setWriteConcern(WriteConcern.UNACKNOWLEDGED);
        DB db = client.getDB( "blackjack" );
        handsCollection = db.getCollection("hands");
    }
    
    void saveHand(Hand playersHand, Hand dealersHand) {
        BasicDBObject doc = new BasicDBObject()
                .append("playerHand", playersHand.toString())
                .append("dealerHand", dealersHand.toString());
        handsCollection.insert(doc);
    }

    public long handCount() {
        return handsCollection.count();
    }
    
    public long collectionSizeInGB() {
        return handsCollection.getStats().size() / 1000 / 1000 / 1000;
    }
    
}
