package trackia.app.example.helloworld.rt.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import trackia.app.util.TrackiaTransactionTrace;

@Getter
public class BusinessException extends RuntimeException{
	private final String codeError;
	private final String mensajeError;
	private final HttpStatus httpStatus;
    private final String transactionId;


    public BusinessException(HttpStatus httpStatus, String codeError, String mensajeError, Exception e) {
    	super(e);
        this.codeError = codeError;
        this.mensajeError = mensajeError;
        this.httpStatus = httpStatus;
        this.transactionId = TrackiaTransactionTrace.getTransactionId();
    }

    public BusinessException(HttpStatus httpStatus, String codeError, String mensajeError) {
        super(mensajeError);
        this.codeError = codeError;
        this.mensajeError = mensajeError;
        this.httpStatus = httpStatus;
        this.transactionId = TrackiaTransactionTrace.getTransactionId();
    }
}
