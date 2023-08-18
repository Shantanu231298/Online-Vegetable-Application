package com.cg.ova.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ova.dao.IOrderRepository;
import com.cg.ova.entity.Order;
import com.cg.ova.exception.OrderIdNotFoundException;
import com.cg.ova.model.OrderModel;
import com.cg.ova.util.EMParserOrder;


@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepository orderDAO;
	@Autowired
	private EMParserOrder parser;
	
    public OrderServiceImpl() {
		this.parser = new EMParserOrder();
		
	}
    
	public OrderServiceImpl(IOrderRepository orderDAO) {
		super();
		this.orderDAO = orderDAO;
		this.parser = new EMParserOrder();
	}
   

   /* Implementation of addOrder  to add all the orders */
    @Transactional
    @Override
	public OrderModel addOrder(OrderModel orderModel) throws OrderIdNotFoundException {
		if (orderModel != null) {
			if (!orderDAO.existsById(orderModel.getOrderNo())) {
				throw new OrderIdNotFoundException ("order with this no already exists");
			}

			orderModel = parser.parse(orderDAO.save(parser.parse(orderModel)));
		}

		return orderModel;	
	}

   // Implementation of updatOrder to update the existing Order
    @Transactional
	@Override
	public OrderModel updateOrder(OrderModel orderModel) throws OrderIdNotFoundException {
	Order order = orderDAO.findById(orderModel.getOrderNo()).orElse(null);
	if (order == null) {
		throw new OrderIdNotFoundException("no order with id #" + orderModel.getOrderNo() + " present");
	}
	orderModel = parser.parse(orderDAO.save(parser.parse(orderModel)));
	return orderModel;
	}


    /* Implementation of cancelOrder to clear all the orders by id */
    @Transactional
	@Override
	public boolean cancelOrder(Long orderNo) throws OrderIdNotFoundException {
	Order oldOrder = orderDAO.findById(orderNo).orElse(null);
	boolean isDeleted = false;
	if (oldOrder == null) {
		throw new OrderIdNotFoundException("no order with id #" + orderNo + " present");
	} else {
		orderDAO.deleteById(orderNo);
		isDeleted = true;
	}
	return isDeleted;
		
	}
    

    /* Implementation of viewOrderList  to view all the orders by id */
    @Override
	public OrderModel viewOrderList(Long orderNo) throws OrderIdNotFoundException {
		if(orderNo !=null) {
			
			if (!orderDAO.existsById(orderNo))
				throw new OrderIdNotFoundException("No order found for the given orderNo");
			
		}
		return parser.parse(orderDAO.findById(orderNo).get());
	}
    @Override
	public List<OrderModel> viewAllOrder() throws OrderIdNotFoundException {

		return orderDAO.findAll().stream().map(parser::parse).collect(Collectors.toList());

	}

}
    

   

