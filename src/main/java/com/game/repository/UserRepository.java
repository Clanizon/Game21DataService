package com.game.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.game.model.user.User;



public interface UserRepository extends CrudRepository<User, Long>{
	  
	  Optional<User> findByUserId(String userId);
	  
	   User findByUserIdAndUserPassword(String userId,String userPassword);
	}
