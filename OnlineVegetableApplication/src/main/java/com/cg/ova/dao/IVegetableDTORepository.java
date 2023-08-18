package com.cg.ova.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ova.entity.VegetableDTO;

@Repository
public interface IVegetableDTORepository extends JpaRepository<VegetableDTO, Long>{
   
	//method to find vegetable by id
	VegetableDTO findByVegId(Long vegId);
	
	//method to check whether a veg category exists
	boolean existsByType(String type);
	
	//method to find vegetable by category
	List<VegetableDTO> findByType(String type);

}
