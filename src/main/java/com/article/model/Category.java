package com.article.model;

public class Category {

	private int cate_id;
	private String cate_desc;

	public Category() {
		super();
	}
	public Category(int cate_id, String cate_desc) {
		super();
		this.cate_id = cate_id;
		this.cate_desc = cate_desc;
	}
	public int getCate_id() {
		return cate_id;
	}
	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}
	public String getCate_desc() {
		return cate_desc;
	}
	public void setCate_desc(String cate_desc) {
		this.cate_desc = cate_desc;
	}

	@Override
	public String toString() {
		return "Category [cate_id=" + cate_id + ", cate_desc=" + cate_desc + "]";
	}
	
}
