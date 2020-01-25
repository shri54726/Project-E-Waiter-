package com.ewaiter.service;

import java.util.List;

import com.ewaiter.dto.User;

public interface UserService {
	
	public int loginService(User user);

	public boolean registerService(User user);
	
	public List<User> findAll();

	public void removeUser(int id);

	public void editUser(User user);

	public User getUser(int id);


}
