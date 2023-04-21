package com.hdfc.midtermproject.librarymanagement.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="borrowing")
public class Borrowing {
	
	@Id
	@Column(name="borrowing_id")
	private long borrowingId;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_id")
	private Book book;
	
	@NotNull
	@Column(name="borrow_date")
	private LocalDate borrowDate;
	
	@Column(name="due_date")
	private LocalDate dueDate;
	
	@Column(name="return_date")
	private LocalDate returnDate;
	
	@Column(name="status")
	private String status;

	public long getBorrowingId() {
		return borrowingId;
	}

	public void setBorrowingId(long borrowingId) {
		this.borrowingId = borrowingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Borrowing(long borrowingId, @NotNull User user, @NotNull Book book, @NotNull LocalDate borrowDate,
			LocalDate dueDate, LocalDate returnDate, String status) {
		super();
		this.borrowingId = borrowingId;
		this.user = user;
		this.book = book;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.status = status;
	}

	public Borrowing() {
		super();
	}
}
