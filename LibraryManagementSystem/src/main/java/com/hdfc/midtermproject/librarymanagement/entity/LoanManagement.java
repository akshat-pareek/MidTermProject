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
@Table(name="loanManagement")
public class LoanManagement {
	
	@Id
	@Column(name="loan_id")
	private long loanId;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_id")
	private Book book;
	
	@Column(name="due_date")
	private LocalDate dueDate;
	
	@Column(name="fine")
	private double fine;

	public long getLoanId() {
		return loanId;
	}

	public void setLoanId(long loanId) {
		this.loanId = loanId;
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

	public LoanManagement(long loanId, @NotNull User user, @NotNull Book book, LocalDate dueDate, double fine) {
		super();
		this.loanId = loanId;
		this.user = user;
		this.book = book;
		this.dueDate = dueDate;
		this.fine = fine;
	}

	public LoanManagement() {
		super();
	}
}
