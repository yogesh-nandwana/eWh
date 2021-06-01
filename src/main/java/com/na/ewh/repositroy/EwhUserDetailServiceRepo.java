package com.na.ewh.repositroy;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.na.ewh.model.User;

@Repository
public interface EwhUserDetailServiceRepo extends CrudRepository<User, Integer> {
	Optional<User> findByUserName(String userName);
}