package controller;

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
	public UpdatePasswordError UpdatePassword (String email, String code, String newpass, String rptnewpass){
		UpdatePasswordRequest u = new UpdatePasswordRequest(email, code, newpass, rptnewpass);
		MongoCollection<Document> collection = Connection.saveCollection("ForgotPasswordData");
		if(!(Connection.attributeExists(collection, "Email", u.getEmail()))) {
			
		}
		if(!(code.equals(u.getCode()))) {
			codeerror = false;
			rpterror = true;
			returnError = new SignupError(firstname, lastname, email, password, varError, rptError);	
		}
		
		
		
		if (!(Connection.attributeExists(collection, "Email", u.getEmail()))) {
			emailerror = true;
			ForgotPasswordError fpe = new ForgotPasswordError(email, emailerror);
			return fpe;
		}
		Random rand = new Random();
		String code="";
		for(int i=0; i<8; i++){
			int x=rand.nextInt(26)+97;
			code+=(char)x;
		}
		String subject = "Reset Password for RideShare Account";
		String message = "Here is the code you need to enter: \n"+code;
		EmailSender.sendEmail(email, message, subject);
		Document myDoc = new Document("EmailID", email)
				.append("Code", code);
		collection.insertOne(myDoc);
		emailerror = false;
		ForgotPasswordError fpe = new ForgotPasswordError(email, emailerror);
		return fpe;
	}
}
