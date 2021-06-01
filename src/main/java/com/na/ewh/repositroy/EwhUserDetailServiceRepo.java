package com.na.ewh.repositroy;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.na.ewh.model.UserInfo;

@Repository
public interface EwhUserDetailServiceRepo extends CrudRepository<UserInfo, Integer> {
	Optional<UserInfo> findByUserName(String userName);
}