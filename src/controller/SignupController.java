package controller;

import model.User;

public class SignupController {

	public boolean createUser(String firstname, String lastname, String email, String password) {
		// check existing email
		User u = new User(firstname, lastname, email, password);

		// save u in db

		return false;
	}

}
