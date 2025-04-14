package in.infinity.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	@Autowired
	private Environment env;

	
	@GetMapping("/welcome")
	private String welcomeMsg() {
		String port = env.getProperty("server.port");
		return "Welcome to Welcome API enabled with Load Balancer: " + port;
	}
}
