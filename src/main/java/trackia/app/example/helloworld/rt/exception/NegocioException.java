package trackia.app.example.helloworld.rt.exception;

import org.springframework.http.HttpStatus;

public class NegocioException extends RuntimeException{
    private static final long serialVersionUID = 4577853273176571331L;
    private static final String ERROR_DE_NEGOCIO = "Error de negocio.";
    
	private final String codeError;
	private final String mensajeError;
	private final HttpStatus httpStatus;
    private final String journalId;

	
    public NegocioException(HttpStatus httpStatus) {
    	super(ERROR_DE_NEGOCIO);
        this.codeError = "";
        this.mensajeError = "";
        this.httpStatus = httpStatus;
        this.journalId = null;
    }
    

    public NegocioException(HttpStatus httpStatus, String codeError, String mensajeError, String journalId, Exception e) {
    	super(e);
        this.codeError = codeError;
        this.mensajeError = mensajeError;
        this.httpStatus = httpStatus;
        this.journalId = journalId;
    }
    
    public NegocioException(HttpStatus httpStatus, String codeError, String mensajeError, String journalId) {
        super(ERROR_DE_NEGOCIO);
        this.codeError = codeError;
        this.mensajeError = mensajeError;
        this.httpStatus = httpStatus;
        this.journalId = journalId;
    }

	public String getCodeError() {
		return codeError;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	public String getJournalId() {
		return journalId;
	}
}
