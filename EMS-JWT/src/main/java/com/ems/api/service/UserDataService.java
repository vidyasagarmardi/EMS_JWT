package com.ems.api.service;

import java.util.List;
import java.util.Optional;

import com.ems.api.entity.UserData;

public interface UserDataService {
	
	UserData save(UserData user);
	Optional<UserData> delete(long id);
	List<UserData> getAll();
	void update(long id, UserData user);

}
