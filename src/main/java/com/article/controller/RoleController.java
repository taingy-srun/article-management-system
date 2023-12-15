package com.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.article.model.Role;
import com.article.service.RoleService;

@Controller
public class RoleController {
	
	private final RoleService roleService;
	
	@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@RequestMapping(value="/role")
	public String role(ModelMap model){
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);

		return "role";
	}
	
	
}
