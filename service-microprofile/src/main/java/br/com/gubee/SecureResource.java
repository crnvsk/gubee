package br.com.gubee;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;

import jakarta.inject.Inject;

@Path("/secure")
public class SecureResource {

    @Inject
    JsonWebToken jwt;

    @GET
    @RolesAllowed("user")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloJwt() {
        return "Olá, " + jwt.getName() + "! Seu JWT está válido.";
    }
}
