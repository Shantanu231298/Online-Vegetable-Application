package com.cg.ova.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ova.entity.CartDTO;

@Repository
public interface ICartDTORepository extends JpaRepository<CartDTO, Long> {

}
