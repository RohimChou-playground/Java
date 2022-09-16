package com.rohim.springboot2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private WebOAuth2UserService oauthUserService;
    
    @Autowired
    private WebAuthenticationSuccessHandler authSuccessHandler;
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/mylogin**").permitAll()
				.anyRequest().authenticated()
			)
			.oauth2Login()
				.loginPage("/mylogin")
                .userInfoEndpoint()
                .userService(oauthUserService)
            .and()
		    .successHandler(authSuccessHandler);
		
		return http.build();
    }
}