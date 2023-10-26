package trackia.app.example.helloworld.rt.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServicioExceptionHandler {
	/**
	 * Log de la clase.
	 */
	private static Logger log = LogManager.getLogger(ServicioExceptionHandler.class);

	@ExceptionHandler(value = NegocioException.class)
	public ResponseEntity<ExceptionResponse> negocioException(NegocioException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setCode(ex.getCodeError());
		exceptionResponse.setMessage(ex.getMensajeError());
		exceptionResponse.setJournalId(ex.getJournalId());
		log.error("[NegocioException] Error procesando solicitud.", ex);
		return new ResponseEntity<>(exceptionResponse, ex.getHttpStatus());
	}
	

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response.setMessage(ex.getMessage());
        log.error("[Exception] Error procesando solicitud", ex);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
