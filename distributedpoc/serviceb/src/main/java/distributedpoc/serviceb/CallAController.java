package distributedpoc.serviceb;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

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
    @RateLimiter(name = "callA", fallbackMethod = "rateLimitFallback")
    @TimeLimiter(name = "callA", fallbackMethod = "timeoutFallback")
    public CompletableFuture<String> callA(@RequestParam(required = false, defaultValue = "false") boolean fail) {
        return CompletableFuture.supplyAsync(() -> {
            if (fail) {
                throw new RuntimeException("Falha simulada!");
            }
            String response = restTemplate.getForObject("http://localhost:8081/hello", String.class);
            return "Service B recebeu: " + response;
        });
    }

    public CompletableFuture<String> fallbackCallA(Throwable t) {
        return CompletableFuture.completedFuture("Service B: Service A está indisponível (fallback)");
    }

    public CompletableFuture<String> rateLimitFallback(boolean fail, Throwable t) {
        return CompletableFuture.completedFuture("Service B: Limite de requisições atingido (Rate Limit)");
    }

    public CompletableFuture<String> timeoutFallback(boolean fail, Throwable t) {
        return CompletableFuture.completedFuture("Service B: Timeout atingido (TimeLimiter)");
    }
}