package com.hdfc.midtermproject.librarymanagement.dto;

import java.time.LocalDate;

public class LoanManagementDTO {
	
	private long loanId;
	private long userId;
	private long bookId;
	private LocalDate dueDate;
	private double fine;
	
	
	public long getLoanId() {
		return loanId;
	}
	public void setLoanId(long loanId) {
		this.loanId = loanId;
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
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public LoanManagementDTO(long loanId, long userId, long bookId, LocalDate dueDate, double fine) {
		super();
		this.loanId = loanId;
		this.userId = userId;
		this.bookId = bookId;
		this.dueDate = dueDate;
		this.fine = fine;
	}
	public LoanManagementDTO() {
		super();
	}
}
