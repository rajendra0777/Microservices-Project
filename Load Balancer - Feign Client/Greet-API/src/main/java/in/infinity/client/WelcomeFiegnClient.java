package in.infinity.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value ="Welcome-API")
public interface WelcomeFiegnClient {
	
	@GetMapping("/welcome")
	public String invokeWelcomeApi();

}
