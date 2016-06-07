package com.shitot.json;

public class User {

    private int userId;

    private String name;
    private String password;

    public User() {
	super();
    }

    public User(String name, String password) {
	super();
	this.name = name;
	this.password = password;
    }

    public int getUserId() {
	return userId;
    }

    public void setUserId(int userId) {
	this.userId = userId;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
