package com.ems.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.api.entity.UserData;

@Repository
public interface UserDataRepo extends JpaRepository<UserData, Long> {
	
	Optional<UserData> findByUsername(String username);

}
