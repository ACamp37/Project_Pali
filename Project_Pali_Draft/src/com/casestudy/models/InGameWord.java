package com.casestudy.models;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table (name = "gameWords", uniqueConstraints = {@UniqueConstraint(columnNames={"wordId"})})
public class InGameWord {
	
	@Id
	@Column
	@GeneratedValue(generator="InvSeqInGameWord")
	@SequenceGenerator(name="InvSeqInGameWord", sequenceName="INV_SEQ", allocationSize=100)
	private int wordId;
	
	@Column
	@Basic  
	private String wordName;
	
	@Column
	@Basic 
	private int recentScore;
	
	@Column
	@Basic 
	private int highScore;
	
	public InGameWord() {
		
	}
	
	public InGameWord(int wordId, String wordName, int recentScore, int highScore) {
		this.wordId = wordId;
		this.wordName = wordName;
		this.recentScore = recentScore;
		this.highScore = highScore;
	}
	
	public int getWordId() {
		return wordId;
	}
	
	public void setWordId(int wordId) {
		this.wordId = wordId;
	}
	
	public String getWordName() {
		return wordName;
	}
	
	//Overlaod to hold the random words
	public String getWordName(String randWords) {
		return wordName;
	}

	public void setWordName(String wordName) {
		this.wordName = wordName;
	}

	public int getRecentScore() {
		return recentScore;
	}

	public void setRecentScore(int recentScore) {
		this.recentScore = recentScore;
	}
	
	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

//	@Override
//	public String toString() {
//		return "InGameWord [wordId=" + wordId + ", wordName=" + wordName + ", recentScore=" + recentScore
//				+ ", highScore=" + highScore + "]";
//	} 
	
	@Override
	public String toString() {
		return String.format("%s", wordName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof InGameWord))
			return false;
		InGameWord other = (InGameWord) obj;
		return highScore == other.highScore && recentScore == other.recentScore && wordId == other.wordId
				&& Objects.equals(wordName, other.wordName);
	}
		
}
