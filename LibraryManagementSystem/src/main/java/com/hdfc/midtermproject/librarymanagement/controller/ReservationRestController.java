package com.hdfc.midtermproject.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.midtermproject.librarymanagement.entity.Reservation;
import com.hdfc.midtermproject.librarymanagement.exception.NotFoundException;
import com.hdfc.midtermproject.librarymanagement.service.IReservationService;

@RestController
@RequestMapping("/library/reservation")
public class ReservationRestController {
	
	@Autowired
	private IReservationService reservationService;
	
	@PostMapping("/reserve/{reservationId}/{userId}/{bookId}")
	public ResponseEntity<Reservation> reserveBook(@PathVariable long reservationId,@PathVariable long userId,@PathVariable long bookId) throws Exception{
		Reservation reservation = reservationService.reserveBook(reservationId, userId, bookId);
		return new ResponseEntity<Reservation>(reservation,HttpStatus.OK);
	}
	
	@GetMapping("/get/{reservationId}")
	public ResponseEntity<Reservation> getReservationById(long reservationId) throws Exception{
		Reservation reservation=reservationService.getReservationById(reservationId);
		return new ResponseEntity<Reservation>(reservation,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public List<Reservation> getAllReservations() throws Exception{
		if(reservationService.getAllReservations().isEmpty()) {
			throw new NotFoundException("No reservation found");
		}
		return reservationService.getAllReservations();
	}
}
