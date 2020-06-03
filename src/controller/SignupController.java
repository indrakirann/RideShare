package controller;

import model.User;

public class SignupController {

	public boolean createUser(String firstname, String lastname, String email, String password) {
		// check existing email, ensure no same users are being added
		//create user in db
		User u = new User(firstname, lastname, email, password);

		// save u in db

		return false;
	}

}
