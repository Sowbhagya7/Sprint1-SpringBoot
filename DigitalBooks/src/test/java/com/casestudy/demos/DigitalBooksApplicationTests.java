package com.casestudy.demos;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.casestudy.Controller.BookController;
import com.casestudy.Entity.DigitalBook;
import com.casestudy.Service.BookServiceInterface;
import com.casestudy.exceptions.BookExceptions;

@SpringBootTest
class DigitalBooksApplicationTests {
	@Mock
	BookServiceInterface bookservice;
	@InjectMocks
	BookController controller;
@Test
	public void getBooks() throws BookExceptions {

		Date Date = new Date();
		Mockito.when(bookservice.getAllBooks())
				.thenReturn(Stream
						.of(new DigitalBook("Sita", 800, "Sony", Date, "Horror", true, "Horror Story Line.."),
								new DigitalBook("Hello", 800, "MVC", Date, "Comic", true, "comic Story Line.."))
						.collect(Collectors.toList()));

		controller.getbooks();
		// Assertions.assertTrue(repository.findById());
	}

}
