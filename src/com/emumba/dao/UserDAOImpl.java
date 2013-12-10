package com.emumba.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emumba.model.User;

@Service
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User getUserById(Integer userId) {
		return (User) sessionFactory.getCurrentSession().get(User.class, userId);
	}

	@Override
	public User getUserByUsername(String name) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User where name = :name");
		query.setParameter("name", name);
		return (User) query.list().get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		return criteria.list();
	}

	@Override
	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}
	
	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public User getUserByEmail(String email) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User where email = :email");
		query.setParameter("email", email);
		List list = query.list(); 
		if( list.size() > 0)
			return (User) list.get(0);
		else
			return null;
	}

}
