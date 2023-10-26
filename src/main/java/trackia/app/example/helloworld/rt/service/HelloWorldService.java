package trackia.app.example.helloworld.rt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import trackia.app.Trackia;
import trackia.app.example.helloworld.rt.dao.HelloWorldDao;
import trackia.app.example.helloworld.rt.exception.NegocioException;
import trackia.app.example.helloworld.rt.to.HelloWorldRequest;
import trackia.app.example.helloworld.rt.to.HelloWorldResponse;
import trackia.app.util.TrackiaTransactionTrace;


@Service
public class HelloWorldService {
	private static final String HELLO = "Hello World";
	
	@Autowired private HelloWorldDao dao;
	
	@Trackia(value = "SERVICE_HELLOWORLD", description = "Service logic")
	public HelloWorldResponse helloWorld(HelloWorldRequest request){
		HelloWorldResponse ret = new HelloWorldResponse();
		
		if("local".equals(request.getType())) {
			ret.setHello(HELLO + dao.local());
			
		}else if("service".equals(request.getType())) {
			ret.setHello(HELLO + dao.service());
			
		}else if("error".equals(request.getType())) {
			throw new NegocioException(HttpStatus.EXPECTATION_FAILED, "300", "I can't say hello", TrackiaTransactionTrace.getTransactionId());
			
		}
		
		return ret;
	}
}
