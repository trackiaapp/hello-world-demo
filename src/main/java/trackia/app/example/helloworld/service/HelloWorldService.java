package trackia.app.example.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import trackia.app.Trackia;
import trackia.app.annotations.R;
import trackia.app.example.helloworld.dao.HelloWorldDao;
import trackia.app.example.helloworld.exception.NegocioException;
import trackia.app.example.helloworld.to.HelloWorldRequest;
import trackia.app.example.helloworld.to.HelloWorldResponse;
import trackia.app.to.Journal;


@Service
public class HelloWorldService {
	private static final String HELLO = "Hello World";
	
	@Autowired HelloWorldDao dao;
	
	@Trackia(value = "SERVICE_HELLOWORLD", description = "Service logic")
	public HelloWorldResponse helloWorld(@R HelloWorldRequest request, Journal journal){
		HelloWorldResponse ret = new HelloWorldResponse(journal);
		
		if("local".equals(request.getType())) {
			ret.setHello(HELLO + dao.local(journal));
			
		}else if("service".equals(request.getType())) {
			ret.setHello(HELLO + dao.service(request, journal));
			
		}else if("error".equals(request.getType())) {
			throw new NegocioException(HttpStatus.EXPECTATION_FAILED, "300", "I can't say hello", journal.getTransactionId());
		}
		
		return ret;
	}
}
