package controller;

import org.bson.conversions.Bson;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import database.Connection;
import model.User;

public class ProfileController {

	public static void profile(String fname, String lname, String email_original, String email_new, String instagram, String twitter, String facebook, String description){ 
		MongoDatabase database = Connection.getConnection().getDatabase("RideShare");
		MongoCollection test = database.getCollection("test");
		Document found = (Document) test.find(new Document("EmailID", email_original)).first();//understand this part
		Bson updatedvalue = new Document("EmailID", email_new)
				.append("First Name", fname)
				.append("Last Name", lname);
		Bson updateoperation = new Document("$set", updatedvalue);
		test.updateOne(found, updateoperation);
		MongoCollection Profile = database.getCollection("Profile Information");
		Document updateProfile = (Document) Profile.find(new Document("EmailID", email_original)).first();
		Bson updatedvalue_pro = new Document("EmailID", email_new)
				.append("First Name", fname)
				.append("Last Name", lname)
				.append("Instagram", instagram)
				.append("Twitter", twitter)
				.append("Facebook", facebook)
				.append("Self-Description", description);
		Bson updateoperation_pro = new Document("$set", updatedvalue_pro);
		Profile.updateOne(updateProfile, updateoperation_pro);
	}

}
