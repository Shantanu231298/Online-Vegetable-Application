package com.cg.ova.service;

import com.cg.ova.exception.AdminIdNotFoundException;
import com.cg.ova.model.AdminModel;

public interface IAdminService {
	/* definition of addAdmin method for adding new admin */
	public AdminModel addAdmin(AdminModel adminModel) throws AdminIdNotFoundException ;
	
	/* definition of updateAdmin method for adding  admin */
	public AdminModel updateAdminDetails(AdminModel adminModel) throws AdminIdNotFoundException;
	
	/* definition of removeAdmin method for remove  admin */
	public boolean removeAdmin(Long adminId) throws AdminIdNotFoundException;
	
	/* definition of viewAdmin method for view admin */
	public AdminModel viewAdmin(Long adminId) throws AdminIdNotFoundException;


}
