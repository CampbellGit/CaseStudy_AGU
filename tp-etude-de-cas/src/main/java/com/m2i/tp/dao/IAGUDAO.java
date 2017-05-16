package com.m2i.tp.dao;

import java.util.List;

import com.m2i.tp.dao.entity.User;

public interface IAGUDAO {
	public void addOrUpdateUser(User u);
	public void removeUser(User u); 
	public User findUserById(int id);

	public List<User> findAllUsers();
}
