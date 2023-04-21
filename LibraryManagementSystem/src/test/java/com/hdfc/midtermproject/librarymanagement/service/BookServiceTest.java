package com.hdfc.midtermproject.librarymanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hdfc.midtermproject.librarymanagement.dto.BookDTO;
import com.hdfc.midtermproject.librarymanagement.entity.Book;

@SpringBootTest
class BookServiceTest {
	
	private static IBookService bookService;
	
	@BeforeAll
	public static void setup() {
		bookService = mock(IBookService.class);
	}
	
	@Test
	void addBookTest() {
		BookDTO dto = new BookDTO();
		Book book = new Book();
		when(bookService.addBook(dto)).thenReturn(book);
		assertEquals(book, bookService.addBook(dto));
	}
	
	@Test
	void updateBookTest() {
		BookDTO dto = new BookDTO();
		Book book = new Book();
		when(bookService.updateBook(dto)).thenReturn(book);
		assertEquals(book, bookService.updateBook(dto));
	}
	
	void getAllBooksTest(){
		List<Book> books = new ArrayList<>();
		when(bookService.getAllBooks()).thenReturn(books);
		assertEquals(books, bookService.getAllBooks());
	}
	
	void deleteBookTest() {
		long bookId = 0L;
		bookService.deleteBook(bookId);
	}
	
	void getByTitleTest(){
		String title = "Test";
		List<Book> books = new ArrayList<>();
		when(bookService.getByTitle(title)).thenReturn(books);
		assertEquals(books, bookService.getByTitle(title));
	}

	void getByAuthor() {
		String author = "Test";
		List<Book> books = new ArrayList<>();
		when(bookService.getByAuthor(author)).thenReturn(books);
		assertEquals(books, bookService.getByAuthor(author));
	}
	
	void getBySubject(){
		String subject = "Test";
		List<Book> books = new ArrayList<>();
		when(bookService.getBySubject(subject)).thenReturn(books);
		assertEquals(books, bookService.getBySubject(subject));
	}
}
