package com.m2i.tp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.m2i.tp.dao.entity.User;

@Repository("aguDAO")
public class AGUDAOImpl implements IAGUDAO {
	@Resource(name = "hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addOrUpdateUser(User u) {

		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(u);
		tx.commit();
		session.close();
	}

	public void removeUser(User u) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User tempU = (User) session.load(User.class, u.getId());
		if (null != tempU) {
			session.delete(tempU);
		}
		tx.commit();
		session.close();

	}

	public User findUserById(int id) {
		Session session = this.sessionFactory.openSession();
		User u = (User) session.load(User.class, id);
		return u;
	}

	public List<User> findAllUsers() {
		Session session = this.sessionFactory.openSession();
		List<User> userslist = session.createQuery("from User").list();
		return userslist;
	}

}
