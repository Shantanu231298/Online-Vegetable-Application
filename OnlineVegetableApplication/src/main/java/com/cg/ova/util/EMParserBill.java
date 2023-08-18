package com.cg.ova.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ova.dao.IBillingDetailsRepository;
import com.cg.ova.entity.BillingDetails;
import com.cg.ova.model.BillingDetailsModel;

@Service
public class EMParserBill {
	@Autowired
	private IBillingDetailsRepository billDAO;
	
	@Autowired
	private EMParserOrder orderParser;
	
	public EMParserBill() {
		this.orderParser=new EMParserOrder();
		}
	
    public EMParserBill(IBillingDetailsRepository billDAO) {
		super();
		this.billDAO = billDAO;
		this.orderParser=new EMParserOrder();
	}

  //convert bill model to bill entity
	public BillingDetailsModel parse(BillingDetails source) {
		return source==null ? null:
			new BillingDetailsModel (source.getBillingId(),
					source.getTransactionMode(),
					source.getTransactionDate(),
					source.getTranactionStatus(),
					orderParser.parse(source.getOrder())
					);
	}
	
	 //convert bill entity to bill model
	public BillingDetails parse(BillingDetailsModel source) {
		return source==null ? null:
			new BillingDetails (source.getBillingId(),
					source.getTransactionMode(),
					source.getTransactionDate(),
					source.getTranactionStatus(),
					orderParser.parse(source.getOrder())
					
					);
	}
}
