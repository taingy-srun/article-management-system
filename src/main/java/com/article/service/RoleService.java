package com.article.service;

import java.util.List;

import com.article.model.Role;

public interface RoleService {
	List<Role> findAll();
	Role findOne(int role_id);
	boolean remove(int role_id);
	boolean save(Role role);
	boolean update(Role role);
}
