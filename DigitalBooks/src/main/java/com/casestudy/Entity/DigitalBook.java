package com.casestudy.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book_Details")
public class DigitalBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookid")
	private Integer id;
	@Column(name = "Title")
	private String title;
	@Column(name = "authorid")
	private int authorid;
	@Column(name = "Price")
	private double price;
	@Column(name = "Publisher")
	private String publisher;
	@Column(name = "Publish_Date")
	private Date publishdate;
	@Column(name = "Category")
	private String category;
	@Column(name = "Active")
	private boolean active;
	@Column(name = "Contents")
	private String contents;
	private String authorname;
	

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAuthorid() {
		return authorid;
	}

	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean getActive(){
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "DigitalBook [id=" + id + ", title=" + title + ", authorid=" + authorid + ", price=" + price
				+ ", publisher=" + publisher + ", publishdate=" + publishdate + ", category=" + category + ", active="
				+ active + ", contents=" + contents + "]";
	}

	public DigitalBook(String title, double price, String publisher, Date publishdate, String category, boolean active,
			String contents) {
		super();
		this.title = title;
		this.price = price;
		this.publisher = publisher;
		this.publishdate = publishdate;
		this.category = category;
		this.active = active;
		this.contents = contents;
	}

	public DigitalBook() {
		// TODO Auto-generated constructor stub
		super();
	}

	

}
