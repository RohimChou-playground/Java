package com.rohim.springboot2.configs;

import java.util.Collection;
import java.util.function.Supplier;

import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

@Component
public class MyAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {

	@Override
	public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext context) {
		String username = authentication.get().getName();
		System.out.println(username);
		
		// return true even if not login
		Boolean isAuthenticated = authentication.get().isAuthenticated();
		System.out.println(isAuthenticated);
		
		Boolean isGranted = false;
		
		// get rolenames, e.g. ROLE_ADMIN
		Collection<? extends GrantedAuthority> authorities = authentication.get().getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			System.out.println(grantedAuthority.getAuthority());
			
			String roleName = grantedAuthority.getAuthority();
			
			if (roleName == "ROLE_ADMIN" || roleName == "ROLE_PRODUCTS_ADMIN" ) {
				isGranted = true;
			}
		}
		
		// get request method, e.g. GET
		String requestMethod = context.getRequest().getMethod();
	    System.out.print(requestMethod);
	    
	    // get request url e.g. /products
		String servletPath = context.getRequest().getServletPath();
		System.out.println(servletPath);
		
		return new AuthorizationDecision(isGranted);
	}

}
