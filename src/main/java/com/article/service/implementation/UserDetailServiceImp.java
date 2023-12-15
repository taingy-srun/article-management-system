package com.article.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.article.model.User;
import com.article.repository.UserRepository;

@Service
public class UserDetailServiceImp implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.loadUserByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException("-> User not found!");		

		return user;
	}

}