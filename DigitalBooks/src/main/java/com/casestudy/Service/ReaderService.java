package com.casestudy.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.casestudy.Entity.BuyBook;
import com.casestudy.Entity.DigitalBook;
import com.casestudy.Entity.ReaderModel;
import com.casestudy.Repository.BookRepository;
import com.casestudy.Repository.ReaderRepository;
import com.casestudy.exceptions.BookExceptions;

@Service
public class ReaderService {
	@Autowired
	private BookRepository bookrepository;
	@Autowired
	private ReaderRepository rrepo;
	@Autowired
	private KafkaTemplate<String, BuyBook> kafkaTemplate;

	private static final String TOPIC = "kafka-newtopic";

	public BuyBook buy(ReaderModel reader) {
		// TODO Auto-generated method stub
		BuyBook buyBook = new BuyBook();
		Optional<DigitalBook> book = bookrepository.findById(reader.getBookid());
		if (book.get() != null) {

			buyBook.setBookid(reader.getBookid());
			buyBook.setName(reader.getName());
			buyBook.setEmailid(reader.getEmailid());
			Random random = new Random();
			long random1 = random.nextLong();
			buyBook.setPid(random1);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			buyBook.setDate(formatter.format(date));
			kafkaTemplate.send(TOPIC, new BuyBook(1,"sow","sow@gmail.",1,"26-01-1998"));
			rrepo.save(buyBook);

		}

		return buyBook;
	}

	public BuyBook getBuyBook(String emailId) {

		BuyBook user = rrepo.findByEmailId(emailId);

		return user;
	}

	public Optional<DigitalBook> readABook(String emailId, Integer bookId) throws BookExceptions {
		BuyBook user = rrepo.findByEmailIdandBookid(emailId, bookId);
		if (user != null) {
			Optional<DigitalBook> book = bookrepository.findById(bookId);
			// TODO Auto-generated method stub
			return book;
		} else {
			throw new BookExceptions("user not found");
		}

	}

	public BuyBook findBypid(long pid) {

		return rrepo.findbypid(pid);
	}

	public String Refund(String emailid, int bookid) throws BookExceptions, ParseException {

		Date d2 = null;
		Date d1 = null;
		BuyBook user = rrepo.findByBookId(emailid, bookid);
		if (user != null) {
			String date1 = user.getDate();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			String date2 = formatter.format(date);
			d1 = formatter.parse(date1);
			d2 = formatter.parse(date2);

			if (d2.before(d1) || d2.equals(d2)) {
				rrepo.deleteById(bookid);
				return "Book removed";
			} else {
				throw new BookExceptions("not allowed to refund");
			}
		} else {
			return "bookid not found";
		}

	}

}
