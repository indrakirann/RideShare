package controller;

import org.bson.Document;
import view.LoginRequest;
import view.UserLogin;


import com.mongodb.client.MongoCollection;
import database.Connection;
import static com.mongodb.client.model.Filters.*;


public class LoginController {
	public static boolean usererror = false;
	public static boolean passerror = false;
	public static UserLogin u;

	public UserLogin checkUser(String email, String password) {
		LoginRequest l = new LoginRequest(email, password);
		MongoCollection<Document> collection = Connection.saveCollection("MahekData");
		if (!(Connection.attributeExists(collection, "Email", l.getEmail()))) {
			usererror = true;
			passerror=false;
			u = new UserLogin(email, password, usererror, passerror);
		} if ((collection.find(and(eq("Email", l.getEmail()), eq("Password", l.getPassword()))).first() == null)) {
			passerror = true;
			u = new UserLogin(email, password, usererror, passerror);
			
		} else {
			usererror = false;
			passerror = false;
			u = new UserLogin(email, password, usererror, passerror);
		}
		return u;
	}
}
	