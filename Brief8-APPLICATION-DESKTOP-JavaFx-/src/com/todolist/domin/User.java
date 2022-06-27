package com.todolist.domin;

public class User {
	//integer
	private Integer user_id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	
	public User() {
		
	}
	public User(Integer user_id, String firstname, String lastname, String username, String password) {
		super();
		this.user_id = user_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", password=" + password + "]";
	}


}
