package com.article.service;

import java.util.List;

import com.article.model.Category;

public interface CategoryService {
	List<Category> findAll();
	Category findOne(int cate_id);
	boolean remove(int cate_id);
	boolean save(Category category);
	boolean update(Category category);
}
