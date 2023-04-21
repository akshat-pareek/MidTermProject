package com.hdfc.midtermproject.librarymanagement.dto;

public class ReportsDTO {
	
	private long reportId;
	private String userActivity;
	private String bookStatus;
	private double fineCollected;
	
	
	public long getReportId() {
		return reportId;
	}
	public void setReportId(long reportId) {
		this.reportId = reportId;
	}
	public String getUserActivity() {
		return userActivity;
	}
	public void setUserActivity(String userActivity) {
		this.userActivity = userActivity;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	public double getFineCollected() {
		return fineCollected;
	}
	public void setFineCollected(double fineCollected) {
		this.fineCollected = fineCollected;
	}
	public ReportsDTO(long reportId, String userActivity, String bookStatus, double fineCollected) {
		super();
		this.reportId = reportId;
		this.userActivity = userActivity;
		this.bookStatus = bookStatus;
		this.fineCollected = fineCollected;
	}
	public ReportsDTO() {
		super();
	}
}
