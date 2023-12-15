package com.article.model;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority{
	private static final long serialVersionUID = 1L;
	private int role_id;
	private String role_desc;
	
	public Role() {}
	public Role(int role_id, String role_desc) {
		super();
		this.role_id = role_id;
		this.role_desc = role_desc;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_desc=" + role_desc + "]";
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_desc() {
		return role_desc;
	}
	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	@Override
	public String getAuthority() {
		return "ROLE_" + role_desc;
}
}
