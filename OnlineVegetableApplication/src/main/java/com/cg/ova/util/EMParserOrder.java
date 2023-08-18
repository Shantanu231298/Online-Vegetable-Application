package com.cg.ova.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ova.dao.IOrderRepository;
import com.cg.ova.entity.Order;
import com.cg.ova.model.OrderModel;




@Service
public class EMParserOrder {
	@Autowired
	private IOrderRepository orderDAO;
	
	@Autowired
	private EMParserCustomer customerParser;
	

	
	public EMParserOrder(){
		this.customerParser=new EMParserCustomer();
	}
	
	public EMParserOrder(IOrderRepository orderDAO) {
		super();
		this.orderDAO = orderDAO;
		this.customerParser=new EMParserCustomer();
	}

	//convert order entity to order model
     public Order parse(OrderModel source) {
		return source==null?null:
			new Order (source.getOrderNo(),
					customerParser.parse(source.getCustomer()),
					source.getTotalAmount(),
					source.getOrderDate(),
					source.getStatus()
					);
	}

	//convert order model to order entity
	public OrderModel  parse(Order source) {
		return source==null?null:
			new OrderModel(source.getOrderNo(),
					customerParser.parse(source.getCustomers()),
					
					source.getTotalAmount(),
					source.getOrderDate(),
					source.getStatus()
					
					);
	}

}
