package com.moimah.db;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.moimah.model.Plant;

/**
 * Interface with JPA methods
 * Implements custom methodss
 * @author moimah
 *
 */
public interface PlantRepository extends JpaRepository<Plant, Long> {
	

	/**
	 * Custom method to search plants by name
	 * @param name of plant
	 * @return
	 */
	@Query(value = "SELECT * FROM plant WHERE name LIKE CONCAT('%',:name,'%')", nativeQuery = true)
	List<Plant> findPlantsByName(  @Param("name") String name);
	
	
	/**
	 * Custom method to search plants by price range
	 * @param min price
	 * @param max price
	 * @return
	 */
	@Query(value = "SELECT * FROM plant WHERE price BETWEEN :min AND :max", nativeQuery = true)
	List<Plant> findPlantsByPrice(  @Param("min") double min, @Param("max") double max );
	
	
	/**
	 * Custo method to search plants by range 0 and max value
	 * @param name of plant
	 * @param max price
	 * @return
	 */
	@Query(value = "SELECT * FROM plant WHERE price BETWEEN 0 AND :max AND name LIKE CONCAT('%',:name,'%')", nativeQuery = true)
	List<Plant> findPlantsByNameAndMax(  @Param("name") String name, @Param("max") double max);
	
	
	/**
	 * Custom method to search plants with a filer by price range and plant name
	 * @param name of plant
	 * @param min price
	 * @param max price
	 * @return
	 */
	@Query(value = "SELECT * FROM plant WHERE price BETWEEN :min AND :max AND name LIKE CONCAT('%',:name,'%')", nativeQuery = true)
	List<Plant> findPlantsByNameAndRange(  @Param("name") String name, @Param("min") double min,  @Param("max") double max);
	
	
	
}
