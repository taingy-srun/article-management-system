package com.article.repository.provider;

import org.apache.ibatis.jdbc.SQL;

import com.article.model.filter.ArticleFilter;

public class ArticleProvider {

	public String findAll() {
		return new SQL() {
			{
				SELECT("a.*, c.cate_desc");
				FROM("tbarticle a");
				INNER_JOIN("tbcategory c ON a.cate_id = c.cate_id");
				ORDER_BY("id desc LIMIT 10 OFFSET (#{page}-1)*10");
			}
		}.toString();
	}

	public String findAllFilter(ArticleFilter filter) {
		return new SQL() {
			{
				SELECT("a.*, c.cate_desc");
				FROM("tbarticle a");
				INNER_JOIN("tbcategory c ON a.cate_id = c.cate_id");
				if (filter.getCate_id()>0) {
					WHERE("c.cate_id = #{cate_id}");
				}
				if (filter.getTitle() != null) {
					WHERE("a.title ILIKE #{title} || '%'");
				}
				ORDER_BY("id desc LIMIT 10 OFFSET (#{page}-1)*10");
			}
		}.toString();
	}

	public String countPageFilter(ArticleFilter filter) {
		return new SQL() {
			{
				SELECT("count(a.id)");
				FROM("tbarticle a");
				INNER_JOIN("tbcategory c ON a.cate_id = c.cate_id");
				if (filter.getCate_id()>0) {
					WHERE("c.cate_id = #{cate_id}");
				}
				if (filter.getTitle() != null) {
					WHERE("a.title ILIKE #{title} || '%'");
				}
			}
		}.toString();
	}
}
