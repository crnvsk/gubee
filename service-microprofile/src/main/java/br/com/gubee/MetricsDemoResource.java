package br.com.gubee;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/metrics-demo")
public class MetricsDemoResource {

    @GET
    @Counted(name = "countHello", description = "Contador de chamadas ao hello")
    @Timed(name = "timedHello", description = "Tempo de execução do hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloMetrics() {
        return "Hello com métricas!";
    }
}