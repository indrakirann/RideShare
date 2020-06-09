package view;

public class UserLogin {

	private String email;
	private String password;
	private Boolean usererror;
	private Boolean passerror;

	public UserLogin(String email, String password, Boolean usererror, Boolean passerror) {
		super();
		this.email = email;
		this.password = password;
		this.usererror = usererror;
		this.passerror = passerror;
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

	public Boolean getusererror() {
		return usererror;
	}
	public Boolean getpasserror() {
		return passerror;
	}
}