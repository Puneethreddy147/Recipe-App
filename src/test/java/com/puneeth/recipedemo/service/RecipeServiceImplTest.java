package com.puneeth.recipedemo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.puneeth.recipedemo.model.Recipe;
import com.puneeth.recipedemo.repository.RecipeRepository;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeServiceImpl;

	@Mock
	RecipeRepository recipeRepo;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		recipeServiceImpl = new RecipeServiceImpl();
		recipeServiceImpl.recipeRepository = recipeRepo;
	}

	@Test
	public void getRecipes() {
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		List<Recipe> recipeMock = new ArrayList<>();
		recipeMock.add(recipe);
		when(recipeRepo.findAll()).thenReturn(recipeMock);
		List<Recipe> recipes = recipeServiceImpl.getRecipeList();
		assertEquals(recipes.size(), 1);
		verify(recipeRepo, times(1)).findAll();
	}

}
