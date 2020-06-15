package controller;

import model.User;
import view.SignupError;
import org.bson.Document;

import com.mongodb.client.MongoCollection;
import database.Connection;

public class SignupController {
	public boolean varError = false;
	public boolean rptError = false;
	public SignupError returnError;
	
	public SignupError frontCreateUser(String firstname, String lastname, String email, String password, String rptpassword) {
		User u = new User(firstname, lastname, email.toLowerCase(), password, rptpassword);
		MongoCollection<Document> collection = Connection.saveCollection("MahekData");
		if (Connection.attributeExists(collection, "Email",  u.getEmail())) {
			varError = true;
			returnError = new SignupError(firstname, lastname, email, password, varError, rptError);
		} else if(!(u.getPassword().equals(u.getrptPassword()))) {
			varError = false;
			rptError = true;
			returnError = new SignupError(firstname, lastname, email, password, varError, rptError);	
		} else {
			Document doc = new Document("First Name", u.getFirstName())
		              .append("Last Name", u.getLastName())
		              .append("Email", u.getEmail())
		              .append("Password", u.getPassword());
			varError = false;
			rptError = false;
			collection.insertOne(doc);
			returnError = new SignupError(firstname, lastname, email, password, varError, rptError);
			}
		return returnError;
	}
}

	
