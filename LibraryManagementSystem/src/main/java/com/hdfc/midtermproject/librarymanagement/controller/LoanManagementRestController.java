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

import com.hdfc.midtermproject.librarymanagement.entity.LoanManagement;
import com.hdfc.midtermproject.librarymanagement.exception.NotFoundException;
import com.hdfc.midtermproject.librarymanagement.service.ILoanManagementService;

@RestController
@RequestMapping("/library/loan")
public class LoanManagementRestController {
	
	@Autowired
	private ILoanManagementService loanService;
	
	@PostMapping("/fine/{loanId}/{borrowingId}")
	public ResponseEntity<LoanManagement> getFine(@PathVariable long loanId,@PathVariable long borrowingId) throws Exception{
		LoanManagement loan=loanService.getFine(loanId, borrowingId);
		return new ResponseEntity<LoanManagement>(loan,HttpStatus.OK);
	}
	
	@GetMapping("/reminder/{borrowingId}")
	public ResponseEntity<String> sendReminder(@PathVariable long borrowingId) throws Exception{
		String rem=loanService.sendReminder(borrowingId);
		return new ResponseEntity<String>(rem,HttpStatus.OK);
	}
	
	@GetMapping("/get/{loanId}")
	public ResponseEntity<LoanManagement> getLoanById(@PathVariable long loanId) throws Exception{
		LoanManagement loan=loanService.getLoanById(loanId);
		return new ResponseEntity<LoanManagement>(loan,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public List<LoanManagement> getAllLoans() throws Exception{
		if(loanService.getAllLoans().isEmpty()) {
			throw new NotFoundException("no Loans found");
		}
		return loanService.getAllLoans();
	}
}
