package com.article.service.implementation;

import java.util.List;

import com.article.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.article.model.Category;
import com.article.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryService {

	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImp(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findOne(int cate_id) {
		return categoryRepository.findOne(cate_id);
	}

	@Override
	public boolean remove(int cate_id) {
		return categoryRepository.remove(cate_id);
	}

	@Override
	public boolean save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public boolean update(Category category) {
		return categoryRepository.update(category);
	}
	
}
