package com.rohim.springboot2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rohim.springboot2.models.User;
import com.rohim.springboot2.models.UserPrincipal;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	public PasswordEncoder pwdEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.findUserbyUernameFromDb(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new UserPrincipal(user);
	}

	// pretending getting user from db, though not
	private User findUserbyUernameFromDb(String username) {
		if (username.equalsIgnoreCase("root")) {
			User u = new User();
			u.setId(1);
			u.setName("root");
			u.setPassword(this.pwdEncoder.encode("1234"));
			
			return u;
		} else if (username.equalsIgnoreCase("user")) {
			User u = new User();
			u.setId(1);
			u.setName("user");
			u.setPassword(this.pwdEncoder.encode("1234"));
			
			return u;
		}
		
		return null;
	}
}
