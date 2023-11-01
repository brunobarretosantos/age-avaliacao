package com.avaliacao.ws;

import com.avaliacao.facade.UsuarioFacade;
import com.avaliacao.model.Usuario;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.enterprise.context.Dependent;
import javax.interceptor.Interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotAuthorizedException;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Logger;

@Interceptor
@Dependent
public class BasicAuthInterceptor implements ContainerRequestFilter {

	private static final Logger logger = Logger.getLogger(BasicAuthInterceptor.class.getName());
	
	private UsuarioFacade usuarioFacade;
	
    public BasicAuthInterceptor() {
    	logger.info("BasicAuthInterceptor.Constructor");
    	usuarioFacade = new UsuarioFacade();
    }

    @Context
    private HttpServletRequest httpRequest;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
    	logger.info("BasicAuthInterceptor.filter");
        String authHeader = httpRequest.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Basic ")) {
            String[] credentials = getCredentials(authHeader);

            if (credentials != null) {
                String login = credentials[0];
                String password = credentials[1];

                Usuario usuario;
				try {
					usuario = usuarioFacade.autenticar(login, password);
					
					if (usuario != null) {
	                    return;
	                }
				} catch (Exception e) {
					e.printStackTrace();
				}

               
            }
        }

        throw new NotAuthorizedException("Basic");
    }

    private String[] getCredentials(String authHeader) {
        String encodedCredentials = authHeader.substring("Basic ".length()).trim();
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decodedBytes);
        return credentials.split(":", 2);
    }
}