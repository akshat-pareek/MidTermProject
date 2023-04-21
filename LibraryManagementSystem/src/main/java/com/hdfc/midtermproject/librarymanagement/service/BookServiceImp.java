package com.hdfc.midtermproject.librarymanagement.service;

/*	Implementation of IBookService interface named BookServiceImp.
	It uses an instance of BookRepository which extends to JPA repository 
	to perform CRUD operations.
	
	addBook method takes a BookDTO object as input, creates a new 
	Book object using its properties, and saves it using the bookRepository.

	updateBook method does the same thing as addBook by overwriting the
	previous data with the new data.

	deleteBook method takes a bookId parameter, used to delete a Book entity 
	with that ID using the bookRepository.

	getAllBooks method returns a list of all Book entities using the 
	bookRepository's findAll method.
	
	getByTitle, getByAuthor, and getBySubject methods retrieve books from the 
	database based on the values of their title, author, and subject attributes, 
	respectively, using the corresponding methods provided by the bookRepository object.
*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midtermproject.librarymanagement.dto.BookDTO;
import com.hdfc.midtermproject.librarymanagement.entity.Book;
import com.hdfc.midtermproject.librarymanagement.repository.BookRepository;

@Service
public class BookServiceImp implements IBookService{
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book addBook(BookDTO dto) {
		Book book=new Book();
		book.setBookId(dto.getBookId());
		book.setTitle(dto.getTitle());
		book.setAuthor(dto.getAuthor());
		book.setSubject(dto.getSubject());
		book.setIsbn(dto.getIsbn());
		book.setPublisher(dto.getPublisher());
		book.setPublicationDate(dto.getPublicationDate());
		book.setQuantity(dto.getQuantity());
		book.setAvailableQuantity(dto.getAvailableQuantity());
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(BookDTO dto) {
		Book book=new Book();
		book.setBookId(dto.getBookId());
		book.setTitle(dto.getTitle());
		book.setAuthor(dto.getAuthor());
		book.setSubject(dto.getSubject());
		book.setIsbn(dto.getIsbn());
		book.setPublisher(dto.getPublisher());
		book.setPublicationDate(dto.getPublicationDate());
		book.setQuantity(dto.getQuantity());
		book.setAvailableQuantity(dto.getAvailableQuantity());
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public void deleteBook(long bookId) {
		bookRepository.deleteById(bookId);
	}

	@Override
	public List<Book> getByTitle(String title) {
		return bookRepository.findByTitle(title);
	}

	@Override
	public List<Book> getByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	@Override
	public List<Book> getBySubject(String subject) {
		return bookRepository.findBySubject(subject);
	}

}
