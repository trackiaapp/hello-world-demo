package trackia.app.example.helloworld.rt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import trackia.app.Trackia;
import trackia.app.annotations.R;
import trackia.app.example.helloworld.rt.exception.NegocioException;
import trackia.app.example.helloworld.rt.to.HelloWorldRequest;
import trackia.app.util.RestTemplateJournal;
import trackia.app.util.TrackiaTransactionTrace;


@Component
public class HelloWorldDao {
	@Value(value = "${app.mynameis}")
    private String url;
	
	@Autowired
	private RestTemplateJournal restTemplate;
	
	
	@Trackia(value = "DAO_LOCAL", description = "Greeting local")
	public String local() {
		return ", my name is @TrackIA";
	}
	
	@Trackia(value = "DAO_LOCAL", description = "Greeting from external rest service")
	public String service() {
		try {
	         return restTemplate.getForObject(url, String.class);
		}catch(Exception e) {
			throw new NegocioException(HttpStatus.INTERNAL_SERVER_ERROR, "301", "Cannot connect to service myNameIs", TrackiaTransactionTrace.getTransactionId(), e);
		}
	}
}
