package com.m2i.tp.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.m2i.tp.dao.IAGUDAO;
import com.m2i.tp.dao.entity.User;

@Service("aguService")
public class AGUServiceImpl implements IAGUService {

	@Resource(name="aguDAO")
	IAGUDAO aguDAO;
	
	@Override
	@Transactional
	public void addOrUpdateUser(User u) {
		aguDAO.addOrUpdateUser(u);
		
	}

	@Override
	@Transactional
	public void removeUser(User u) {
		aguDAO.removeUser(u);
		
	}

	@Override
	@Transactional
	public User findUserById(int id) {
		return aguDAO.findUserById(id);
	}

	@Override
	@Transactional
	public List<User> findAllUsers() {
		return aguDAO.findAllUsers();
	}

}
