package com.article.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.article.model.Category;

@Repository
public interface CategoryRepository {

	@Select("SELECT * FROM tbcategory")
	List<Category> findAll();

	@Select("Select * from tbcategory WHERE cate_id=#{cate_id}")
	Category findOne(int cate_id);
	
	@Delete("DELETE from tbcategory WHERE cate_id=#{cate_id}")
	boolean remove(int cate_id);
	
	@Insert("INSERT into tbcategory (cate_desc) values(#{cate_desc})")
	boolean save(Category category);
	
	@Update("UPDATE tbcategory SET cate_desc=#{cate_desc} where cate_id=#{cate_id}")
	boolean update(Category category);
}
