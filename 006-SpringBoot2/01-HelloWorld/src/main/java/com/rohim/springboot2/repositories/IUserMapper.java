package com.rohim.springboot2.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rohim.springboot2.models.User;

@Repository
public interface IUserMapper {
	public List<User> findAll();
}
