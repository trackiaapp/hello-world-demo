package trackia.app.example.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import trackia.app.Trackia;
import trackia.app.annotations.R;
import trackia.app.example.helloworld.service.HelloWorldService;
import trackia.app.example.helloworld.to.HelloWorldRequest;
import trackia.app.example.helloworld.to.HelloWorldResponse;
import trackia.app.module.index.Indexable;
import trackia.app.module.sla.Slable;
import trackia.app.module.sysinfo.Infoable;
import trackia.app.to.Journal;

@RestController
public class HelloWorldController {
	
	@Autowired HelloWorldService helloWorldService; 
	
	@Trackia(
	          	value = "CONTROLLER_HELLOWORLD",
	      description = "Hello World TrackIA example",
	        collector = true, 
	  autoTransaction = true,
	  		  	write = true
	)
	@Slable(3000)
	@Infoable
	@Indexable(onCreate = "{type:$(/request/0/value/type)}")
	@GetMapping("helloWorld")
    public ResponseEntity<HelloWorldResponse> helloWorld(@R @RequestBody HelloWorldRequest request, Journal journal) {
    	return new ResponseEntity<>(helloWorldService.helloWorld(request, journal), HttpStatus.OK);
    }
	
	
	
}
