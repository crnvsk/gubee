package br.com.gubee;

import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.faulttolerance.Fallback;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/unstable")
public class UnstableResource {

    @GET
    @Retry(maxRetries = 3)
    @Timeout(1000)
    @Fallback(fallbackMethod = "fallbackHello")
    @Produces(MediaType.TEXT_PLAIN)
    public String unstableHello() {
        if (Math.random() < 0.7)
            throw new RuntimeException("Falha simulada!");
        return "Sucesso!";
    }

    public String fallbackHello() {
        return "Fallback: serviço indisponível.";
    }
}
