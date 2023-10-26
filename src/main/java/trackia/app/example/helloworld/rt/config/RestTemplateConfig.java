package trackia.app.example.helloworld.rt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import trackia.app.util.RestTemplateJournal;

@Configuration
public class RestTemplateConfig {


    @Bean
	public RestTemplateJournal restTemplate() {
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		
		RestTemplateJournal restTemplate = new RestTemplateJournal();
		restTemplate.setRequestFactory(requestFactory);
		
		return restTemplate;
	}
}
