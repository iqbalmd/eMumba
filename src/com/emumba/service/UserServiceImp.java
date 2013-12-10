package com.emumba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emumba.dao.UserDAO;
import com.emumba.model.User;


@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public void insertUser(User user) {
		userDAO.insertUser(user);
	}

	@Override
	@Transactional
	public User getUserById(int userId) {
		return userDAO.getUserById(userId);
	}

	@Override
	@Transactional
	public User getUserByUsername(String username) {
		return userDAO.getUserByUsername(username);
	}
	
	@Override
	@Transactional
	public User getUserByEmail(String email) {
		return userDAO.getUserByEmail(email);
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}
	
	@Override
	@Transactional
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

}