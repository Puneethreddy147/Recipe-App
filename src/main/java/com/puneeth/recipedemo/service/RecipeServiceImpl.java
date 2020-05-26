package com.puneeth.recipedemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puneeth.recipedemo.model.Recipe;
import com.puneeth.recipedemo.repository.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	RecipeRepository recipeRepository;

	@Override
	public List<Recipe> getRecipeList() {
		log.info("Inside RecipeService Impl");
		List<Recipe> val = new ArrayList<>();
		Iterable<Recipe> recipes = recipeRepository.findAll();
		recipes.forEach(r -> {
			System.out.println("Recipe Id :" + r.getId());
			val.add(r);
		});
		return val;
	}

}
