package com.moimah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moimah.db.DeliveryRepository;
import com.moimah.model.Delivery;

/**
 * Contoller for deliveries
 * @author moimah
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "deliveries")
public class DeliveryController {

	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	/**
	 * Get all deliveries from database
	 * @return list of deliveries
	 */
	@GetMapping("/get")
	public List<Delivery> getDeliverys() {		
		return deliveryRepository.findAll();
	}
	
	/**
	 * Get all deliveries from an customer
	 * @param id
	 * @return list of deliveries
	 */
	@GetMapping("/get/userid/{id}")
	public List<Delivery> getDeliveriesByUserId(@PathVariable("id") int id) {		
		return deliveryRepository.findDeliveriesByUserId(id);
	}
	
		
	/**
	 * Post for create an new delivery
	 * @param delivery
	 */
	@PostMapping("/add")
	public void createDelivery(@RequestBody Delivery delivery) {		
		deliveryRepository.save(delivery);
	}
	
	/**
	 * Update/Put an existing delivery
	 * @param delivery
	 */
	@PutMapping("/update")
	public void updateDelivery(@RequestBody Delivery delivery) {
		deliveryRepository.save(delivery);
	}
	
	/**
	 * Delete a delivery by id
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = { "/{id}" })
	public Delivery deleteDelivery(@PathVariable("id") long id) {
		Delivery delivery = deliveryRepository.getOne(id);
		deliveryRepository.deleteById(id);
		return delivery;
	}
		
	

}