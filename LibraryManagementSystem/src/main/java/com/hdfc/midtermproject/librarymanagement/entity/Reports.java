package com.hdfc.midtermproject.librarymanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reports")
public class Reports {
	
	@Id
	@Column(name="report_id")
	private long reportId;
	
	@Column(name="user_activity")
	private String userActivity;
	
	@Column(name="book_status")
	private String bookStatus;
	
	@Column(name="fine_collected")
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

	public Reports(long reportId, String userActivity, String bookStatus, double fineCollected) {
		super();
		this.reportId = reportId;
		this.userActivity = userActivity;
		this.bookStatus = bookStatus;
		this.fineCollected = fineCollected;
	}

	public Reports() {
		super();
	}
}
