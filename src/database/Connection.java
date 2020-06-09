package database;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Connection {

	public static MongoClient getConnection() {
		String uri = "mongodb+srv://admin:NEjfExHjfdi6cSrk@chiragcluster-cqkko.mongodb.net/test";
		MongoClientURI clientURI = new MongoClientURI(uri);
		MongoClient mongoclient = new MongoClient(clientURI);
		return mongoclient;

	}

	public static boolean save(String CollectionName, Document doc) {
		MongoDatabase database = getConnection().getDatabase("RideShare");
		MongoCollection<Document> collection = database.getCollection(CollectionName);
		collection.insertOne(doc);
		return true;
	}

	public static MongoCollection<Document> readAllData(String collectionName) {
		MongoDatabase database = getConnection().getDatabase("RideShare");
		return database.getCollection(collectionName);

	}

}