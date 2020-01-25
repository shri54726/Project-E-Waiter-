package com.ewaiter.dao;

import java.util.List;

import com.ewaiter.dto.User;

public interface UserRepository {

	public int login(User user);

	public boolean register(User user);

	public List<User> findAll();

	public void removeUser(int id);

	public void editUser(User user);

	public User getUser(int id);
}
