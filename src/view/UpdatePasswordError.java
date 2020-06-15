package view;

public class UpdatePasswordError {

	private String code;
	private boolean codeError;
	private boolean rptError;
	

	public UpdatePasswordError(String code, boolean codeError, boolean rptError) {
		super();
		this.code = code;
		this.codeError = codeError;
		this.rptError = rptError;
	}

	public String getCode() {
		return code;
	}
	
	public boolean getemailError() {
		return codeError;
	}
	
	public boolean getrptError() {
		return rptError;
	}


}