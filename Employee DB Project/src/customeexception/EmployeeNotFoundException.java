package customeexception;

public class EmployeeNotFoundException extends Exception{
	private String message;

	public EmployeeNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
