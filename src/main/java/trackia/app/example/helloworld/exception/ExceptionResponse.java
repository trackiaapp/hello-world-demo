package trackia.app.example.helloworld.exception;

public class ExceptionResponse{
	private String code;
	private String message;
	private String journalId;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

	public String getJournalId() {
		return journalId;
	}

	public void setJournalId(String journalId) {
		this.journalId = journalId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExceptionResponse [code=");
		builder.append(code);
		builder.append(", message=");
		builder.append(message);
		builder.append(", subErrors=");
		builder.append(", journalId=");
		builder.append(journalId);
		builder.append("]");
		return builder.toString();
	}
}
