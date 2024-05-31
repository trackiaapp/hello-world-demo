package trackia.app.example.helloworld.rt.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import trackia.app.Trackia;
import trackia.app.example.helloworld.rt.dao.HelloWorldDao;
import trackia.app.example.helloworld.rt.exception.BusinessException;
import trackia.app.example.helloworld.rt.to.HelloWorldRequest;
import trackia.app.example.helloworld.rt.to.HelloWorldResponse;


@Service
@AllArgsConstructor
public class HelloWorldService {
	private static final String HELLO = "Hello World";
	
	private HelloWorldDao dao;
	
	/**
	 * optional @Trackia.value: set step value
	 * optional @Trackia.description: set description value
	 */
	@Trackia(value = "SERVICE_HELLOWORLD", description = "Service logic")
	public HelloWorldResponse helloWorld(HelloWorldRequest request){
		HelloWorldResponse ret = new HelloWorldResponse();
		
		if("local".equals(request.getType())) {
			ret.setHello(HELLO + dao.local());
			
		}else if("service".equals(request.getType())) {
			ret.setHello(HELLO + dao.service());
			
		}else if("error".equals(request.getType())) {
			/* Business exceptions thrown are tracked*/
			throw new BusinessException(HttpStatus.EXPECTATION_FAILED, "300", "I can't say hello");
		}
		
		return ret;
	}
}
