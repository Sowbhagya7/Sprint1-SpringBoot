package com.casestudy.Controller;

import java.text.ParseException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.Entity.BuyBook;
import com.casestudy.Entity.DigitalBook;
import com.casestudy.Entity.ReaderModel;
import com.casestudy.Service.ReaderService;
import com.casestudy.exceptions.BookExceptions;

@RestController
@RequestMapping("/book/reader")
@CrossOrigin

public class ReaderController {
	@Autowired
	private ReaderService readerservice;
	
	//private static final String TOPIC = "kafka-newtopic";
	@PostMapping("books/buy")
	public BuyBook buy(@RequestBody ReaderModel reader) {
		//kafkaTemplate.send(TOPIC, reader);
		return readerservice.buy(reader);
		
	}

	@GetMapping("/readers/{emailId}/books")
	public BuyBook getBuyBook(@PathVariable String emailId) {
		return readerservice.getBuyBook(emailId);

	}

	@PostMapping("/readers/{emailId}/books/{bookId}")
	public Optional<DigitalBook> readABook(@PathVariable String emailId, @PathVariable Integer bookId) throws BookExceptions {
		return readerservice.readABook(emailId, bookId);

	}

	@GetMapping("/readers/book")
	public BuyBook findById(@RequestParam long pid) {
		return readerservice.findBypid(pid);
	}

	@PostMapping("/refund/{emailid}/{bookid}")
	public String Refundbook(@PathVariable String emailid, @PathVariable int bookid) throws BookExceptions, ParseException {
		return readerservice.Refund(emailid, bookid);
	}
}
