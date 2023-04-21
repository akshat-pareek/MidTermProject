package com.hdfc.midtermproject.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.midtermproject.librarymanagement.entity.Borrowing;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Long>{
	
}
