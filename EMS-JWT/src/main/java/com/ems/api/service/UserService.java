package com.ems.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ems.api.config.UserDataUserDetails;
import com.ems.api.entity.UserData;
import com.ems.api.repository.UserDataRepo;

@Component
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserDataRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserData> user = userRepo.findByUsername(username);
		return user.map(UserDataUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"+username));
	}

}
