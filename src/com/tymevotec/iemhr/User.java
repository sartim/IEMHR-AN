package com.tymevotec.iemhr;

public class User {
	
	String username, password, email, name;
	
	public User(String name, String email, String username, String password) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.email = "";
		this.name ="";
	}

}
