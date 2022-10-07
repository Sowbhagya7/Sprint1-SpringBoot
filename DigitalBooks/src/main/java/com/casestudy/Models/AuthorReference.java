package com.casestudy.Models;

public class AuthorReference {
private int aid;
private String username;
private String password;
private String emailid;
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
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
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
@Override
public String toString() {
	return "AuthorReference [aid=" + aid + ", username=" + username + ", password=" + password + ", emailid=" + emailid
			+ "]";
}

}

