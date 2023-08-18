package com.cg.ova.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ova.dao.ICartDTORepository;
import com.cg.ova.dao.IVegetableDTORepository;
import com.cg.ova.entity.CartDTO;
import com.cg.ova.entity.Customer;
import com.cg.ova.entity.VegetableDTO;
import com.cg.ova.model.CartDTOModel;
import com.cg.ova.model.VegetableDTOModel;



@Service
public class EMParserVegetableDTO {
	
	@Autowired
	private IVegetableDTORepository vegDAO;
	@Autowired
	
	
	
	public EMParserVegetableDTO() {
		
	}
	
	public EMParserVegetableDTO(IVegetableDTORepository vegDAO) {
		super();
		this.vegDAO = vegDAO;
		}

	//convert veg model to veg entity
     public VegetableDTOModel parse(VegetableDTO source) {
		return source==null?null:
			new VegetableDTOModel (source.getVegId(),
					source.getName(),
					source.getType(),
					source.getPrice(),
					source.getQuantity()
				
					
					);
	}
	
 	//convert veg entity to veg model
	public VegetableDTO parse(VegetableDTOModel source) {
		return source==null?null:
			new VegetableDTO (source.getVegId(),
					source.getName(),
					source.getType(),
					source.getPrice(),
					source.getQuantity()
				
					
					);
	}
	
public List<VegetableDTO> parse(List<VegetableDTOModel> list){
		
		List<VegetableDTO> rlist =new ArrayList<>();
		for(VegetableDTOModel model : list) {
			rlist.add(parse(model));
		}
		return rlist;
	}
	
	public List<VegetableDTOModel> parseEntity(List<VegetableDTO> list){
		
		List<VegetableDTOModel> rlist =new ArrayList<>();
		for(VegetableDTO entity : list) {
			rlist.add(parse(entity));
		}
		return rlist;
	}
	

}	



