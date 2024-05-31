package trackia.app.example.helloworld.rt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import lombok.AllArgsConstructor;
import trackia.app.configuration.TrackiaConfiguration;
import trackia.app.util.RestTemplateJournal;

@Configuration
@AllArgsConstructor
public class RestTemplateConfig {
	final TrackiaConfiguration config;

    @Bean
	public RestTemplateJournal restTemplate() {
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		
		RestTemplateJournal restTemplate = new RestTemplateJournal(config);
		restTemplate.setRequestFactory(requestFactory);
		
		return restTemplate;
	}
}
