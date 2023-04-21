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

import com.hdfc.midtermproject.librarymanagement.entity.Reports;
import com.hdfc.midtermproject.librarymanagement.exception.NotFoundException;
import com.hdfc.midtermproject.librarymanagement.service.IReportsService;

@RestController
@RequestMapping("/library/reports")
public class ReportsRestController {
	
	@Autowired
	private IReportsService reportsService;
	
	@PostMapping("/add/{userId}/{borrowingId}/{loanId}")
	public ResponseEntity<Reports> addReport(@PathVariable long userId,@PathVariable long borrowingId,@PathVariable long loanId) throws Exception{
		Reports reports= reportsService.addReport(userId,borrowingId,loanId);
		return new ResponseEntity<Reports>(reports,HttpStatus.OK);
	}
	
	@GetMapping("/get/{reportId}")
	public ResponseEntity<Reports> getReportById(@PathVariable long reportId) throws Exception{
		Reports reports=reportsService.getReportById(reportId);
		return new ResponseEntity<Reports>(reports,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public List<Reports> generateReport() throws Exception{
		if(reportsService.generateReport().isEmpty()) {
			throw new NotFoundException("No user found");
		}
		return reportsService.generateReport();
	}
}
