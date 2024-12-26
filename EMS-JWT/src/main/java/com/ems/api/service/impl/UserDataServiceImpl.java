package com.ems.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ems.api.entity.UserData;
import com.ems.api.repository.UserDataRepo;
import com.ems.api.service.UserDataService;

@Service
public class UserDataServiceImpl implements UserDataService {

	@Autowired
	private UserDataRepo userDataRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserData save(UserData user) {
		String pwd = user.getPassword();
		user.setPassword(encoder.encode(pwd));
		return userDataRepo.save(user);
	}

	@Override
	public Optional<UserData> delete(long id) {
		Optional<UserData> delUser = userDataRepo.findById(id);
		userDataRepo.deleteById(id);
		return delUser;
	}

	@Override
	public void update(long id, UserData user) {
		UserData updtUser = userDataRepo.findById(id).orElseThrow(()-> new UsernameNotFoundException("No User Found."));
		updtUser.setUsername(user.getUsername());
		updtUser.setEmail(user.getEmail());
		updtUser.setPassword(user.getPassword());
		updtUser.setRoles(user.getRoles());
	}

	@Override
	public List<UserData> getAll() {
		return userDataRepo.findAll();
	}

}
