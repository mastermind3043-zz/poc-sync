package com.noobsoft.morpheus.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.noobsoft.morpheus.domain.User;
import com.noobsoft.morpheus.exception.TrinityException;
import com.noobsoft.morpheus.exception.UserNotFoundException;
import com.noobsoft.morpheus.util.HibernateFactory;

public class UserDAOImpl implements UserDAO {

	private HibernateFactory hibernateFactory;
	
	public UserDAOImpl(HibernateFactory hibernateFactory){
		this.hibernateFactory = hibernateFactory;
	}
	

	public HibernateFactory getHibernateFactory() {
		return hibernateFactory;
	}

	public void setHibernateFactory(HibernateFactory hibernateFactory) {
		this.hibernateFactory = hibernateFactory;
	}


	public User find(int userID) throws UserNotFoundException, TrinityException {
		Session session = hibernateFactory.buildIfNeeded().freshSession();
		session.beginTransaction();
		User user = (User) session.get(User.class, userID);
		session.flush();
		return user;

	}


	@SuppressWarnings("unchecked")
	public List<User> findAll() throws TrinityException {
		Session session = hibernateFactory.buildIfNeeded().freshSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		List<User> users =  (List<User>)criteria.list();
		session.flush();
		return users;
	}


	public void add(User user) throws TrinityException {
		// TODO Auto-generated method stub
		
	}


	public void batchAdd(List<User> users) throws TrinityException {
		// TODO Auto-generated method stub
		
	}


	public void update(User user) throws UserNotFoundException,
			TrinityException {
		// TODO Auto-generated method stub
		
	}


	public void batchUpdate(List<User> users) throws UserNotFoundException,
			TrinityException {
		// TODO Auto-generated method stub
		
	}


	public boolean remove(User user) throws UserNotFoundException,
			TrinityException {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean batchRemove(List<User> user) throws UserNotFoundException,
			TrinityException {
		// TODO Auto-generated method stub
		return false;
	}

}
