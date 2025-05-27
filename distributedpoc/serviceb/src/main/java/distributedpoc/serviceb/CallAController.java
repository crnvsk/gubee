package distributedpoc.serviceb;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Configuration
class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

@RestController
public class CallAController {
    private final RestTemplate restTemplate;

    public CallAController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/call-a")
    @CircuitBreaker(name = "serviceA", fallbackMethod = "fallbackCallA")
    @Retry(name = "serviceA")
    public String callA() {
        String response = restTemplate.getForObject("http://localhost:8081/hello", String.class);
        return "Service B recebeu: " + response;
    }

    public String fallbackCallA(Throwable t) {
        return "Service B: Service A está indisponível (fallback)";
    }
}