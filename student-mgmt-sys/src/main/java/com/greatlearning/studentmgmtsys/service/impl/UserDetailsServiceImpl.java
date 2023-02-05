package com.greatlearning.studentmgmtsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.studentmgmtsys.model.User;
import com.greatlearning.studentmgmtsys.repository.UserRepository;
import com.greatlearning.studentmgmtsys.securityconfig.SecurityDetails;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);

//	        if (user == null) {
//	            throw new UsernameNotFoundException("Could not find user");
//	        }
//	         
		return new SecurityDetails(user);
	}

}