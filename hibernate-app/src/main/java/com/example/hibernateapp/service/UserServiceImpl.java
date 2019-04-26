package com.example.hibernateapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hibernateapp.dao.UserDao;
import com.example.hibernateapp.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	public void createUser(User user) {
		userDao.addUser(user);
		
	}

	@Override
	public List<User> getUser() {
		return userDao.getUser();
	}

	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public User update(User user, int id) {
		return userDao.update(user, id);
	}

	@Override
	public void deleteUserById(int id) {
		userDao.delete(id);
	}

	@Override
	public User updatePartially(User user, int id) {
		userDao.updateAddress(user, id);
		return userDao.findById(id);
	}

}
