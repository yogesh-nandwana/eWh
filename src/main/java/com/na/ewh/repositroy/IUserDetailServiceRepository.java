package com.na.ewh.repositroy;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.na.ewh.model.UserInfo;

public interface IUserDetailServiceRepository extends CrudRepository<UserInfo, Integer> {
	Optional<UserInfo> findByUserName(String userName);
}