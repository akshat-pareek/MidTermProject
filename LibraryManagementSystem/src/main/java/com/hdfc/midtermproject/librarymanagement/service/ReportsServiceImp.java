package com.hdfc.midtermproject.librarymanagement.service;

/*	Implementation of IReporstService interface named ReportsServiceImp.
	It uses an instance of ReportsRepository which extends to JPA repository 
	to perform CRUD operations.
	
	addReport method is used to create a report for a user.
	It first check with the specified userId from UserRepository exists or not.
	If not it throws an exception. If it does then it creates a new reports object.
	Then it is checked whether the user's account status is active or inactive.
	If it is inactive, then reportId is set as userId, userActivity as "INACTIVE",
	bookStatus as null, and fineCollected as 0.0.
	Otherwise, if it is active, then the borrowing and loan details are fetched from
	the respective repositories, and reportId is set as userId, userActivity as "ACTIVE",
	bookStatus as the status of the borrowing, and fineCollected as the fine collected from the loan.
	
	getReportById method is used to fetch a Report object with the specified reportId
	from the ReportRepository. It throws an exception if the Report object is not
	found and returns the Report object if it is found.
	
	generateReport method returns a list of all Reports entities using the 
	ReportsRepository's findAll method.
*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midtermproject.librarymanagement.entity.Borrowing;
import com.hdfc.midtermproject.librarymanagement.entity.LoanManagement;
import com.hdfc.midtermproject.librarymanagement.entity.Reports;
import com.hdfc.midtermproject.librarymanagement.entity.User;
import com.hdfc.midtermproject.librarymanagement.exception.NotFoundException;
import com.hdfc.midtermproject.librarymanagement.repository.BorrowingRepository;
import com.hdfc.midtermproject.librarymanagement.repository.LoanManagementRepository;
import com.hdfc.midtermproject.librarymanagement.repository.ReportsRepository;
import com.hdfc.midtermproject.librarymanagement.repository.UserRepository;

@Service
public class ReportsServiceImp implements IReportsService {
	
	@Autowired
	private ReportsRepository reportsRepository;
	
	@Autowired
	private LoanManagementRepository loanManagementRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BorrowingRepository borrowingRepository;
	
	@Override
	public Reports addReport(long userId, long borrowingId, long loanId) throws Exception{
		
		User user=userRepository.findById(userId).orElseThrow(()->new NotFoundException("User not found with ID: "+userId));
		Reports reports=new Reports();
		
		if(user.getAccountStatus()=="INACTIVE") {
			reports.setReportId(userId);
			reports.setUserActivity("INACTIVE");
			reports.setBookStatus(null);
			reports.setFineCollected(0.0);
		}
		else {
			Borrowing borrowing = borrowingRepository.findById(borrowingId).orElseThrow(()->new NotFoundException("Borrowing not found with ID: "+borrowingId));
			LoanManagement loan=loanManagementRepository.findById(loanId).orElseThrow(()->new NotFoundException("Loan not found with ID: "+loanId));
			
			reports.setReportId(userId);
			reports.setUserActivity("ACTIVE");
			reports.setBookStatus(borrowing.getStatus());
			reports.setFineCollected(loan.getFine());
		}
		reportsRepository.save(reports);
		return reports;
	}
	
	@Override
	public List<Reports> generateReport(){
		return reportsRepository.findAll();
	}

	@Override
	public Reports getReportById(long reportId) throws Exception{
		Reports reports=reportsRepository.findById(reportId).orElseThrow(()-> new NotFoundException("Reprt not found with ID: "+reportId));
		return reports;
	}
}
