package com.cg.ova.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ova.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long>{
	
}
