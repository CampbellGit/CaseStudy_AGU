package com.m2i.tp;

import org.junit.Test;

import com.m2i.tp.dao.AGUDAOImpl;
import com.m2i.tp.dao.entity.User;

public class AGUDAOImplTest {
	
	static AGUDAOImpl daoimpl;
	

	@Test
	public void testAddOrUpdateUser() {
		daoimpl = new AGUDAOImpl();
		User util = new User();
		util.setPassword("pass");
		util.setUsername("truc");
		daoimpl.addOrUpdateUser(util);
	}

}
