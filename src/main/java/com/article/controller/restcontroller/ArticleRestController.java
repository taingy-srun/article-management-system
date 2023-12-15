package com.article.controller.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.article.model.Article;
import com.article.model.filter.ArticleFilter;
import com.article.repository.MybatisArticleRepository;

@RestController
public class ArticleRestController {
	
	@Autowired
	private MybatisArticleRepository mybatisArticleRepository;
	
	@GetMapping("/article/rest")
	public List<Article> findAllFilter(ArticleFilter filter){

		return mybatisArticleRepository.findAllFilter(filter);
	}

}
