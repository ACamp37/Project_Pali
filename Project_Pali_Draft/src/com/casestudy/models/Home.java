package com.casestudy.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity 
@Table (name = "bibleVerses", uniqueConstraints = {@UniqueConstraint(columnNames={"verseId"})})
public class Home {
	
	@Id
	@Column
	@GeneratedValue(generator="InvSeqHome")
	@SequenceGenerator(name="InvSeqHome", sequenceName="INV_SEQ", allocationSize=1)
	private int verseId;
	
	@Column
	@Basic
	private String verseChapter;
	
	@Column
	@Basic
	private String verseText;
	
	public Home() {
		
	}
	
	public Home(int verseId, String verseChapter, String verseText) {
		this.verseId = verseId;
		this.verseChapter = verseChapter;
		this.verseText = verseText;
	}
	
	public int getVerseId() {
		return verseId;
	}

	public void setVerseId(int verseId) {
		this.verseId = verseId;
	}

	public String getVerseChapter() {
		return verseChapter;
	}

	public void setVerseChapter(String verseChapter) {
		this.verseChapter = verseChapter;
	}
	
	public String getVerseText() {
		return verseText;
	}

	public void setVerseText(String verseText) {
		this.verseText = verseText;
	}
	
	public String toString() {
		return String.format("%s\n%s" , verseChapter, verseText);
	} 
	
/*	public String toString() {
		return "Home [Id=" + verseId + ", Chapter = " + verseChapter + " , Text = " + verseText + "]";
	} */
}
