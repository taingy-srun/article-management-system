package com.article.repository;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.article.model.Role;
import com.article.model.User;

@Repository
public interface UserRepository {
		
		@Select("SELECT id, name ,email , password, status FROM tbuser WHERE name=#{name} ")
		@Results({
			@Result(property="id", column="id"),
			@Result(property="role", column="id", many=@Many(select="findRoleByUserId"))
		})
		User loadUserByUsername(String username);

		@Select("Select r.role_id, r.role_desc From tbrole r Inner Join tbuser_role ur on r.role_id=ur.role_id Where ur.user_id=#{id}")
		List<Role> findRoleByUserId(int id);
}
