package database;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Connection {
	private static final String DBNAME = "RideShare";

	public static MongoClient getConnection() {
		String uri = "mongodb+srv://admin:NEjfExHjfdi6cSrk@chiragcluster-cqkko.mongodb.net/test";
		MongoClientURI clientURI = new MongoClientURI(uri);
		MongoClient mongoclient = new MongoClient(clientURI);
		return mongoclient;

	}
	public static MongoCollection<Document> saveCollection(String CollectionName) {
		
		MongoDatabase database = getConnection().getDatabase(DBNAME);
		MongoCollection<Document> collection = database.getCollection(CollectionName);
		return collection;
	}

	public static boolean saveDoc(String CollectionName, Document doc) {
		MongoDatabase database = getConnection().getDatabase(DBNAME);
		MongoCollection<Document> collection = database.getCollection(CollectionName);
		collection.insertOne(doc);
		return true;
	}

	public static MongoCollection<Document> readAllData(String collectionName) {
		MongoDatabase database = getConnection().getDatabase(DBNAME);
		return database.getCollection(collectionName);

	}
	
	public static boolean attributeExists(MongoCollection<Document> collection, String attribute1, String attribute2) {
		return (collection.find(eq(attribute1, attribute2)).first() != null);
	}
	
	

}