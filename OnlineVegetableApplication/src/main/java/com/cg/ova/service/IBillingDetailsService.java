package com.cg.ova.service;

import com.cg.ova.exception.BillIdNotFoundException;
import com.cg.ova.model.BillingDetailsModel;

public interface IBillingDetailsService {
	/* definition of addBill method for adding new bill */
	public BillingDetailsModel addBill(BillingDetailsModel bill) throws BillIdNotFoundException;
	
	/* definition of updateBill method for updating  bill */
	public BillingDetailsModel updateBill(BillingDetailsModel bill)throws BillIdNotFoundException;
	
	/* definition of viewBill method for view  bill */
    public BillingDetailsModel viewBill(Long billingId) throws BillIdNotFoundException;
	
}
