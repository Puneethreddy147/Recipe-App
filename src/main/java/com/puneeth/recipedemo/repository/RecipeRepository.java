package com.puneeth.recipedemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.puneeth.recipedemo.model.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	
	

}
