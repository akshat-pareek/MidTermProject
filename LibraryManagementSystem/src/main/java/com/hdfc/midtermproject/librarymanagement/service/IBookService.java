package com.hdfc.midtermproject.librarymanagement.service;

import java.util.List;

import com.hdfc.midtermproject.librarymanagement.dto.BookDTO;
import com.hdfc.midtermproject.librarymanagement.entity.Book;

public interface IBookService {
	
	public Book addBook(BookDTO dto);
	
	public Book updateBook(BookDTO dto);
	
	public List<Book> getAllBooks();
	
	public void deleteBook(long bookId);
	
	public List<Book> getByTitle(String title);

	public List<Book> getByAuthor(String author);
	
	public List<Book> getBySubject(String subject);
	
}
