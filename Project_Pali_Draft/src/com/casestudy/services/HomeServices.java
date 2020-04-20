//NO NEED FOR SERVLET. SPRING IS TAKING CONTROL OF COMMUNICATION BETWEEN JSP AND JAVA CLASSES. 
//JUST IMPLEMENT SCRIPTLETS FOR GETTING THE LOGIC DEFINED FROM THIS CLASS. 
package com.casestudy.services;

import com.casestudy.dao.HomeDAO;
import com.casestudy.models.Home;

import java.util.HashMap;
import java.util.Map;

public class HomeServices {
	
	/*	public static void main(String[] args) {
//		testGetHomeVerseInt(); //SELECT/Read/Get
		testGetAllVerses(); //SELECT * from bibleVerses
	} */

/*	public void testGetHomeVerseInt() {
		int getVerse = 4;
		Home foundVerse = getHomeVerseServicesInt(getVerse);
		if(foundVerse==null) {
			System.out.println("ERROR: Verse does not exist");
		} else {
			System.out.println("Verse Found = " + foundVerse.toString());
		}
	} */
	
	public Home getHomeVerseServicesInt(int getVerse) {
		HomeDAO homeDao = new HomeDAO();
		Home foundVerse = homeDao.getHomeVerseInt(getVerse);
		return foundVerse;
	}
		  
	public void testGetAllVerses() {
		HashMap<Integer, Home> homeHashMap = getAllVerseServices();
		for (Map.Entry<Integer, Home> h :homeHashMap.entrySet()) {
			System.out.println(h.toString());
		}
		
	}

	public HashMap<Integer, Home> getAllVerseServices() {
		HashMap<Integer, Home> homeHashMap = new HomeDAO().getAllVerses();
		return homeHashMap;
	}
	
}
