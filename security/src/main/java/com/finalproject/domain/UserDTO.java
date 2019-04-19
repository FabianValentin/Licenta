package com.finalproject.domain;

import java.io.Serializable;

import com.finalproject.model.User;

public class UserDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7102637753495148549L;
	private User user;
	private String token;
	private Long id;
	
	public UserDTO(User user, Long id, String token) {
		super();
		this.user = user;
		this.setId(id);
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
