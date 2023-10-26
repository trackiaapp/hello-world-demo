package trackia.app.example.helloworld.rt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import trackia.app.Trackia;
import trackia.app.example.helloworld.rt.service.HelloWorldService;
import trackia.app.example.helloworld.rt.to.HelloWorldRequest;
import trackia.app.example.helloworld.rt.to.HelloWorldResponse;
import trackia.app.module.index.Indexable;
import trackia.app.module.sla.Slable;
import trackia.app.module.sysinfo.Infoable;

@RestController
public class HelloWorldController {
	
	@Autowired HelloWorldService helloWorldService; 
	
	@Trackia( description = "Hello World TrackIA From RestTemplate", autoRequest = true, autoResponse = true, write = true)
	@Slable(3000)
	@Infoable
	@Indexable(onCreate = "{type:$(/request/0/value/type)}")
	@GetMapping("helloWorld")
    public ResponseEntity<HelloWorldResponse> helloWorld(@RequestBody HelloWorldRequest request) {
    	return new ResponseEntity<>(helloWorldService.helloWorld(request), HttpStatus.OK);
    }
	
	
	
}
