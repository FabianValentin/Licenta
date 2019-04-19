package com.finalproject.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.domain.Response;
import com.finalproject.model.User;
import com.finalproject.security.service.UserService;

@RestController
public class PreLoginController {

	@Autowired private UserService userService;
	
	@PostMapping(value="/registration")
	public ResponseEntity<Response> registration(@RequestBody User user){
		User server = user;
		User dbbUser = userService.save(user);
		if( dbbUser != null) {
			return new ResponseEntity<Response>(new Response("User is saved successfully"), HttpStatus.OK);
		} 
		return null;
	}
}
