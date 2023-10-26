package trackia.app.example.helloworld.rt.to;

import trackia.app.util.TrackiaTransactionTrace;

public class HelloWorldResponse {
	private String hello;
	private String journalId;
	private String help;
	
	
	public HelloWorldResponse() {
		this.journalId = TrackiaTransactionTrace.getTransactionId();
		this.help = "local, service, error";
	}
	
	
	public HelloWorldResponse(String hello, String journalId) {
		this.hello = hello;
		this.journalId = journalId;
		this.help = "local, service, error";
	}
	
	public String getHello() {
		return hello;
	}
	
	public void setHello(String hello) {
		this.hello = hello;
	}
	
	public String getJournalId() {
		return journalId;
	}
	
	public void setJournalId(String journalId) {
		this.journalId = journalId;
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}
	
	
}
