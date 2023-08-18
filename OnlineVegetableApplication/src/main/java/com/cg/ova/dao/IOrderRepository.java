package com.cg.ova.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ova.entity.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
	
}
