package com.article.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.article.model.Article;
import com.article.model.filter.ArticleFilter;
import com.article.repository.provider.ArticleProvider;

@Repository
public interface MybatisArticleRepository {

	@SelectProvider(method="findAll", type=ArticleProvider.class)
	@Results({
		@Result(property="category.cate_id", column="cate_id"),
		@Result(property="category.cate_desc", column="cate_desc")
	})
	List<Article> findAll(@Param("page") int page);
	
	@Select("Select count(id) from tbarticle")
	int countRecord();

	@Select("SELECT a.*, c.cate_desc FROM tbarticle a INNER JOIN tbcategory c ON a.cate_id = c.cate_id WHERE id=#{id}")
	@Results({
		@Result(property="category.cate_id", column="cate_id"),
		@Result(property="category.cate_desc", column="cate_desc")
	})
	Article findOne(int id);
	
	@Delete("DELETE from tbarticle where id=#{id}")
	boolean remove(int id);
	
	@Insert("INSERT into tbarticle (title, description, thumbnail,cate_id) values(#{title}, #{description}, #{thumbnail},#{category.cate_id})")
	boolean save(Article article);
	
	@Update("UPDATE tbarticle SET title=#{title}, description=#{description}, thumbnail=#{thumbnail}, cate_id=#{category.cate_id} where id=#{id}")
	boolean update(Article article);
	
	@SelectProvider(method="findAllFilter",type=ArticleProvider.class)
	@Results({
		@Result(property="category.cate_id", column="cate_id"),
		@Result(property="category.cate_desc", column="cate_desc")
	})
	List<Article> findAllFilter(ArticleFilter filter);
	
	@SelectProvider(method="countPageFilter",type=ArticleProvider.class)
	int countPageFilter(ArticleFilter filter);
	
	
}
