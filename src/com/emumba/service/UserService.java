package com.emumba.service;

import java.util.List;

import com.emumba.model.User;


public interface UserService {

	void insertUser(User user);

	User getUserById(int userId);

	User getUserByUsername(String username);
	
	User getUserByEmail(String email);

	List<User> getUsers();
	
	void deleteUser(User user);
	
	void updateUser(User user);
}
