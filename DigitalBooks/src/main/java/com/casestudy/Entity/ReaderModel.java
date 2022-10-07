package com.casestudy.Entity;

public class ReaderModel {
		private int bookid;
private String emailid;
private String name;

public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}

public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "ReaderModel [bookid=" + bookid + ", emailid=" + emailid + ", name=" + name + "]";
}

}
