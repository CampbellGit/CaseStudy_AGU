package com.m2i.tp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.m2i.tp.dao.entity.User;
import com.m2i.tp.dao.util.HibernateUtil;

@Repository("aguDAO")
public class AGUDAOImpl implements IAGUDAO {


	public void addOrUpdateUser(User u) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(u);
		tx.commit();
		session.close();
	}

	public void removeUser(User u) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		User tempU = (User) session.load(User.class, u.getId());
		if (null != tempU) {
			session.delete(tempU);
		}
		tx.commit();
		session.close();

	}

	public User findUserById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		User u = (User) session.load(User.class, id);
		return u;
	}

	public List<User> findAllUsers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<User> userslist = session.createQuery("from User").list();
		return userslist;
	}

}
