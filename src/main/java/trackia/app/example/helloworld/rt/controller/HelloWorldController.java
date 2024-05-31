package trackia.app.example.helloworld.rt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import trackia.app.Trackia;
import trackia.app.example.helloworld.rt.service.HelloWorldService;
import trackia.app.example.helloworld.rt.to.HelloWorldRequest;
import trackia.app.example.helloworld.rt.to.HelloWorldResponse;
import trackia.app.module.index.Indexable;
import trackia.app.module.sla.Slable;
import trackia.app.module.sysinfo.Infoable;

@RestController
@AllArgsConstructor
public class HelloWorldController {
	final HelloWorldService helloWorldService; 
	/* 
	 * write: Tell trackia to send the result to the trackia dispatcher
	 * Optional description: set description
	 * Optional @Slable(3000): Activate the SLA module with a maximum time of 3000ms
	 * Optional @Infoable: Activate the Infoable module that records system information
	 * Optional @Indexable(...): Register 2 properties (type and cicle) in the customer IndexesModule. 
	 *                           The input to evaluate the expression "$(/request/0/value/type)" 
	 *                           is obtained from an early version of the track


	*/
	@Trackia(write = true, description = "Hello World TrackIA From RestTemplate")
	@Slable(3000)
	@Infoable
	@Indexable(onCreate = "{type:$(/request/0/value/type), cicle:$(/request/0/value/cicle)}")
	@GetMapping("helloWorld")
    public ResponseEntity<HelloWorldResponse> helloWorld(@RequestBody HelloWorldRequest request) {
    	return new ResponseEntity<>(helloWorldService.helloWorld(request), HttpStatus.OK);
    }
}
