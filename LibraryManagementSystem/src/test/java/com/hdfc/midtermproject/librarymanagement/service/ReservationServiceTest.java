package com.hdfc.midtermproject.librarymanagement.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hdfc.midtermproject.librarymanagement.entity.Reservation;

@SpringBootTest
class ReservationServiceTest {
	
	private static IReservationService reservationService;
	
	@BeforeAll
	private static void setup() {
		reservationService = mock(IReservationService.class);
	}

	@Test
	void reserveBookTest() throws Exception {
		Reservation reservation=new Reservation();
		when(reservationService.reserveBook(0, 0, 0)).thenReturn(reservation);
		assertEquals(reservation,reservationService.reserveBook(0, 0, 0));
	}
	
	@Test
	void getAllReservationsTest() {
		List<Reservation> reservations=new ArrayList<>();
		when(reservationService.getAllReservations()).thenReturn(reservations);
		assertEquals(reservations,reservationService.getAllReservations());
	}
	
	@Test
	void getReservationByIdTest() throws Exception {
		Reservation reservation=new Reservation();
		when(reservationService.getReservationById(0)).thenReturn(reservation);
		assertEquals(reservation, reservationService.getReservationById(0));
	}

}
