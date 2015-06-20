package ro.dezertatie.common.security;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;

@Authenticated
public class AuthenticationFilter implements ContainerRequestFilter, ContainerResponseFilter {


    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        SecurityContext as = requestContext.getSecurityContext();

    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        SecurityContext as = requestContext.getSecurityContext();
    }
}
