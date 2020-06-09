package controller;

import org.bson.Document;
import view.LoginRequest;
import view.UserLogin;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.Connection;
import static com.mongodb.client.model.Filters.*;


public class LoginController {
	public static boolean usererror = false;
	public static boolean passerror = false;

	public UserLogin checkUser(String email, String password) {
		LoginRequest l = new LoginRequest(email, password);
		MongoDatabase database = Connection.getConnection().getDatabase("RideShare");
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
	