package controller;

import org.bson.Document;
import view.LoginRequest;
import view.UserLogin;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

//import database.Connection;

public class LoginController {
	private static final String DBNAME = "RideShare";
	public static boolean usererror = false;
	public static boolean passerror = false;

	public UserLogin checkUser(String email, String password) {
		System.out.print(email);
		LoginRequest l = new LoginRequest(email, password);
		String uri = "mongodb+srv://admin:NEjfExHjfdi6cSrk@chiragcluster-cqkko.mongodb.net/test";
		MongoClientURI clienturi = new MongoClientURI(uri);
		@SuppressWarnings("resource")
		MongoClient client = new MongoClient(clienturi);
		MongoDatabase database = client.getDatabase(DBNAME);
		MongoCollection<Document> collection = database.getCollection("MahekData");
		if ((collection.find(eq("Email", l.getEmail())).first() == null)) {
			usererror = true;
			passerror=false;
			UserLogin u = new UserLogin(email, password, usererror, passerror);
			return u;
		}
	
	
		if ((collection.find(and(eq("Email", l.getEmail()), eq("Password", l.getPassword()))).first() == null)) {
			passerror = true;
			UserLogin u = new UserLogin(email, password, usererror, passerror);
			return u;
			
		}
		usererror = false;
		passerror = false;
		UserLogin u = new UserLogin(email, password, usererror, passerror);
		return u;
	}
}
	
