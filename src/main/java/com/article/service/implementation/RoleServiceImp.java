package com.article.service.implementation;

import java.util.List;

import com.article.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.article.model.Role;
import com.article.repository.RoleRepository;


@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findOne(int role_id) {
		return roleRepository.findOne(role_id);
	}

	@Override
	public boolean remove(int role_id) {
		return roleRepository.remove(role_id);
	}

	@Override
	public boolean save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public boolean update(Role role) {
		return roleRepository.update(role);
	}
	
	
	
	
}
