package com.moimah.db;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.moimah.model.Delivery;


/**
 * Interface with JPA methods
 * Implements custom methodss
 * @author moimah
 *
 */
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
	
    /**
     * Custom method to make a query finding deliveries by userId
     * @param id
     * @return
     */
	@Query(value = "SELECT * FROM delivery WHERE order_id IN ( SELECT id FROM `order` WHERE status != 'shopping' AND user_id = :userId )", nativeQuery = true)
	List<Delivery> findDeliveriesByUserId(@Param("userId") int id);
	
	
}
