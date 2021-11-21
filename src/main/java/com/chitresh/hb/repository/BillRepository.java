package com.chitresh.hb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chitresh.hb.models.Bill;

public interface BillRepository extends JpaRepository<Bill, Long>{
	
	List<Bill> findByBillNumber(Long billNumber);
}
