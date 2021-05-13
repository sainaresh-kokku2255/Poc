package com.user.job.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(name = "uname")
	private String userName;

	@ManyToOne
	@JoinColumn(name = "jobId")
	private Job job;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

//	public User(int userId, String userName) {
//		super();
//		this.userId = userId;
//		this.userName = userName;
//	}
//
//	@Override
//	public String toString() {
//		return "User [userId=" + userId + ", userName=" + userName + "]";
//	}
//	

}
