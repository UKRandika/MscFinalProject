package Exception;

public class PetDetailsNotFound extends RuntimeException{
	
	public PetDetailsNotFound(String message) {
		message = "Pet does not exixsts";
	}
	
	public PetDetailsNotFound(String message, Throwable cause) {
		super(message, cause);
	}
}
