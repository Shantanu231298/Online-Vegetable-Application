package com.cg.ova.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ova.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	//method to check whether a user id exists	
     boolean existsByUserId(Long userId);

    //method to find user by user id
     User findByUserId(Long userId);

}
