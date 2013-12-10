package com.emumba.dao;

import java.util.List;

import com.emumba.model.User;

public interface UserDAO {

	void insertUser(User user);

	User getUserById(Integer userId);

	User getUserByEmail(String email);
	
	User getUserByUsername(String username);

	List<User> getUsers();
	
	void deleteUser(User user);
	
	void updateUser(User user);
}
