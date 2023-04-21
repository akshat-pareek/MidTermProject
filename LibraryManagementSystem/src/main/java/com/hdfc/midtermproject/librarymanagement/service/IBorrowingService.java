package com.hdfc.midtermproject.librarymanagement.service;

import java.util.List;

import com.hdfc.midtermproject.librarymanagement.entity.Borrowing;

public interface IBorrowingService {
	
	public Borrowing borrowBook(long borrowingId,long userId, long bookId) throws Exception;
	
	public Borrowing returnBook(long borrowingId) throws Exception ;
	
	public Borrowing getBorrowingById(long borrowingId) throws Exception;
	
	public List<Borrowing> getAllBorrowings();
}
