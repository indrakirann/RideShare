package controller;

import model.User;

public class SignupController {

	public User createUser(String firstname, String lastname, String email, String password) {
		// check existing email, ensure no same users are being added
		//create user in db
		User u = new User(firstname, lastname, email.toLowerCase(), password);

		// save u in db

		return u;
	}

}
