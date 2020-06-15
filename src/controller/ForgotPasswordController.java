package controller;

import java.util.Random;
import database.Connection;

import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import controller.EmailSender;
import view.ForgotPasswordRequest;
import view.ForgotPasswordError;

public class ForgotPasswordController {
	public boolean emailerror;
	public ForgotPasswordError ForgotPassword(String email){
		ForgotPasswordRequest f = new ForgotPasswordRequest(email);
		MongoCollection<Document> collection = Connection.saveCollection("MahekData");
		MongoCollection<Document> collection1 = Connection.saveCollection("ForgotPassword");
		if (!(Connection.attributeExists(collection, "Email", f.getEmail()))) {
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
		collection1.insertOne(myDoc);
		emailerror = false;
		ForgotPasswordError fpe = new ForgotPasswordError(email, emailerror);
		return fpe;
	}
		

}
