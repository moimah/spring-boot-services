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

import com.moimah.db.OrderRepository;
import com.moimah.model.Order;



/**
 * Controllers for orders
 * @author moimah
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "orders")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	/**
	 * Get all orders from databse	
	 * @return list with all orders
	 */
	@GetMapping("/get")
	public List<Order> getOrders() {
		return orderRepository.findAll();
	}
	
	/**
	 * Get the last active shopping cart with user id
	 * make a custom query from order repository
	 * @param userId
	 * @return
	 */
	@GetMapping("/lastcart/{userId}")
	public Order getLastShoppingOrder(@PathVariable("userId") int userId) {	
		return orderRepository.findLastShoppingOrder(userId);
	}
	
	/**
	 * Post for create an new order
	 * @param order to create
	 */
	@PostMapping("/add")
	public void createOrder(@RequestBody Order order) {		
		orderRepository.save(order);
	}
	
	/**
	 * Delete a order by id
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = { "/{id}" })
	public Order deleteOrder(@PathVariable("id") long id) {
		Order order = orderRepository.getOne(id);
		orderRepository.deleteById(id);
		return order;
	}
	
	/**
	 * Update a existing order
	 * @param order to update
	 * @return
	 */
	@PutMapping("/update")
	public void updateOrder(@RequestBody Order order) {
		orderRepository.save(order);
	}

}
