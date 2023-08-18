package com.cg.ova.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ova.entity.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {
	
}
