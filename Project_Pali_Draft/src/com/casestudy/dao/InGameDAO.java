package com.casestudy.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.casestudy.models.InGameWord;

public class InGameDAO implements InGameDAO_I {
	
private static final String persistenceUnitName = "Project_Pali_Draft";
	
	//JPA Connection + CRUD for Home (R --> SELECT/Read/Get)

	@Override
	public InGameWord getInGameWord(int wordId) {
		// 1. Connect		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
			
		// 2. Execute transaction --> SELECT/Read/get
		InGameWord foundWord = em.find(InGameWord.class, wordId);

		// 3. Close connection
		em.close();	
		emf.close();

		return foundWord;
	}
	
	public InGameWord getInGameWord(String wordName) {
		// 1. Connect		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
			
		// 2. Execute transaction --> SELECT/Read/get
		InGameWord foundWord = em.find(InGameWord.class, wordName);

		// 3. Close connection
		em.close();	
		emf.close();

		return foundWord;
		
	}

}
