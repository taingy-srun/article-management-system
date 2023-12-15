package com.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.article.model.Category;
import com.article.service.CategoryService;

@Controller
public class CategoryController {
	
	private final CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@RequestMapping(value="/category")
	public String category(ModelMap model){
		List<Category> categories = categoryService.findAll();
		model.addAttribute("category", categories);

		return "category";
	}
	
	
}
