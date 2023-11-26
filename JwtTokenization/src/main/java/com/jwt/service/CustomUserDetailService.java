package com.jwt.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.entity.User;
import com.jwt.repositories.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{

	
	
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User Not Found"));
		return user;
	}

}
