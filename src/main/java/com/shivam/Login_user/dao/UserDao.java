package com.shivam.Login_user.dao;

import com.shivam.Login_user.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserDao {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("first-hibernate-project");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public User insertNewUser(User user) {
		et.begin();
		em.persist(user);
		et.commit();
		return user;
	}
	
	public User getUserByPassword(String userName) {
		return em.find(User.class,userName);
	}

}
