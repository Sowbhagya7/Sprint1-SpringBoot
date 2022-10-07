package com.casestudy.Repository;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.casestudy.Entity.DigitalBook;
import com.casestudy.Models.BookSearchBy;

@Repository
public interface BookRepository extends JpaRepository<DigitalBook, Integer> {
	@Query("select D from DigitalBook D where D.category=?1 and D.authorname=?2 and D.price=?3 and D.publisher=?4")
	DigitalBook SearchBook(String category, String authorname, double price, String publisher);

	@Query("select D from DigitalBook D where D.authorid=:authorid and D.id=:bookid")
	Optional<DigitalBook> findBook(int authorid, int bookid);

}
