package view;

public class UserLogin {

	private String email;
	private String password;
	private Boolean loginerror;

	public UserLogin(String email, String password, Boolean loginerror) {
		super();
		this.email = email;
		this.password = password;
		this.loginerror = loginerror;
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

	public Boolean getloginerror() {
		return loginerror;
	}
}