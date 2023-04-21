package com.hdfc.midtermproject.librarymanagement.service;

import java.util.List;

import com.hdfc.midtermproject.librarymanagement.entity.LoanManagement;

public interface ILoanManagementService {
	
	public LoanManagement getFine(long loanId,long borrowingId) throws Exception;
	
	public String sendReminder(long borrowingId) throws Exception;

	public LoanManagement getLoanById(long loanId) throws Exception;
	
	public List<LoanManagement> getAllLoans();
}
