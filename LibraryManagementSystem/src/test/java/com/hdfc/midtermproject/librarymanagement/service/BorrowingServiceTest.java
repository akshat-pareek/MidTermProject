package com.hdfc.midtermproject.librarymanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hdfc.midtermproject.librarymanagement.entity.Borrowing;

@SpringBootTest
class BorrowingServiceTest {
	
	private static IBorrowingService borrowingService;
	
	@BeforeAll
	private static void setup() {
		borrowingService=mock(IBorrowingService.class); 
	}
	
	@Test
	void borrowBookTest() throws Exception{
        Borrowing borrowing = new Borrowing();
        when(borrowingService.borrowBook(0, 0, 0)).thenReturn(borrowing);
        assertEquals(borrowing,borrowingService.borrowBook(0, 0, 0));
	}
	
	@Test
	void returnBookTest() throws Exception {
		Borrowing borrowing=new Borrowing();
		when(borrowingService.returnBook(0)).thenReturn(borrowing);
		assertEquals(borrowing,borrowingService.returnBook(0));
	}
	
	@Test
	void getBorrowingByIdTest() throws Exception {
		Borrowing borrowing=new Borrowing();
		when(borrowingService.getBorrowingById(0)).thenReturn(borrowing);
		assertEquals(borrowing,borrowingService.getBorrowingById(0));
	}
	
	@Test
	void getAllBorrowings() {
		List<Borrowing> borrowings=new ArrayList<>();
		when(borrowingService.getAllBorrowings()).thenReturn(borrowings);
		assertEquals(borrowings,borrowingService.getAllBorrowings());
	}

}
