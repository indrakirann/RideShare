package controller;

import model.User;
import view.SignupError;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

//import database.Connection;

public class SignupController {
	private static final String DBNAME = "RideShare";
	public boolean varError = false;
	public boolean rptError = false;
	
	public User createUser(String firstname, String lastname, String email, String password, String rptpassword) {
		// check existing email, ensure no same users are being added
		//create user in db
		User u = new User(firstname, lastname, email.toLowerCase(), password, rptpassword);
		return u;
	}
	
	public SignupError frontCreateUser(String firstname, String lastname, String email, String password, String rptpassword) {
		User u = new User(firstname, lastname, email.toLowerCase(), password, rptpassword);
		String uri = "mongodb+srv://admin:NEjfExHjfdi6cSrk@chiragcluster-cqkko.mongodb.net/test";
		MongoClientURI clienturi = new MongoClientURI(uri);
		@SuppressWarnings("resource")
		MongoClient client = new MongoClient(clienturi);
		MongoDatabase database = client.getDatabase(DBNAME);
		MongoCollection<Document> collection = database.getCollection("MahekData");
		if ((collection.find(eq("Email", u.getEmail())).first() != null)) {
			varError = true;
			SignupError returnError = new SignupError(firstname, lastname, email, password, varError, rptError);
			return returnError;
		} else if(!(u.getPassword().equals(u.getrptPassword()))) {
			varError = false;
			rptError = true;
			SignupError returnError = new SignupError(firstname, lastname, email, password, varError, rptError);
			return returnError;
		}
		
		else {
			System.out.println(u.getEmail());
			Document doc = new Document("First Name", u.getFirstName())
		              .append("Last Name", u.getLastName())
		              .append("Email", u.getEmail())
		              .append("Password", u.getPassword());
			varError = false;
			rptError = false;
			collection.insertOne(doc);
			SignupError returnError = new SignupError(firstname, lastname, email, password, varError, rptError);
			return returnError;
			
			//returns false if there is no error
			//if ((collection.find(eq("Email", u.getEmail())).first() == null))
				
			}
	}
	
}

	
