package com.hdfc.midtermproject.librarymanagement.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {
	
	@Id
	@Column(name="book_id")
	private long bookId;
	
	@NotNull
	@Column(name="title")
	private String title;
	
	@NotNull
	@Column(name="author")
	private String author;
	
	@NotNull
	@Column(name="subject")
	private String subject;
	
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="publisher")
	private String publisher;
	
	@Column(name="publication_date")
	private LocalDate publicationDate;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="available_quantity")
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
	public Book(long bookId, @NotNull String title, @NotNull String author, @NotNull String subject, String isbn,
			String publisher, LocalDate publicationDate, int quantity, int availableQuantity) {
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
	public Book() {
		super();
	}
}
