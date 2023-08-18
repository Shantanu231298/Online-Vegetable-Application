package com.cg.ova.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ova.dao.IAdminRepository;
import com.cg.ova.entity.Admin;
import com.cg.ova.model.AdminModel;

@Service
public class EMParserAdmin {
	
	@Autowired
	private IAdminRepository adminDAO;
	
	public EMParserAdmin() {
		this.adminDAO= adminDAO;
	}
	
 public EMParserAdmin(IAdminRepository adminDAO) {
		super();
		this.adminDAO = adminDAO;
	}



	//convert admin entity to admin model
	 public Admin parse(AdminModel source) {
			return source==null?null:
				new Admin(source.getAdminId(), 
						source.getName(),
						source.getContactNumber());
		}
		
	 //convert admin model to admin entity
	 public AdminModel  parse(Admin source) {
			return source==null?null:
				new AdminModel(source.getAdminId(),
						source.getName(),
						source.getContactNumber());
						}

}
