package view;

public class UpdatePasswordRequest {

	private String email;
	private String code;
	private String newpass;
	private String rptnewpass;
	

	public UpdatePasswordRequest(String email, String code, String newpass, String rptnewpass) {
		super();
		this.email = email;
		this.code = code;
		this.newpass = newpass;
		this.rptnewpass = rptnewpass;
	}
	public String getEmail() {
		return email;
	}

	public String getCode() {
		return code;
	}

	public String getNewpass() {
		return newpass;
	}
	
	public String getRptnewpass() {
		return rptnewpass;
	}
}