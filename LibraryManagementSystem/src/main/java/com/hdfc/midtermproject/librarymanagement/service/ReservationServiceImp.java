package com.hdfc.midtermproject.librarymanagement.service;

/*	Implementation of IReservationService interface named ReservationServiceImp.
	It uses an instance of ReservatiomRepository which extends to JPA repository 
	to perform CRUD operations.
	
	reserveBook method is used reserve a book for a user if bookAvailability is 0.
	It creates a new reservation object with reservationId, user object fetched from 
	the userRepository using the userId, book object, reservationDate set to current date.
	It saves the reservation object in reservationRepository and returns it.
	
	getReservationById method is used to fetch a Reservation object with the specified reservationId
	from the ReservationRepository. It throws an exception if the Reservation object is not
	found and returns the Reservation object if it is found.
	
	getAllReservations method returns a list of all Reservation entities using the 
	ReservationRepository's findAll method.
*/

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midtermproject.librarymanagement.entity.Reservation;
import com.hdfc.midtermproject.librarymanagement.exception.NotFoundException;
import com.hdfc.midtermproject.librarymanagement.repository.BookRepository;
import com.hdfc.midtermproject.librarymanagement.repository.ReservationRepository;
import com.hdfc.midtermproject.librarymanagement.repository.UserRepository;

@Service
public class ReservationServiceImp implements IReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BookRepository bookRepository;

	@Override
	public Reservation reserveBook(long reservationId, long userId, long bookId) throws Exception {
		
		Reservation reservation = new Reservation();
        reservation.setReservationId(reservationId);
        reservation.setUser(userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found with ID: "+userId)));
        reservation.setBook(bookRepository.findById(bookId).orElseThrow(() -> new NotFoundException("Book not found with ID: "+bookId)));
        reservation.setReservationDate(LocalDate.now());

        reservationRepository.save(reservation);
        return reservation;
	}
	
	@Override
	public Reservation getReservationById(long reservationId) throws Exception{
		
		Reservation reservation=reservationRepository.findById(reservationId).orElseThrow(()-> new NotFoundException("Reservation not found with ID: "+reservationId));
		return reservation;
	}

	@Override
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}

}
