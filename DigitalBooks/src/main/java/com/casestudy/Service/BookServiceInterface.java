package com.casestudy.Service;

import java.sql.SQLException;
import java.util.List;

import com.casestudy.Entity.DigitalBook;
import com.casestudy.Models.BookSearchBy;
import com.casestudy.exceptions.BookExceptions;

public interface BookServiceInterface {

	DigitalBook createBookByAuthor(int authorid,DigitalBook book) throws BookExceptions;

	DigitalBook updateBookDetails(int authorid, int bookid, DigitalBook bookentity) throws BookExceptions,SQLException;

	DigitalBook searchBook(String category, String authorname, double price,String publisher) throws BookExceptions;

	List<DigitalBook> getAllBooks() throws BookExceptions;

	DigitalBook save(DigitalBook book);

	
}
