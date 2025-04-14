package in.infinity.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.infinity.client.WelcomeFiegnClient;

@RestController
public class GreetRestController {
	
	@Autowired
	private  WelcomeFiegnClient fiegnClient;
	
	@GetMapping("/welcome")
	public String getGreetMsg() {
		return "Good morning"+fiegnClient.invokeWelcomeApi();
	}

}
