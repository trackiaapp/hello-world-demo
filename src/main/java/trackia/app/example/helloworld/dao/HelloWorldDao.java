package trackia.app.example.helloworld.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import trackia.app.Trackia;
import trackia.app.annotations.R;
import trackia.app.example.helloworld.exception.NegocioException;
import trackia.app.example.helloworld.to.HelloWorldRequest;
import trackia.app.to.Journal;
import trackia.app.util.RestTemplateJournal;
import trackia.app.util.Util;


@Repository
public class HelloWorldDao {
	@Value(value = "${app.mynameis}")
    private String url;
	
	@Autowired
	private RestTemplateJournal restTemplate;
	
	
	@Trackia(value = "DAO_LOCAL", description = "Greeting local")
	public String local(Journal journal) {
		return ", my name is @TrackIA";
	}
	
	@Trackia(value = "DAO_LOCAL", description = "Greeting from external rest service")
	public String service(@R HelloWorldRequest param, Journal journal) {
		try {
			final HttpHeaders header = Util.journalHeaderTemplate(journal);
	        final HttpEntity<HelloWorldRequest> request = new HttpEntity<>(null, header);
	        
	
	        return restTemplate.exchange(url, HttpMethod.GET, request, String.class, journal).getBody();
		}catch(Exception e) {
			throw new NegocioException(HttpStatus.INTERNAL_SERVER_ERROR, "301", "Cannot connect to service myNameIs", journal.getTransactionId(), e);
		}
	}
}
