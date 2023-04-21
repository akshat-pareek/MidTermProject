package com.hdfc.midtermproject.librarymanagement.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hdfc.midtermproject.librarymanagement.entity.Reports;

@SpringBootTest
class ReportsServiceTest {
	
	private static IReportsService reportsService;
	
	@BeforeAll
	private static void setup() {
		reportsService = mock(IReportsService.class);
	}
	
	@Test
	void addReportTest() throws Exception {
		Reports report=new Reports();
		when(reportsService.addReport(0, 0, 0)).thenReturn(report);
		assertEquals(report,reportsService.addReport(0, 0, 0) );
	}
	
	@Test
	void getReportByIdTest() throws Exception {
		Reports report=new Reports();
		when(reportsService.getReportById(0)).thenReturn(report);
		assertEquals(report, reportsService.getReportById(0));
	}
	
	@Test
	void generateReportTest() {
		List<Reports> reports=new ArrayList<>();
		when(reportsService.generateReport()).thenReturn(reports);
		assertEquals(reports, reportsService.generateReport());
	}
}
