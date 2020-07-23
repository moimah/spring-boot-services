package com.moimah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moimah.db.DetailRepository;
import com.moimah.model.Detail;
import com.moimah.model.DetailId;


/**
 * Contoller for details
 * @author moimah
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "details")
public class DetailController {

	
	@Autowired
	private DetailRepository detailRepository;
	
	/**
	 * Get all details from databse
	 * @return list with all details
	 */
	@GetMapping("/get")
	public List<Detail> getDetails() {
		return detailRepository.findAll();
	}
	
	/**
	 * Get all the details linked to an orderId
	 * @param orderId orderId for search details
	 * @return list with all details vinculates to an order
	 */
	@GetMapping("/get/orderid/{orderId}")
	public List<Detail> getDetailsByOrderId(@PathVariable("orderId") int orderId) {		
		return detailRepository.findByOrderId(orderId);
	}
	
	
	/**
	 * Post for create an new detail
	 * @param detail to create
	 */
	@PostMapping("/add")
	public void createDetail(@RequestBody Detail detail) {
		detailRepository.save(detail);
	}
	
	/**
	 * Update/Put a existing detail
	 * @param detail detail to update
	 */
	@PutMapping("/update")
	public void updateDetail(@RequestBody Detail detail) {
		detailRepository.save(detail);
	}
	
	/**
	 * 
	 * Delete an order through the order id and plant id 
	 * @param orderId
	 * @param plantId
	 */
	@DeleteMapping(path = { "/delete/orderid/{orderId}/plantid/{plantId}" })
	public void deleteDetail(@PathVariable("orderId") int orderId, @PathVariable("plantId") int plantId) {		
		
		Detail detail = new Detail();
		DetailId detailId = new DetailId();
		detailId.setOrderId(orderId);
		detailId.setPlantId(plantId);
		detail.setId(detailId);		
		detailRepository.delete(detail);
	}
	
	
	/**
	 * Delete all details from shopping cart
	 * with custom transaction 
	 * @param orderId
	 */
	@Transactional
	@DeleteMapping(path = { "/emptycart/{orderId}" })
	public void emptyCart(@PathVariable("orderId") int orderId) {		
		detailRepository.deleteByOrderId(orderId);		
	}
	
	

	
	

}