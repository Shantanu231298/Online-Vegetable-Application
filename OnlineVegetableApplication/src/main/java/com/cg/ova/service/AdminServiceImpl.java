package com.cg.ova.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.cg.ova.dao.IAdminRepository;
import com.cg.ova.entity.Admin;
import com.cg.ova.exception.AdminIdNotFoundException;
import com.cg.ova.model.AdminModel;
import com.cg.ova.util.EMParserAdmin;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminRepository adminDAO;
	
	@Autowired
	private EMParserAdmin parser;
	
	public AdminServiceImpl() {
		this.parser = new EMParserAdmin();
	}
	
   public AdminServiceImpl(IAdminRepository adminDAO) {
		super();
		this.adminDAO = adminDAO;
		this.parser = new EMParserAdmin();
	}
   
   /* Implementation of addAdmin to add all the admin */
   @Transactional
   @Override
	public AdminModel addAdmin(AdminModel adminModel) throws AdminIdNotFoundException {
    	if (adminModel != null) {
			if (adminDAO.existsById(adminModel.getAdminId())) {
				throw new AdminIdNotFoundException ("admin with this id already exists");
			}

			adminModel = parser.parse(adminDAO.save(parser.parse(adminModel)));
		}

		return adminModel;
	}
	

   /* Implementation of updateAdminDetails to update all the admin */
   @Transactional
	@Override
	public AdminModel updateAdminDetails(AdminModel adminModel) throws AdminIdNotFoundException {
	   Admin oldAdmin = adminDAO.findById(adminModel.getAdminId()).orElse(null);
		if (oldAdmin == null) {
			throw new AdminIdNotFoundException("no admin with id #" + adminModel.getAdminId() + " present");
		} else {
			adminModel = parser.parse(adminDAO.save(parser.parse(adminModel)));
		}
		return adminModel;
	}
  
   /* Implementation of removeAdmin to remove all the admin by id */
   @Transactional
	@Override
	public boolean removeAdmin(Long adminId) throws AdminIdNotFoundException {
	   Admin oldAdmin = adminDAO.findById(adminId).orElse(null);
		boolean isDeleted=false;
		if (oldAdmin == null) {
			throw new AdminIdNotFoundException("Admin with id #" + adminId + " is not  present");
		} else {
			adminDAO.deleteById(adminId);
			isDeleted=true;
		}
		return isDeleted;
	}
   
   /* Implementation of viewAdmin to view  admin by id */
	@Override
	public AdminModel viewAdmin(Long adminId) throws AdminIdNotFoundException {
	   Admin oldAdmin = adminDAO.findById(adminId).orElse(null);
		if (oldAdmin == null) {
			throw new AdminIdNotFoundException("no admin with id #" + adminId + " present");
		}
		return parser.parse(adminDAO.findById(adminId).orElse(null));
	}
}
