package com.article.service;

import java.util.List;

import com.article.model.Article;
import com.article.model.filter.ArticleFilter;

public interface ArticleService {
	List<Article> findAll(int page);
	Article findOne(int id);
	boolean remove(int id);
	boolean save(Article article);
	boolean update(Article article);
	int countPage();
	List<Article> findAllFilter(ArticleFilter filter);
	int countPageFilter(ArticleFilter filter);
}
