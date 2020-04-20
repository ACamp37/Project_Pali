package com.casestudy.dao;

import java.util.HashMap;

import com.casestudy.models.Home;

public interface HomeDAO_I {
	
	//public int getHomeVerse(HomeVerse hv);
	
//	THIS IS WHAT I NEED TO RETURN, NOT INT 
	public Home getHomeVerseInt(int verseId);
	public HashMap<Integer, Home> getAllVerses();
}
