package com.hdfc.midtermproject.librarymanagement.service;

import java.util.List;

import com.hdfc.midtermproject.librarymanagement.entity.Reservation;

public interface IReservationService {
	
	public Reservation reserveBook(long reservationId, long userId,long bookId) throws Exception;
	
	public Reservation getReservationById(long reservationId) throws Exception;
	
	public List<Reservation> getAllReservations();
	
}
