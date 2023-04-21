package com.hdfc.midtermproject.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.midtermproject.librarymanagement.entity.Borrowing;
import com.hdfc.midtermproject.librarymanagement.exception.NotFoundException;
import com.hdfc.midtermproject.librarymanagement.service.IBorrowingService;

@RestController
@RequestMapping("/library/borrowing")
public class BorrowingRestController {
	
	@Autowired
	private IBorrowingService borrowingService;
	
	@PostMapping("/borrow/{borrowingId}/{userId}/{bookId}")
	public ResponseEntity<Borrowing> borrowBook(@PathVariable long borrowingId,@PathVariable long userId,@PathVariable long bookId) throws Exception{
		Borrowing borrowing= borrowingService.borrowBook(borrowingId, userId, bookId);
		return new ResponseEntity<Borrowing>(borrowing,HttpStatus.OK);
	}
	
	@PutMapping("/return/{borrowingId}")
	public ResponseEntity<Borrowing> returnBook(@PathVariable long borrowingId) throws Exception {
		Borrowing borrowing= borrowingService.returnBook( borrowingId);
		return new ResponseEntity<Borrowing>(borrowing,HttpStatus.OK);
	}
	
	@GetMapping("/get/{borrowingId}")
	public ResponseEntity<Borrowing> getBorrrowingById(@PathVariable long borrowingId) throws Exception{
		Borrowing borrowing=borrowingService.getBorrowingById(borrowingId);
		return new ResponseEntity<Borrowing>(borrowing,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public List<Borrowing> getAllBorrowings() throws Exception{
		if(borrowingService.getAllBorrowings().isEmpty()) {
			throw new NotFoundException("Borrowing is Empty");
		}
		return borrowingService.getAllBorrowings();
	}
}
