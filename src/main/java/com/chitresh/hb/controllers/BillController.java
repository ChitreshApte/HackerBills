package com.chitresh.hb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chitresh.hb.MessageResponse;
import com.chitresh.hb.models.Bill;
import com.chitresh.hb.repository.BillRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/bills")
public class BillController {
	
	@Autowired
	BillRepository billRepo;
	
	@GetMapping() 
	public List<Bill> getAllBills() {
		return billRepo.findAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addBill(@RequestBody Bill bill) {
		if(billRepo.existsById(bill.getBillNumber())) {
				return ResponseEntity
						.badRequest().body(new MessageResponse("Bill with same number exists"));
		}
		billRepo.save(bill);
		return ResponseEntity.ok(new MessageResponse("Bill added successfully"));
	}
	
	@GetMapping("/{billNumber}")
	public ResponseEntity<?> findById(@PathVariable("billNumber") Long billNumber) {
		Bill ans = null;
		for(Bill b : billRepo.findAll()) {
			if(b.getBillNumber() == billNumber) {
				ans = b;
			}
		}
		if(ans == null) {
			return ResponseEntity
					.badRequest().body(new MessageResponse("Bill not found"));
		}
		return ResponseEntity.ok(ans);
	}
	
	@GetMapping("/due/{dueDate}")
	public ResponseEntity<?> findBydueDate(@PathVariable("dueDate") String dueDate) {
		List<Bill> ans = new ArrayList<>();
		for(Bill b : billRepo.findAll()) {
			if(b.getBilledDate().equals(dueDate)) {
				ans.add(b);
			}
		}
		return ResponseEntity.ok(ans);
	}
	
}
