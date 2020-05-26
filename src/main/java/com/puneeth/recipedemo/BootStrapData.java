package com.puneeth.recipedemo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.puneeth.recipedemo.model.Category;
import com.puneeth.recipedemo.model.Difficulty;
import com.puneeth.recipedemo.model.Ingredient;
import com.puneeth.recipedemo.model.Notes;
import com.puneeth.recipedemo.model.Recipe;
import com.puneeth.recipedemo.model.UnitOfMeasure;
import com.puneeth.recipedemo.repository.CategoryRepository;
import com.puneeth.recipedemo.repository.RecipeRepository;
import com.puneeth.recipedemo.repository.UnitOfMeasureRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BootStrapData implements CommandLineRunner {

	@Autowired
	RecipeRepository recipeRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;

	@Override
	public void run(String... args) throws Exception {

		log.debug("Creating Bootstap Data....");
		UnitOfMeasure teaSpoon = unitOfMeasureRepository.findByUom("Teaspoon").get();
		UnitOfMeasure tableSpoon = unitOfMeasureRepository.findByUom("Tablespoon").get();
		UnitOfMeasure cup = unitOfMeasureRepository.findByUom("Cup").get();
		UnitOfMeasure pinch = unitOfMeasureRepository.findByUom("Pinch").get();
		UnitOfMeasure ounce = unitOfMeasureRepository.findByUom("Ounce").get();

		Recipe guac = new Recipe();
		guac.setDescription("Guacamole Recipe");
		guac.setPrepTime(10);
		guac.setCookTime(5);
		guac.setDifficulty(Difficulty.EASY);
		guac.setDirections("Prepare all things Ingredients and mix them");

		Notes guacNotes = new Notes();
		guacNotes.setNotes("You'll find preperation notes here");
		guac.setNotes(guacNotes);

		guac.getIngredients().add(new Ingredient(teaSpoon, guac, "ripe avacados", new BigDecimal(2)));
		guac.getIngredients().add(new Ingredient(tableSpoon, guac, "salt", new BigDecimal(2)));
		guac.getIngredients().add(new Ingredient(ounce, guac, "lime juice", new BigDecimal(1)));
		guac.getIngredients().add(new Ingredient(cup, guac, "onion", new BigDecimal(2)));

		Category american = categoryRepository.findByDeptName("American").get();
		guac.getCategories().add(american);
		Category mexican = categoryRepository.findByDeptName("Mexican").get();
		guac.getCategories().add(mexican);

		recipeRepository.save(guac);

		log.debug("Loading Data succesful..." + recipeRepository.findById(1L).get().getDescription());

	}

}
