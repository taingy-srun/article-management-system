package com.article.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.article.model.Article;
import com.article.model.filter.ArticleFilter;
import com.article.service.ArticleService;
import com.article.service.CategoryService;

@Controller
public class ArticleController {

	private ArticleService articleService;
	private CategoryService categoryService;
	private List<Article> articles;

	@Autowired
	public ArticleController(ArticleService articleService, CategoryService categoryService) {
		this.articleService = articleService;
		this.categoryService = categoryService;
	}

	@RequestMapping("/")
	public String root() {
		return "redirect:/article";
	}

	@RequestMapping(value = { "/article" }, method = RequestMethod.GET)
	public String homepage(ModelMap model, @RequestParam(name = "page", defaultValue = "1") int page) {

		articles = articleService.findAll(page);
		model.addAttribute("article", articles);
		model.addAttribute("addarticle", new Article());
		model.addAttribute("artCate", categoryService.findAll());

		int allPage = articleService.countPage();
		model.addAttribute("page", page);
		if (allPage == 0) {
			model.addAttribute("norecord", "No record!");
			model.addAttribute("hidden", "hidden");
		} else {
			pagination(model, page, allPage);
		}
		model.addAttribute("lpage", allPage);
		model.addAttribute("isSearchPage", false);
		model.addAttribute("filter", new ArticleFilter());

		return "article";
	}

	private void pagination(ModelMap model, @RequestParam(name = "page", defaultValue = "1") int page, int allPage) {
		if (allPage == 1) {
			model.addAttribute("ppage", 1);
			model.addAttribute("npage", 1);
			model.addAttribute("disablenpage", "disabled");
			model.addAttribute("disableppage", "disabled");
		} else if (page == 1) {
			model.addAttribute("ppage", page);
			model.addAttribute("npage", page + 1);
			model.addAttribute("disableppage", "disabled");
		} else if (page > 1 && page < allPage) {
			model.addAttribute("ppage", page - 1);
			model.addAttribute("npage", page + 1);

		} else if (page == allPage) {
			model.addAttribute("ppage", page - 1);
			model.addAttribute("npage", page);
			model.addAttribute("disablenpage", "disabled");
		} else {
			model.addAttribute("ppage", page - 1);
			model.addAttribute("npage", page + 1);
			model.addAttribute("disablenpage", "disabled");
		}
	}

	@RequestMapping(value = { "/article/search" }, method = RequestMethod.GET)
	public String filter(ModelMap model, @ModelAttribute("filter") ArticleFilter filter,
			@RequestParam(name = "page", defaultValue = "1") int page) {

		filter.setCate_id(filter.getCate_id());
		filter.setTitle(filter.getTitle());

		articles = articleService.findAllFilter(filter);
		model.addAttribute("article", articles);
		model.addAttribute("addarticle", new Article());
		model.addAttribute("artCate", categoryService.findAll());
		model.addAttribute("filter", filter);

		int allPageFilter = articleService.countPageFilter(filter);
		model.addAttribute("page", page);

		if (allPageFilter == 0) {
			model.addAttribute("norecord", "No record found!");
			model.addAttribute("hidden", "hidden");

		} else pagination(model, page, allPageFilter);

		model.addAttribute("fpage", 1);
		model.addAttribute("lpage", allPageFilter);
		model.addAttribute("isSearchPage", true);
		model.addAttribute("filter", filter);

		return "article";
	}

	@RequestMapping(value = { "/article/aid" })
	public String detailpage(ModelMap model, @RequestParam("id") Integer id) {
		Article article = articleService.findOne(id);
		model.addAttribute("article", article);
		return "articledetail";
	}

	@RequestMapping(value = "/article/remove")
	public String remove(@RequestParam("id") Integer id) {
		articleService.remove(id);
		return "redirect:/article";
	}

	@RequestMapping(value = "/article/add")
	public String add(ModelMap model) {
		model.addAttribute("artCate", categoryService.findAll());
		model.addAttribute("article", new Article());
		model.addAttribute("addStatus", true);
		return "addarticle";
	}

	@RequestMapping(value = "/article/save", method = RequestMethod.POST)
	public String save(@RequestParam("file") MultipartFile file, @Valid @ModelAttribute("article") Article article,
			BindingResult result, ModelMap model, HttpServletRequest request) {
		if (result.hasErrors()) {
			model.addAttribute("article", article);
			model.addAttribute("addStatus", true);
			return "addarticle";
		}
		saveFile(file, article, request);
		articleService.save(article);

		return "redirect:/article";
	}

	@PostMapping(value = "/article/update")
	public String update(@RequestParam("file") MultipartFile file,@Valid @ModelAttribute("article") Article article,
			BindingResult result, HttpServletRequest request, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("article", article);
			return "redirect:/article/edit";
		}
		saveFile(file, article, request);

		return "redirect:/article";
	}

	private void saveFile(@RequestParam("file") MultipartFile file, @ModelAttribute("article") @Valid Article article, HttpServletRequest request) {
		try {
			String realPath = request.getServletContext().getRealPath("/resources/images/");
			byte[] bytes = file.getBytes();
			Path path = Paths.get(realPath + file.getOriginalFilename());
			Files.write(path, bytes);
			article.setThumbnail("/resources/images/" + file.getOriginalFilename());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping(value = "/article/edit")
	public String edit(ModelMap model, @RequestParam("id") Integer id) {
		Article art = articleService.findOne(id);
		model.addAttribute("article", art);
		model.addAttribute("artCate", categoryService.findAll());

		return "editarticle";
	}
}