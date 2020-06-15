package controller;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import java.util.Random;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import database.Connection;
import view.ForgotPasswordError;
import view.SignupError;
import view.UpdatePasswordRequest;
import view.UpdatePasswordError;

public class UpdatePasswordController {
	public boolean codeerror;
	public boolean rpterror;
	public UpdatePasswordError UpdatePassword (String code, String newpass, String rptnewpass){
		UpdatePasswordRequest u = new UpdatePasswordRequest(code, newpass, rptnewpass);
		UpdatePasswordError upe;
		MongoCollection<Document> collection = Connection.saveCollection("ForgotPasswordData");
		//so far, this code sends emails only if the email is correct and has been registered. The code still needs to check if the
		//code we provide is correct, and needs to ensure the new password and repeat new password are equal.
		//it needs to output true for codeerror if codes don't match and true for rpterror if passwords don't match.
		//save these booleans in upe, and return upe(type UpdatePasswordError from the view class)
		//this object will be sent to front end
		
		return upe;
		
	}
}
