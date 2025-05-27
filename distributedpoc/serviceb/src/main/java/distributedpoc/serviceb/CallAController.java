package distributedpoc.serviceb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CallAController {
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/call-a")
    public String callA() {
        String response = restTemplate.getForObject("http://localhost:8081/hello", String.class);
        return "Service B recebeu: " + response;
    }
}
