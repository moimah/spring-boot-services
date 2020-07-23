package com.moimah.db;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.moimah.model.Order;

/**
 * Interface with JPA methods
 * Implements custom methodss
 * @author moimah
 *
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

	/**
	 * Custom method to get the last shopping cart
	 * @param id
	 * @return
	 */
	@Query(value = "SELECT  * FROM `order` WHERE user_id = :userId AND status = 'shopping' ORDER BY id DESC LIMIT 1", nativeQuery = true)
	Order findLastShoppingOrder(@Param("userId") int id);

}
