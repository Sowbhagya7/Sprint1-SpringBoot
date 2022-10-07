package com.casestudy.Models;

public class AuthorCreateResponse {
private Object bookcerated;
private String exception;
private String message;
public Object getBookcerated() {
	return bookcerated;
}
public void setBookcerated(Object bookcerated) {
	this.bookcerated = bookcerated;
}
public String getException() {
	return exception;
}
public void setException(String exception) {
	this.exception = exception;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
@Override
public String toString() {
	return "AuthorCreateResponse [bookcerated=" + bookcerated + ", exception=" + exception + ", message=" + message
			+ "]";
}
public AuthorCreateResponse(Object bookcerated, String exception, String message) {
	super();
	this.bookcerated = bookcerated;
	this.exception = exception;
	this.message = message;
}
public AuthorCreateResponse() {
	super();
}
}
