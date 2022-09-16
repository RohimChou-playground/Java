package com.rohim.springboot2.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

@Service
public class WebAuthenticationSuccessHandler implements AuthenticationSuccessHandler  {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		WebOAuth2User oauthUser = (WebOAuth2User)authentication.getPrincipal();
		
		System.out.println("Pretend that we register this user: " + oauthUser.getName());
		
		// response.sendRedirect("/list");
	}
}
