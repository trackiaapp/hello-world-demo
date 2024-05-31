package trackia.app.example.helloworld.rt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServiceExceptionHandler {
	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<ExceptionResponse> negocioException(BusinessException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setCode(ex.getCodeError());
		exceptionResponse.setMessage(ex.getMensajeError());
		exceptionResponse.setTransactionId(ex.getTransactionId());

		return new ResponseEntity<>(exceptionResponse, ex.getHttpStatus());
	}
	

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response.setMessage(ex.getMessage());
		
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
