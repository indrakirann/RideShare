package view;

public class SignupError {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean printError;
	private boolean rptError;

	public SignupError(String firstName, String lastName, String email, String password, boolean printError, boolean rptError) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.printError = printError;
		this.rptError = rptError;
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
	
	public boolean getError() {
		return printError;
	}
	
	public boolean getrptError() {
		return rptError;
	}

}