package com.casestudy.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.casestudy.models.User;

public class UserDAO implements UserDAOI {
	
	private static final String persistenceUnitName = "Project_Pali_Draft";

	@Override
	public int addUser(User newUser) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		int result = 0;
		
		try {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
			em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.persist(newUser);
			em.getTransaction().commit();
			result = 1;
			System.out.println("Working");
			
		} catch(Exception e) {
//			em.getTransaction().rollback();
			System.out.println(e.getMessage());
			result = 0;
			System.out.println("Not Working");
		} finally {
			em.close();
			emf.close();
		}
		return result;
	}

	@Override
	public User getUserByid(int userId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		User foundUser = em.find(User.class, userId);
		em.close();
		emf.close();
		return foundUser;
	}
	
	@Override
	public User getUser(User inputUser) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT e FROM User e WHERE e.userId = :givenId AND e.username LIKE :givenName");
		query.setParameter("givenId", inputUser.getUserId());
		query.setParameter("givenName", "%" + inputUser.getUsername() + "%");
		
		User foundUser = (User) query.getSingleResult();
		
		em.close();
		emf.close();

		return foundUser;
	}


}
