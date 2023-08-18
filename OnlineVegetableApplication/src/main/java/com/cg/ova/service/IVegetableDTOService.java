package com.cg.ova.service;

import java.util.List;
import com.cg.ova.exception.VegetableIdNotFoundException;
import com.cg.ova.model.VegetableDTOModel;

public interface IVegetableDTOService {
	/* definition of addVegetable method for adding new veg */
	public VegetableDTOModel addVegetable(VegetableDTOModel dto) throws VegetableIdNotFoundException;
	
	/* definition of updateVegetable method for update veg */
	public VegetableDTOModel updateVegetable(VegetableDTOModel dto) throws VegetableIdNotFoundException;
	
	/* definition of removeVegetable method for removing veg by veg id */
	public boolean removeVegetable(Long vegeId)throws VegetableIdNotFoundException;
	
	/* definition of viewVegetable method for view veg by id */
	public VegetableDTOModel viewVegetable(Long vegId) throws VegetableIdNotFoundException;
	
	/* definition of viewVegetableList method for view all veg  */
	public List<VegetableDTOModel> viewVegetableList(String type) throws VegetableIdNotFoundException;
	

}
