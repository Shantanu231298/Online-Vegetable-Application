package com.cg.ova.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ova.dao.IVegetableDTORepository;
import com.cg.ova.entity.VegetableDTO;
import com.cg.ova.exception.VegetableIdNotFoundException;
import com.cg.ova.model.VegetableDTOModel;
import com.cg.ova.util.EMParserVegetableDTO;

@Service
public class VegetableDTOServiceImpl implements IVegetableDTOService {

	@Autowired
	private IVegetableDTORepository vegetableDAO;
	
	@Autowired
	private EMParserVegetableDTO parser;
	
	public VegetableDTOServiceImpl() {
		this.parser = new EMParserVegetableDTO();
		
	}
	
    
	public VegetableDTOServiceImpl(IVegetableDTORepository vegetableDAO) {
		super();
		this.vegetableDAO = vegetableDAO;
		this.parser = new EMParserVegetableDTO();
	}
	
	 /* Implementation of addVegetable  to add all the veg */
	@Transactional
	@Override
	public VegetableDTOModel addVegetable(VegetableDTOModel vegetableDTOModel) throws VegetableIdNotFoundException {
		if (vegetableDTOModel != null) {
			if (vegetableDAO.existsById(vegetableDTOModel.getVegId())) {
				throw new VegetableIdNotFoundException ("vegetable with this id already exists");
			}

			vegetableDTOModel = parser.parse(vegetableDAO.save(parser.parse(vegetableDTOModel)));
		}

		return vegetableDTOModel;
	}

	
	 /* Implementation of updateVegetable  to update all the veg */
	@Transactional
	@Override
	public VegetableDTOModel updateVegetable(VegetableDTOModel vegetableDTOModel) throws VegetableIdNotFoundException {
		VegetableDTO oldVeg = vegetableDAO.findById(vegetableDTOModel.getVegId()).orElse(null);
		if (oldVeg == null) {
			throw new VegetableIdNotFoundException("no veg with id #" + vegetableDTOModel.getVegId() + " present");
		} else {
			vegetableDTOModel = parser.parse(vegetableDAO.save(parser.parse(vegetableDTOModel)));
		}
		return vegetableDTOModel;
	}
	
	 /* Implementation of removeVegetable  to remove all the veg by veg id*/
	@Transactional
	@Override
	public boolean  removeVegetable(Long vegId) throws VegetableIdNotFoundException {
		VegetableDTO oldveg = vegetableDAO.findById(vegId).orElse(null);
		boolean isDeleted=false;
		if (oldveg == null) {
			throw new VegetableIdNotFoundException("no veg with id #" + vegId + " present");
		} else {
			vegetableDAO.deleteById(vegId);
			isDeleted=true;
		}
		return isDeleted;
	}
	

	 /* Implementation of viewVegetable  to view all the veg by veg id */
	@Override
	public VegetableDTOModel viewVegetable(Long vegId) throws VegetableIdNotFoundException {
		VegetableDTO oldveg = vegetableDAO.findById(vegId).orElse(null);
    	
		if (oldveg == null) {
			throw new VegetableIdNotFoundException("no veg with id #" + vegId + " present");
		}
		return parser.parse(vegetableDAO.findById(vegId).orElse(null));
	}

	
	 /* Implementation of viewVegetableList  to view all the veg */
	@Override
	public List<VegetableDTOModel> viewVegetableList(String type) throws VegetableIdNotFoundException {
            if(type !=null) {
			
			if (!vegetableDAO.existsByType(type))
				throw new VegetableIdNotFoundException("No vegetable found for the given category");
			
		}
            return vegetableDAO.findByType(type).stream().map(parser::parse).collect(Collectors.toList());
		
	}

	


}
