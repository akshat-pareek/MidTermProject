package com.hdfc.midtermproject.librarymanagement.dto;

import java.time.LocalDate;

public class BorrowingDTO {
	
	private long borrowingId;
	private long userId;
	private long bookId;
	private LocalDate borrowDate;
	private LocalDate dueDate;
	private LocalDate returnDate;
	private String status;
	
	
	public long getBorrowingId() {
		return borrowingId;
	}
	public void setBorrowingId(long borrowingId) {
		this.borrowingId = borrowingId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
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
	public BorrowingDTO(long borrowingId, long userId, long bookId, LocalDate borrowDate, LocalDate dueDate, LocalDate returnDate,
			String status) {
		super();
		this.borrowingId = borrowingId;
		this.userId = userId;
		this.bookId = bookId;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.status = status;
	}
	public BorrowingDTO() {
		super();
	}
}
