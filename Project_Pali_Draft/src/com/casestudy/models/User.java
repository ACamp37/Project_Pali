package com.casestudy.models;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"userId"})})
public class User {
	
	@Id
	@Column
	@GeneratedValue(generator="InvSeqUser")
	@SequenceGenerator(name="InvSeqUser", sequenceName="INV_SEQ", allocationSize=1)
	private int userId;
	
	@Column(unique=true)
	@Basic
//	@NotNull
	private String username;
	
	@Column
	@Basic
//	@NotNull
	private String password; 
	
	@Column
	@Basic
//	@NotNull
	private String firstName; 
	
	@Column
	@Basic
//	@NotNull
	private String lastName; 

//	@OneToOne(targetEntity = InGameWord.class)
//	@JoinColumn(name = "recentScore", referencedColumnName = "recentScore")
//	private int recentScore;
//	
//	@OneToOne(targetEntity = InGameWord.class)
//	@JoinColumn(name = "highScore", referencedColumnName = "highScore")
//	private int highScore;

	public User() {
		super();
	}

	public User(int userId, String username, String password, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && userId == other.userId
				&& Objects.equals(username, other.username);
	}		
}