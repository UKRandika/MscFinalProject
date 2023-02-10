package Exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
public class ExceptionHandler {
	
//	@E    (value = {PetDetailsNotFounder.class})
	public ResponseEntity<Object> handlePetDetailsNotFound(PetDetailsNotFound e){
		
		PetException petException = new PetException(
				e.getMessage(),
				e,
				HttpStatus.BAD_REQUEST,
				ZonedDateTime.now(ZoneId.of("Z"))
				);
		
		return new ResponseEntity<>(petException, HttpStatus.BAD_REQUEST);
	}
}
