import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
 
/**
 * MongoInterface class for interfacing with MongoDB.
 * MongoDB Version 3.12.10
 * @author Kiernan King
 * 
 */
public class MongoInterface {
	/**
	 * Creates a client Object of type MongoClient.
	 */
	private MongoClient client;
	
	/**
	 * Creates a LocationCollection Object of type MongoCollection.
	 */
	private static MongoCollection<Document> LocationCollection;
	
	/**
	 * Creates a database Object of type MongoDatabase.
	 */
	private MongoDatabase database;
	
	/**
	 * Creates a key Object of type String.
	 */
	private static String key;
	
	/**
	 * MongoInterface creates a MongoDB Client that interfaces with the cluster created on mongodb.com.
	 * @param key Object of type String.
	 */
	public MongoInterface(String key) {
		this.client = MongoClients.create(key);
		this.key = key;
		this.database = client.getDatabase("LDB");
		this.LocationCollection = database.getCollection("LC");
	}
	
	/**
	 * getDocuments returns the list of locations unformatted.
	 * @return Locations Object of type List
	 */
	public List<Document> getDocuments() {
		List<Document> Locations = (List<Document>) LocationCollection.find().into(new ArrayList<Document>());
		return Locations;
	}
	
	
	/**
	 * main holds the logic for testing outputs.
	 * @param args Object of type String[]
	 */
	public static void main(String[] args) {
		MongoInterface MI = new MongoInterface(key);
		List<Document> Locs = MI.getDocuments();
		for(Document d : Locs) {
			System.out.println(d);
		}
	}
}

