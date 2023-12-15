package com.article.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.article.model.Role;

@Repository
public interface RoleRepository {

	@Select("SELECT * FROM tbrole")
	List<Role> findAll();

	@Select("Select * from tbrole WHERE role_id=#{role_id}")
	Role findOne(int role_id);
	
	@Delete("DELETE from tbrole WHERE role_id=#{role_id}")
	boolean remove(int role_id);
	
	@Insert("INSERT into tbrole (role_desc) values(#{role_desc})")
	boolean save(Role role);
	
	@Update("UPDATE tbrole SET role_desc=#{role_desc} where role_id=#{role_id}")
	boolean update(Role role);
}
