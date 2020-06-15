package view;

public class UpdatePasswordRequest {

	private String code;
	private String newpass;
	private String rptnewpass;
	

	public UpdatePasswordRequest(String code, String newpass, String rptnewpass) {
		super();
		this.code = code;
		this.newpass = newpass;
		this.rptnewpass = rptnewpass;
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