package com.hdfc.midtermproject.librarymanagement.service;

/*	Implementation of IBorrowingService interface named BorrowingServiceImp.
	It uses an instance of BorrowingRepository which extends to JPA repository 
	to perform CRUD operations.
	
	borrowBook method is used to borrow a book with the specified bookId and userId. 
	It firsts checks if the book is available for borrowing and throws an exception if not.
	If the book is available, it decrements the availableQuantity of the book and saves the 
	book object in the bookRepository.
	It then creates a new borrowing object with the borrowingId, user object fetched from 
	the userRepository using the userId, book object, borrowDate set to current date, 
	dueDate set to 10 days after the borrowDate, returnDate set to null, and status set to "BORROWED".
	Finally, it saves the borrowing object in the borrowingRepository and returns it.
	
	returnBook method is used to return a book with the specified borrowingId.
	It fetches the borrowing object from the borrowingRepository using the borrowingId
	and throws an exception if it is not found.
	It then increments the availableQuantity of the book associated with the borrowing
	object and saves the book object in the bookRepository. It updates the borrowing 
	object with the returnDate set to the current date and status set to "RETURNED".
	Finally, it saves the updated borrowing object in the borrowingRepository and returns it.
	
	getBorrowingById method is used to fetch a borrowing object with the specified borrowingId
	from the borrowingRepository. It throws an exception if the borrowing object is not found
	and returns the borrowing object if it is found.
	
	getAllBooks method returns a list of all Book entities using the 
	bookRepository's findAll method.
*/

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midtermproject.librarymanagement.entity.Book;
import com.hdfc.midtermproject.librarymanagement.entity.Borrowing;
import com.hdfc.midtermproject.librarymanagement.exception.BookNotAvailableException;
import com.hdfc.midtermproject.librarymanagement.exception.NotFoundException;
import com.hdfc.midtermproject.librarymanagement.repository.BookRepository;
import com.hdfc.midtermproject.librarymanagement.repository.BorrowingRepository;
import com.hdfc.midtermproject.librarymanagement.repository.UserRepository;

@Service
public class BorrowingServiceImp implements IBorrowingService {
	
	@Autowired
    private BorrowingRepository borrowingRepository;
    
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private UserRepository userRepository;


    @Override
    public Borrowing borrowBook(long borrowingId,long userId,long bookId) throws Exception{
    	
    	Book book = bookRepository.findById(bookId).orElseThrow(() -> new NotFoundException("Book not found with ID: "+bookId));
		
		if (book.getAvailableQuantity() == 0) {
			throw new BookNotAvailableException("Book not available for borrowing, but you can reserve it");
		}
		
		book.setAvailableQuantity(book.getAvailableQuantity() - 1);
		bookRepository.save(book);
		
		Borrowing borrowing = new Borrowing();
		borrowing.setBorrowingId(borrowingId);
		borrowing.setUser(userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found with ID: "+userId)));
		borrowing.setBook(book);
		borrowing.setBorrowDate(LocalDate.now());
		borrowing.setDueDate(borrowing.getBorrowDate().plusDays(10));
		borrowing.setReturnDate(null);
		borrowing.setStatus("BORROWED");
		borrowingRepository.save(borrowing);
		
		return borrowing;
    }
    
	@Override
	public Borrowing returnBook(long borrowingId) throws Exception {
		
		Borrowing borrowing = borrowingRepository.findById(borrowingId).orElseThrow(() -> new NotFoundException("Borrowing not found with ID: "+borrowingId));

        Book book = borrowing.getBook();
        book.setAvailableQuantity(book.getAvailableQuantity() + 1);
        bookRepository.save(book);
        
        borrowing.setBorrowingId(borrowingId);
		borrowing.setUser(borrowing.getUser());
		borrowing.setBook(book);
		borrowing.setBorrowDate(borrowing.getBorrowDate());
		borrowing.setDueDate(borrowing.getDueDate());
		borrowing.setReturnDate(LocalDate.now());
		borrowing.setStatus("RETURNED");
		borrowingRepository.save(borrowing);
		
        return borrowing;
	}

	@Override
	public Borrowing getBorrowingById(long borrowingId) throws Exception {
		
		Borrowing borrowing = borrowingRepository.findById(borrowingId).orElseThrow(() -> new NotFoundException("Borrowing not found with ID: "+borrowingId));
		return borrowing;
	}

	@Override
	public List<Borrowing> getAllBorrowings() {
		return borrowingRepository.findAll();
	}

}
