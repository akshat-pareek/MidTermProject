package com.hdfc.midtermproject.librarymanagement.service;

import java.util.List;

import com.hdfc.midtermproject.librarymanagement.entity.Reports;

public interface IReportsService {
	
	public Reports addReport(long userId, long borrowingId, long loanId) throws Exception;
	
	public Reports getReportById(long reportId) throws Exception;
	
	public List<Reports> generateReport();
}
