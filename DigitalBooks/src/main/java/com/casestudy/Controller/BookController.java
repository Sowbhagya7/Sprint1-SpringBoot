package com.casestudy.Controller;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.Entity.BuyBook;
import com.casestudy.Entity.DigitalBook;
import com.casestudy.Models.AuthorCreateResponse;
import com.casestudy.Models.BookSearchBy;
import com.casestudy.Service.BookServiceInterface;
import com.casestudy.exceptions.BookExceptions;


@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
	@Autowired
	BookServiceInterface bookservice;
	@Autowired
	private KafkaTemplate<String, BuyBook> kafkaTemplate;

	private static final String TOPIC = "kafka-newtopic";

	@GetMapping("/publish")
	public String publishBook() {

		kafkaTemplate.send(TOPIC, new BuyBook(1,"sow","sow@gmail.",1,"26-01-1998"));

		return "Published successfully: " + LocalDateTime.now();
	}

	@PostMapping("/{authorid}/books")
	public AuthorCreateResponse createBook(@PathVariable int authorid, @RequestBody DigitalBook book) {
		AuthorCreateResponse response = new AuthorCreateResponse();

		try {
			DigitalBook bookentity = bookservice.createBookByAuthor(authorid, book);
			response.setBookcerated(bookentity);
			response.setMessage("Bookcreated");
		} catch (BookExceptions e) {

			response.setException(e.getMessage());
		}

		return response;
	}

	@PutMapping("/{authorid}/books/{bookid}")
	public DigitalBook updateBookDetails(@PathVariable int authorid, @PathVariable int bookid,
			@RequestBody DigitalBook bookentity) throws BookExceptions, SQLException {
		DigitalBook bookentity2 = bookservice.updateBookDetails(authorid, bookid, bookentity);
		System.out.println("Book Updated Successfully.");

		return bookentity2;
	}

	@GetMapping("/search")
	public DigitalBook searchBook(@RequestParam String category, @RequestParam String authorname,
			@RequestParam double price, @RequestParam String publisher) throws BookExceptions {
		System.out.println("search called");

		return bookservice.searchBook(category, authorname, price, publisher);

	}

	@GetMapping("/getBooks")
	public List<DigitalBook> getbooks() throws BookExceptions {
		return bookservice.getAllBooks();
	}

	@PostMapping("/post")
	public DigitalBook CreateBook(@RequestBody DigitalBook Book) {

		return bookservice.save(Book);
	}

}
