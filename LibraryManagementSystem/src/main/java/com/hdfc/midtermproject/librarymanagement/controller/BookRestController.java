package com.hdfc.midtermproject.librarymanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.midtermproject.librarymanagement.dto.BookDTO;
import com.hdfc.midtermproject.librarymanagement.entity.Book;
import com.hdfc.midtermproject.librarymanagement.exception.NotFoundException;
import com.hdfc.midtermproject.librarymanagement.service.IBookService;

@RestController
@RequestMapping("/library/book")
public class BookRestController {
	
	@Autowired
	private IBookService bookService;
	
	@PostMapping("/add")
	public ResponseEntity<Book> addBook(@Valid @RequestBody BookDTO dto) {
		Book book= bookService.addBook(dto);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Book> updateBook(@Valid @RequestBody BookDTO dto) {
		Book book= bookService.updateBook(dto);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	
	@GetMapping("/getAll") 
	public List<Book> getAllBooks() throws Exception{
		if(bookService.getAllBooks().isEmpty()) {
			throw new NotFoundException("No books found");
		}
		return bookService.getAllBooks();
	}
	
	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable long bookId) {
		bookService.deleteBook(bookId);
		return  new ResponseEntity<String>("Record Deleted ",HttpStatus.OK);
	}
	
	@GetMapping("/getFromTitle/{title}")
	public List<Book> getByTitle(@PathVariable String title) throws Exception{
		if(bookService.getByTitle(title).isEmpty()) {
			throw new NotFoundException("No books with the title "+title+" found");
		}
		return bookService.getByTitle(title);
	}

	@GetMapping("/getFromAuthor/{author}")
	public List<Book> getByAuthor(@PathVariable String author) throws Exception{
		if(bookService.getByAuthor(author).isEmpty()) {
			throw new NotFoundException("No books with the author "+author+" found");
		}
		return bookService.getByAuthor(author);
	}
	
	@GetMapping("/getFromSubject/{subject}")
	public List<Book> getBySubject(@PathVariable String subject) throws Exception{
		if(bookService.getBySubject(subject).isEmpty()) {
			throw new NotFoundException("No books with the subject "+subject+" found");
		}
		return bookService.getBySubject(subject);
	}
}
