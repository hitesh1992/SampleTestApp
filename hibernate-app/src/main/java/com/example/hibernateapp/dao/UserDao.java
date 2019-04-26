package com.example.hibernateapp.dao;

import java.util.List;

import com.example.hibernateapp.entity.User;

public interface UserDao {
	
	public void addUser(User user);
	
	public List<User> getUser();
	
	public void delete(int id);
	
	public User findById(int id);
	
	public User update(User user, int id);
	
	public User updateAddress(User user, int id);

}
