package com.casestudy.dao;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.casestudy.models.Home;
 
public class HomeDAO implements HomeDAO_I {
	
	private static final String persistenceUnitName = "Project_Pali_Draft";
	
	//JPA Connection + CRUD for Home (R --> SELECT/Read/Get)	
	
	@Override
	public Home getHomeVerseInt(int verseId) {
		// 1. Connect		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
	
		// 2. Execute transaction --> SELECT/Read/get
		Home foundVerse = em.find(Home.class, verseId);

		// 3. Close connection
		em.close();
		emf.close();

		return foundVerse;
	}
	
	@Override
	public HashMap<Integer, Home> getAllVerses() {
		HashMap<Integer, Home> homeHashMap = new HashMap<Integer, Home>(); 
		
		//1 connect
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		
		//2 execute
				// do we need Transaction for this operation??? NO
			Query query = em.createQuery("SELECT e FROM Home e"); // JPA JPQL
			List<Home> homeList = query.getResultList();
		
		//3 disconnect
		em.close();
		emf.close();
		
		if (!homeList.isEmpty()) {
			for(Home h:homeList) {
				homeHashMap.put(h.getVerseId(), h);
			}
		}
		
		return homeHashMap;

	}

}
