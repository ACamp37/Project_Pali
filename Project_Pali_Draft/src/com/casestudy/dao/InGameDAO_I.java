package com.casestudy.dao;

import com.casestudy.models.InGameWord;

public interface InGameDAO_I {
	public InGameWord getInGameWord(int wordId);
	public InGameWord getInGameWord(String wordName);
}