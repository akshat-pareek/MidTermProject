package com.hdfc.midtermproject.librarymanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hdfc.midtermproject.librarymanagement.entity.LoanManagement;

@SpringBootTest
class LoanManagementServiceTest {
	
	private static ILoanManagementService loanService;
	
	@BeforeAll
	private static void setup() {
		loanService=mock(ILoanManagementService.class);
	}
	
	@Test
	void getFineTest() throws Exception {
		LoanManagement loan=new LoanManagement();
		when(loanService.getFine(0, 0)).thenReturn(loan);
		assertEquals(loan, loanService.getFine(0, 0));
	}
	
	@Test
	void getLoanByIdTest() throws Exception {
		LoanManagement loan=new LoanManagement();
		when(loanService.getLoanById(0)).thenReturn(loan);
		assertEquals(loan,loanService.getLoanById(0));
	}
	
	@Test
	void getAllLoansTest() {
		List<LoanManagement> loans=new ArrayList<>();
		when(loanService.getAllLoans()).thenReturn(loans);
		assertEquals(loans,loanService.getAllLoans());
	}
}
