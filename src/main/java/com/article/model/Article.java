package com.article.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Article {
	
	private int id;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String title;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String description;
	private String thumbnail;
	private Category category;
	


	public Article() {
		super();
	}
	public Article(int id, String title, String description, String thumbnail, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.thumbnail = thumbnail;
		this.category = category;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", description=" + description + ", thumbnail=" + thumbnail
				+ ", category=" + category + "]";
	}

}
