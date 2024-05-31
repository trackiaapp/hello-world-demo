package trackia.app.example.helloworld.rt.dao;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import trackia.app.Trackia;
import trackia.app.example.helloworld.rt.config.AppConfiguration;
import trackia.app.example.helloworld.rt.exception.BusinessException;
import trackia.app.util.RestTemplateJournal;



@Component
@AllArgsConstructor
public class HelloWorldDao {
	final RestTemplateJournal restTemplate;
	final AppConfiguration properties;
	
	
	@Trackia
	public String local() {
		return ", my name is @Trackia";
	}
	
	@Trackia
	public String service() {
		try {
	         return restTemplate.getForObject(properties.getMynameis(), String.class);
		}catch(Exception e) {
			/* Excepciones de negocio lanzadas son trackeadas */
			throw new BusinessException(
				HttpStatus.INTERNAL_SERVER_ERROR,
				"301", 
				"Cannot connect to service myNameIs", e);
		}
	}
}
