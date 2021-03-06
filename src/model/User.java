package model;

public class User {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String rptpassword;

	public User(String firstName, String lastName, String email, String password, String rptpassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.rptpassword = rptpassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getrptPassword() {
		return rptpassword;
	}

	public void rptPassword(String rptpassword) {
		this.rptpassword = rptpassword;
	} 

}