package com.casestudy.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.Entity.DigitalBook;
import com.casestudy.Models.AuthorReference;
import com.casestudy.Models.BookSearchBy;
import com.casestudy.Repository.BookRepository;
import com.casestudy.clients.AuthorServiceClient;
import com.casestudy.exceptions.BookExceptions;


@Service
public class BookService implements BookServiceInterface {
	@Autowired
	private BookRepository bookrepository;
	@Autowired
	private AuthorServiceClient client;

	@Override
	public DigitalBook createBookByAuthor(int authorid,DigitalBook book) throws BookExceptions {
		Optional<AuthorReference> authorEntity = client.getAuthorByID(authorid);
		String authorname=authorEntity.get().getUsername();
		DigitalBook bookdetails = new DigitalBook();
		if (!authorEntity.isEmpty()) {
			if (book.getCategory() != null) {
				bookdetails.setActive(book.getActive());
				bookdetails.setAuthorid(book.getAuthorid());
				bookdetails.setCategory(book.getCategory());
				bookdetails.setContents(book.getContents());
				bookdetails.setPrice(book.getPrice());
				bookdetails.setPublishdate(book.getPublishdate());
				bookdetails.setPublisher(book.getPublisher());
				bookdetails.setTitle(book.getTitle());
				bookdetails.setAuthorid(authorEntity.get().getAid());
				bookdetails.setAuthorname(authorname);
				bookrepository.save(bookdetails);
			} else {
				throw new BookExceptions("give all details");
			}
		} else {
			throw new BookExceptions("Invalid Book ID or Author ID...");
		}
		return bookdetails;
	}

	@Override
	public DigitalBook updateBookDetails(int authorid, int bookid, DigitalBook bookentity) throws BookExceptions, SQLException {
Optional<DigitalBook> bookDetails = bookrepository.findBook(authorid, bookid);

if (!bookDetails.isEmpty()) {
	if (bookentity.getCategory() != null) {
		bookDetails.get().setCategory(bookentity.getCategory());
	}

	if (Objects.nonNull(bookentity.getContents())) {
		bookDetails.get().setContents(bookentity.getContents());
	}

	if (Objects.nonNull(bookentity.getPublishdate())) {
		bookDetails.get().setPublishdate(bookentity.getPublishdate());
	}

	if (Objects.nonNull(bookentity.getPublisher())) {
		bookDetails.get().setPublisher(bookentity.getPublisher());
	}

	if (bookentity.getPrice()!=0) {
		bookDetails.get().setPrice(bookentity.getPrice());
	}
	if (Objects.nonNull(bookentity.getActive())) {
		bookDetails.get().setActive(bookentity.getActive());
	}

	return bookrepository.save(bookDetails.get());

} else {
	throw new BookExceptions("Invalid Book ID or Author ID...");
}

	}

	@Override
	public DigitalBook searchBook(String category, String authorname, double price,String publisher) throws BookExceptions{
		// TODO Auto-generated method stub
		return bookrepository.SearchBook(category,authorname,price,publisher);
	}

	@Override
	public List<DigitalBook> getAllBooks() throws BookExceptions {
		// TODO Auto-generated method stub
		return bookrepository.findAll();
	}

	@Override
	public DigitalBook save(DigitalBook book) {
		// TODO Auto-generated method stub
		return bookrepository.save(book);
	}

}
