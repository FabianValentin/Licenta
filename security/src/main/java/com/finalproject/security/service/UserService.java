package com.finalproject.security.service;

import java.util.List;

import com.finalproject.model.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	User getUserByEmail(String email);

}
