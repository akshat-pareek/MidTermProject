package com.hdfc.midtermproject.librarymanagement.service;

/*	Implementation of ILoanManagementService interface named LoanManagementServiceImp.
	It uses an instance of LoanManagementRepository which extends to JPA repository 
	to perform CRUD operations.
	
	getFine method calculates the fine for a book borrowing. 
	First the Borrowing object is retrieved from the borrowingRepository based on the given
	borrowingId. If the book has not been returned yet, the fine is calculated based on the
	number of days the book has been delayed beyond the due date, with a fine of 50.0 units per day.
	If the book has been returned, the fine is calculated based on the number of days the book 
	was delayed between the due date and the return date.
	The calculated fine amount is then set in the LoanManagement object, and it is saved 
	to the loanRepository before returning it.
	
	sendReminder method sends a reminder message to the user about the book borrowing status.
	First the Borrowing object is retrieved from the borrowingRepository based on the given borrowingId.
	If the due date is in less than 2 days from the current date, the message would be to return the book before the due date.
	If the due date has already passed, the message would be to return the book as soon as possible.
	Otherwise, the message would be a reminder about the due date of the borrowing.
	Finally, the appropriate message string is returned.
	
	getLoanById method is used to fetch a LoanManagement object with the specified loanId
	from the LoanManagementRepository. It throws an exception if the Loan object is not
	found and returns the Loan object if it is found.
	
	getAllLoans method returns a list of all Loan entities using the 
	LoanManagementRepository's findAll method.
*/

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midtermproject.librarymanagement.entity.Borrowing;
import com.hdfc.midtermproject.librarymanagement.entity.LoanManagement;
import com.hdfc.midtermproject.librarymanagement.exception.NotFoundException;
import com.hdfc.midtermproject.librarymanagement.repository.BorrowingRepository;
import com.hdfc.midtermproject.librarymanagement.repository.LoanManagementRepository;

@Service
public class LoanManagementServiceImp implements ILoanManagementService {
	
	@Autowired
	private LoanManagementRepository loanRepository;
	
	@Autowired
    private BorrowingRepository borrowingRepository;
	
	@Override
	public LoanManagement getFine(long loanId,long borrowingId) throws Exception{
		
		Borrowing borrowing = borrowingRepository.findById(borrowingId).orElseThrow(() -> new NotFoundException("Borrowing not found with ID: "+borrowingId));

		LoanManagement loan=new LoanManagement();
		loan.setLoanId(loanId);
		loan.setUser(borrowing.getUser());
		loan.setBook(borrowing.getBook());
		loan.setDueDate(borrowing.getDueDate());
		
		if(borrowing.getReturnDate()==null) {
			if(LocalDate.now().compareTo(borrowing.getDueDate())<0) {
				loan.setFine(0.0);
			}
			else {
				int daysDelayed=(int) ChronoUnit.DAYS.between(borrowing.getDueDate(),LocalDate.now());
				double fine=daysDelayed*50.0;

				loan.setFine(fine);
			}
		}
		
		else {
			if(borrowing.getReturnDate().compareTo(borrowing.getDueDate())<0) {
				loan.setFine(0.0);
			}
			else {
				int daysDelayed=(int) ChronoUnit.DAYS.between(borrowing.getDueDate(),borrowing.getReturnDate());
				double fine=daysDelayed*50.0;

				loan.setFine(fine);
			}
		}
		loanRepository.save(loan);
		return loan;
	}
	
	@Override
	public String sendReminder(long borrowingId) throws Exception{
		
		Borrowing borrowing=borrowingRepository.findById(borrowingId).orElseThrow(() -> new NotFoundException("Borrowing not found with ID: "+borrowingId));
		
		if(borrowing.getDueDate().compareTo(LocalDate.now())<2 && borrowing.getDueDate().compareTo(LocalDate.now())>0) {
			return "Hurry and return your book before the due date.";
		}
		if(borrowing.getDueDate().compareTo(LocalDate.now())<0) {
			return "You've missed the due date of returning the book, return as soon as possible to reduce the loan amount.";
		}
		return "The due date is "+borrowing.getDueDate()+" remember to return on time.";
	}

	@Override
	public LoanManagement getLoanById(long loanId) throws Exception{
		LoanManagement loan=loanRepository.findById(loanId).orElseThrow(()-> new NotFoundException("Loan not found") );
		return loan;
	}

	@Override
	public List<LoanManagement> getAllLoans() {
		return loanRepository.findAll();
	}

}
