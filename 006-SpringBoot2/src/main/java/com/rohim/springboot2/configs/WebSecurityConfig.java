package com.rohim.springboot2.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.rohim.springboot2.services.UserDetailsServiceImp;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeHttpRequests((requests) -> requests
 				.antMatchers("/products")
 				.hasAnyRole("ADMIN", "PRODUCTS_ADMIN")
 				// could also use .hasAnyAuthority("ROLE_ADMIN", "ROLE_PRODUCTS_ADMIN")
 				// just prepend ROLE_
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/auth/login")
				.defaultSuccessUrl("/")
				.permitAll()
			)
			.logout((logout) -> logout.logoutUrl("/auth/logout").permitAll());
	
		return http.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager authManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsServiceImp userDetailsService) 
      throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
          .userDetailsService(userDetailsService)
          .passwordEncoder(bCryptPasswordEncoder)
          .and()
          .build();
    }
}
