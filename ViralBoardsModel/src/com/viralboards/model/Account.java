package com.viralboards.model;

public class Account {
	private String userid;
	private String username;
	private String email;
	private String password;
	
	public Account(String id, String username, String email, String password) {
		setUserId(id);
		setUserName(username);
		setEmail(email);
		setPassword(password);
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public void setUserId(String id) {
		this.userid = id;
	}
	public String getUserId() {
		return userid;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getUserName() {
		return username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
}
