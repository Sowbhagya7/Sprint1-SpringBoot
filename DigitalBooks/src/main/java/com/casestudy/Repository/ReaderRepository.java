package com.casestudy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.casestudy.Entity.BuyBook;

@Repository
public interface ReaderRepository extends JpaRepository<BuyBook, Integer> {
	@Query("select D from BuyBook D where D.emailid=:emailId")

	BuyBook findByEmailId(String emailId);

	@Query("select D from BuyBook D where D.pid=?1")
	BuyBook findbypid( long pid);
	@Query("select D from BuyBook D where D.emailid=:emailid and D.bookid=:bookid")
	BuyBook findByBookId(String emailid,int bookid);
	@Query("select D from BuyBook D where D.emailid=:emailId and D.bookid=:bookId")
	BuyBook findByEmailIdandBookid(String emailId, Integer bookId);



	

}
