package com.hdfc.midtermproject.librarymanagement.dto;

import java.time.LocalDate;


public class BookDTO {
	
	private long bookId;
	private String title;
	private String author;
	private String subject;
	private String isbn;
	private String publisher;
	private LocalDate publicationDate;
	private int quantity;
	private int availableQuantity;
	
	
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public LocalDate getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public BookDTO(long bookId, String title, String author, String subject, String isbn, String publisher,
			LocalDate publicationDate, int quantity, int availableQuantity) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.subject = subject;
		this.isbn = isbn;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
		this.quantity = quantity;
		this.availableQuantity = availableQuantity;
	}
	public BookDTO() {
		super();
	}
}
