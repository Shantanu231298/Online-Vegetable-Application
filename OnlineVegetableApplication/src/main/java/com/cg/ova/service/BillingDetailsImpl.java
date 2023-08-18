package com.cg.ova.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ova.dao.IBillingDetailsRepository;
import com.cg.ova.entity.BillingDetails;
import com.cg.ova.exception.BillIdNotFoundException;
import com.cg.ova.model.BillingDetailsModel;
import com.cg.ova.util.EMParserBill;


@Service
public class BillingDetailsImpl implements IBillingDetailsService {

	
	@Autowired
	private IBillingDetailsRepository billingDAO;
	@Autowired
	private EMParserBill parser;
	
	public BillingDetailsImpl() {
		this.parser = new EMParserBill();
	}
	
	public BillingDetailsImpl(IBillingDetailsRepository billingDAO) {
		super();
		this.billingDAO = billingDAO;
		this.parser = new EMParserBill();
	}

	 /* Implementation of addBill to add Bill details */
    @Transactional
	@Override
	public BillingDetailsModel addBill(BillingDetailsModel bill) throws BillIdNotFoundException {
    	if (bill != null) {
			if (billingDAO.existsById(bill.getBillingId())) {
				throw new BillIdNotFoundException("Bill with this id already exists");
			}

			bill = parser.parse(billingDAO.save(parser.parse(bill)));
		}

		return bill;
	}


    
    /* Implementation of updateBill to update Bill */
    @Transactional
	@Override
	public BillingDetailsModel updateBill(BillingDetailsModel bill) throws BillIdNotFoundException {
    	BillingDetails oldBill = billingDAO.findById(bill.getBillingId()).orElse(null);
		if (oldBill == null) {
			throw new BillIdNotFoundException("no bill with id #" + bill.getBillingId() + " present");
		} else {
			bill = parser.parse(billingDAO.save(parser.parse(bill)));
		}
		return bill;
	}
    
    /* Implementation of viewBill to view Bill by billing id */
	@Transactional
	@Override
	public BillingDetailsModel viewBill(Long billingId) throws BillIdNotFoundException {
		BillingDetails oldBill = billingDAO.findById(billingId).orElse(null);
    	System.out.println(oldBill);
		if (oldBill == null) {
			throw new BillIdNotFoundException("no bill with id #" + billingId + " present");
		}
		return parser.parse(billingDAO.findById(billingId).orElse(null));
	}


}
