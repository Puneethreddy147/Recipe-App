package com.puneeth.recipedemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puneeth.recipedemo.model.Category;
import com.puneeth.recipedemo.model.Recipe;
import com.puneeth.recipedemo.repository.CategoryRepository;
import com.puneeth.recipedemo.service.RecipeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class IndexController {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	RecipeService recipeServiceImpl;

	@GetMapping({ "", "/", "/index" })
	public Category getIndexPage() {
		Optional<Category> val = categoryRepository.findByDeptName("Indian");
		System.out.println("Cat Id is : " + val.get().getId());
		return val.get();
	}
	
	@GetMapping("/recipes")
	public List<Recipe> getRecipes(){
		log.info("Inside Recipe Controller....");
		return recipeServiceImpl.getRecipeList();
	}

}
