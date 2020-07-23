package com.moimah.db;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.moimah.model.Detail;



/**
 * Interface with JPA methods
 * Implements custom methodss
 * @author moimah
 *
 */
public interface DetailRepository extends JpaRepository<Detail, Long> {

	/**
	 * Custom method to get a list of details by orderId
	 * @param id
	 * @return
	 */
	@Query(value = "SELECT  * FROM `detail` WHERE order_id = :orderId", nativeQuery = true)
	List<Detail> findByOrderId(@Param("orderId") int id);
	
	/**
	 * Custom method to delete all details vinculates to an order_id
	 * @param id
	 */
	@Modifying
	@Query(value = "DELETE FROM detail WHERE order_id = 1", nativeQuery = true)
	void deleteByOrderId(@Param("id") int id);
	
	
	

}
