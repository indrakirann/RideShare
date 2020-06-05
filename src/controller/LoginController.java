package controller;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

//import database.Connection;

public class LoginController {
	private static final String DBNAME = "RideShare";

	public boolean checkUser(String email, String password) {
		String uri = "mongodb+srv://admin:NEjfExHjfdi6cSrk@chiragcluster-cqkko.mongodb.net/test";
		MongoClientURI clienturi = new MongoClientURI(uri);
		@SuppressWarnings("resource")
		MongoClient client = new MongoClient(clienturi);
		MongoDatabase database = client.getDatabase(DBNAME);
		MongoCollection<Document> collection = database.getCollection("MahekData");
	
		if ((collection.find(and(eq("Email", email), eq("Password", password))).first() != null)) {
		
			return true;
		}

		return false;
	}
}
	
