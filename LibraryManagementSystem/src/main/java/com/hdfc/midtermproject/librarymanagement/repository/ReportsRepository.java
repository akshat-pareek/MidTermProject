package com.hdfc.midtermproject.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.midtermproject.librarymanagement.entity.Reports;

@Repository
public interface ReportsRepository extends JpaRepository<Reports, Long> {
	
}
