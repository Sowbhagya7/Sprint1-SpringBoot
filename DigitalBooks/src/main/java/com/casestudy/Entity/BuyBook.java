package com.casestudy.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class BuyBook {
	
private long pid;
private String name;
private String emailid;
@Id
private Integer bookid;
private String date;

public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public long getPid() {
	return pid;
}
public void setPid(long pid) {
	this.pid = pid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public Integer getBookid() {
	return bookid;
}
public void setBookid(Integer bookid) {
	this.bookid = bookid;
}
@Override
public String toString() {
	return "BuyBook [pid=" + pid + ", name=" + name + ", emailid=" + emailid + ", bookid=" + bookid + ", date=" + date
			+ "]";
}
public BuyBook(long pid, String name, String emailid, Integer bookid, String date) {
	super();
	this.pid = pid;
	this.name = name;
	this.emailid = emailid;
	this.bookid = bookid;
	this.date = date;
}
public BuyBook() {
	super();
}

}
