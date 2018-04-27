package com.hr.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.hr.pojo.User;

import org.hibernate.HibernateException;
import org.hibernate.Query;

public class UserDao extends DAO {

	
	public User get(String userEmail, String password) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from User where userEmail = :useremail and password = :password");
			q.setString("useremail", userEmail);
			q.setString("password", password);
			System.out.print(userEmail);
			System.out.print(password);
			User user = (User) q.uniqueResult();
			System.out.print(user);
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get user " + userEmail, e);
		}
	}
	
	public User getUser(String userEmail) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from User where userEmail = :useremail");
			q.setString("useremail", userEmail);			
			System.out.print(userEmail);			
			User user = (User) q.uniqueResult();
			System.out.print(user);
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get user " + userEmail, e);
		}
	}
	
	
}
