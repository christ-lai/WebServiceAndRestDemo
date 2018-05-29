package com.celnet.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.celnet.entity.User;
public interface UserRepository extends JpaRepository<User,String>{
	
}
