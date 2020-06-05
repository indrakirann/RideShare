package controller;

import model.User;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

//import database.Connection;

public class SignupController {
	private static final String DBNAME = "RideShare";

	public User createUser(String firstname, String lastname, String email, String password) {
		// check existing email, ensure no same users are being added
		//create user in db
		User u = new User(firstname, lastname, email, password);
		String uri = "mongodb+srv://admin:NEjfExHjfdi6cSrk@chiragcluster-cqkko.mongodb.net/test";
		MongoClientURI clienturi = new MongoClientURI(uri);
		@SuppressWarnings("resource")
		MongoClient client = new MongoClient(clienturi);
		MongoDatabase database = client.getDatabase(DBNAME);
		MongoCollection<Document> collection = database.getCollection("MahekData");
		if (collection.find(eq("Email", u.getEmail())).first() == null) {
			System.out.println(u.getEmail());
			Document doc = new Document("First Name", u.getFirstName())
		              .append("Last Name", u.getLastName())
		              .append("Email", u.getEmail())
		              .append("Password", u.getPassword());
			
			collection.insertOne(doc);
		//	return true;
		}
		//return false;

		// save u in db

		return u;
	}
}
	
