package com.cg.ova.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ova.entity.BillingDetails;

@Repository
public interface IBillingDetailsRepository extends JpaRepository<BillingDetails, Long> {
	//method to check whether a billing id exists
	boolean existsBybillingId(Long billingId);
	
	//method to find bill by billing id
	BillingDetails findByBillingId(Long billingId);

}
