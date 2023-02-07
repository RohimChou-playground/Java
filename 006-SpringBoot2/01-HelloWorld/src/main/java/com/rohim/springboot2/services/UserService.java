package com.rohim.springboot2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohim.springboot2.models.User;
import com.rohim.springboot2.repositories.IUserMapper;

@Service
public class UserService {
	
	@Autowired
	IUserMapper userMapper;
	
	public List<User> findAll() {
		return this.userMapper.findAll();
	}
	
}
