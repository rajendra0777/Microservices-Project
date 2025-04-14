package in.infinity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class MyRestController {
	
	@GetMapping("/redis")
	@CircuitBreaker(fallbackMethod = "fetchFromDb", name = "fallback-logic")
	public String fetchFromRedis() {
		//int i = 10/0;
		System.out.println("Fetching data from Redis");
		return "Successfully fetched data from redis server";
	}

	@GetMapping("/db")
	public String fetchFromDb(Throwable t) {
		System.out.println("Radis is down, directly fetching from database");
		return "radis is down currently, Fetching form database()";
	}
}
