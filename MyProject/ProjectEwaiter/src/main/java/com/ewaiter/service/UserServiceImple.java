package com.ewaiter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewaiter.dao.UserRepository;
import com.ewaiter.dto.User;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	UserRepository urepo;

	@Override
	public int loginService(User user) {
		int user_type;
		user_type = urepo.login(user);
		return user_type;
	}

	@Override
	public boolean registerService(User user) {
		boolean flag = false;
		flag = urepo.register(user);
		return flag;
	}



	@Override
	public List<User> findAll() {
			List<User> li = urepo.findAll();
		return li;
	}

	@Override
	public void removeUser(int id) {
		urepo.removeUser(id);
	}

	@Override
	public void editUser(User user) {
		urepo.editUser(user);
	}

	@Override
	public User getUser(int id) {
		User user = urepo.getUser(id);
		return user;
	}


}
