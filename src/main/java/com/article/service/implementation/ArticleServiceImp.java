package com.article.service.implementation;

import java.util.List;

import com.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.article.model.Article;
import com.article.model.filter.ArticleFilter;
import com.article.repository.MybatisArticleRepository;

@Service
public class ArticleServiceImp implements ArticleService {

	private final MybatisArticleRepository articleRepository;
	
	@Autowired
	public ArticleServiceImp(MybatisArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@Override
	public List<Article> findAll(int page) {
		return articleRepository.findAll(page);
	}

	@Override
	public Article findOne(int id) {
		return articleRepository.findOne(id);
	}

	@Override
	public boolean remove(int id) {
		return articleRepository.remove(id);
	}

	@Override
	public boolean save(Article article) {
		return articleRepository.save(article);
	}


	@Override
	public boolean update(Article article) {
		return articleRepository.update(article);
	}

	@Override
	public int countPage() {
		return (int)Math.ceil((double) this.articleRepository.countRecord()/10);
	}

	@Override
	public List<Article> findAllFilter(ArticleFilter filter) {
		return articleRepository.findAllFilter(filter);
	}

	@Override
	public int countPageFilter(ArticleFilter filter) {
		return (int)Math.ceil((double)this.articleRepository.countPageFilter(filter)/10);
	}
}
