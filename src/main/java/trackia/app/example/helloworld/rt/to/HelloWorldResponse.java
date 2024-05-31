package trackia.app.example.helloworld.rt.to;

import lombok.Data;
import trackia.app.util.TrackiaTransactionTrace;

@Data
public class HelloWorldResponse {
	private String hello;
	private String transactionId;
	private String help;
	
	
	public HelloWorldResponse() {
		this.transactionId = TrackiaTransactionTrace.getTransactionId();
		this.help = "local, service, error";
	}
}
