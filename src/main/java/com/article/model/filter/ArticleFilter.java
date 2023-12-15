package com.article.model.filter;

public class ArticleFilter {

	private Integer cate_id;
	private String title;
	private Integer page;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getCate_id() {
		return cate_id;
	}
	public void setCate_id(Integer cate_id) {
		this.cate_id = cate_id;
	}
	
	public ArticleFilter(Integer cate_id, String title, Integer page) {
		super();
		this.cate_id = cate_id;
		this.title = title;
		this.page = page;
	}
	public ArticleFilter() {}

	@Override
	public String toString() {
		return "ArticleFilter [cate_id=" + cate_id + ", title=" + title + ", page=" + page + "]";
	}

}
