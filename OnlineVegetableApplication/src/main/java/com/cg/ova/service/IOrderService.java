package com.cg.ova.service;

import java.util.List;
import com.cg.ova.exception.OrderIdNotFoundException;
import com.cg.ova.model.OrderModel;

public interface IOrderService {
	
	/* definition of addOrder method for adding new order*/
	public OrderModel addOrder(OrderModel orderModel) throws OrderIdNotFoundException ;
	
	/* definition of updateOrder method for updating order*/
	public OrderModel updateOrder(OrderModel orderModel) throws OrderIdNotFoundException;
	
	/* definition of cancelOrder method for cancel order*/
	public boolean cancelOrder(Long orderNo) throws OrderIdNotFoundException ;
	
	/* definition of viewOrderList method for view order*/
	public OrderModel viewOrderList(Long orderNo) throws OrderIdNotFoundException ;
	
	/* definition of viewAllOrder method for view all order*/
	public List<OrderModel> viewAllOrder() throws OrderIdNotFoundException;

}
