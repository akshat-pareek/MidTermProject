package com.hdfc.midtermproject.librarymanagement.dto;

import java.time.LocalDate;

public class ReservationDTO {
	
	private long reservationId;
	private long userId;
	private long bookId;
	private LocalDate reservationDate;
	
	
	public ReservationDTO() {
		super();
	}
	public ReservationDTO(long reservationId, long userId, long bookId, LocalDate reservationDate) {
		super();
		this.reservationId = reservationId;
		this.userId = userId;
		this.bookId = bookId;
		this.reservationDate = reservationDate;
	}
	public long getReservationId() {
		return reservationId;
	}
	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
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
	public LocalDate getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}
}
