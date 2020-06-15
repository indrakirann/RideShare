package view;

public class ForgotPasswordError {

	private String email;
	private boolean emailError;

	public ForgotPasswordError(String email, boolean emailError) {
		super();
		this.email = email;
		this.emailError = emailError;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean getemailError() {
		return emailError;
	}

}