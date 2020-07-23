package com.moimah.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.moimah.db.PlantRepository;
import com.moimah.model.Plant;


/**
 * Controller for plants
 * @author moimah
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "plants")
public class PlantController {
	
	//Image bytes
	private byte[] bytes;
	
	@Autowired
	private PlantRepository plantRepository;
	
	/**
	 * Get all plants from database
	 * @return list of plants
	 */
	@GetMapping("/get")
	public List<Plant> getPlants() {
		return plantRepository.findAll();
	}
	
	/**
	 * Get List of plants appling filters
	 * @param name name of plant
	 * @param min price min
	 * @param max price max
	 * @return
	 */
	@GetMapping("/filter/name/{name}/min/{min}/max/{max}")
	public List<Plant> getPlantsFilter(@PathVariable String name, @PathVariable double min, @PathVariable double max){
				
		if(name.length() > 0 && min == 0 && max == 0) {
			return plantRepository.findPlantsByName(name);
		}else if(name.contains("null") && max > 0) {
			return plantRepository.findPlantsByPrice(min, max);
		}else if(name.length() > 0 && min == 0 && max > 0) {
			return plantRepository.findPlantsByNameAndMax(name, max);
		}		
		else {
			return plantRepository.findPlantsByNameAndRange(name, min, max);
		}		
		
	}
	
	/**
	 * Post to create a new plant, also use the picByte to storge an image
	 * @param plant
	 * @throws IOException
	 */
	@PostMapping("/add")
	public void createPlant(@RequestBody Plant plant) throws IOException {		
	plant.setPicByte(this.bytes);
		plantRepository.save(plant);
		this.bytes = null;
	}
	
	/**
	 * Post to upload an image
	 * @param file bytes from image
	 * @throws IOException
	 */
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}
	
	/**
	 * Delete a plant by id
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = { "/{id}" })
	public Plant deletePlant(@PathVariable("id") int id) {	
		Plant plant = new Plant();
		plant.setId(id);		
		plantRepository.delete(plant);
		return plant;
	}
	
	/**
	 * Update a existing plant
	 * @param plant to update
	 * @return
	 */
	@PutMapping("/update")
	public void updatePlant(@RequestBody Plant plant) {
		plantRepository.save(plant);
	}
	
	

}