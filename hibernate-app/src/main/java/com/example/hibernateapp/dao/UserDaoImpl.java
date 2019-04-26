package com.example.hibernateapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.hibernateapp.entity.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		
	}

	@Override
	public List<User> getUser() {
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<User> lst = session.createCriteria(User.class).list();
		return lst;
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = findById(id);
		session.delete(user);
		
	}

	@Override
	public User findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User)session.get(User.class, id);
		return user;
	}

	@Override
	public User update(User u, int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User)session.get(User.class, id);
		user.setName(u.getName());
		user.setAddress(u.getAddress());
		session.update(user);
		return user;
	}

	@Override
	public User updateAddress(User u, int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User)session.get(User.class, id);
		user.setAddress(u.getAddress());
		return user;
	}

}
