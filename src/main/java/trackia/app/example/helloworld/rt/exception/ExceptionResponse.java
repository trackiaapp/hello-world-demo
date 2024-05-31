package trackia.app.example.helloworld.rt.exception;

import lombok.Data;

@Data
public class ExceptionResponse{
	private String code;
	private String message;
	private String transactionId;
}
