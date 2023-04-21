package com.hdfc.midtermproject.librarymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hdfc.midtermproject.librarymanagement.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query("select b from Book b where b.title=?1")
	public List<Book> findByTitle(String title);
	
	@Query("select b from Book b where b.author=?1")
	public List<Book> findByAuthor(String author);
	
	@Query("select b from Book b where b.subject=?1")
	public List<Book> findBySubject(String subject);
}
