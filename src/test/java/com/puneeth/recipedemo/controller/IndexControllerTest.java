package com.puneeth.recipedemo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.puneeth.recipedemo.model.Recipe;
import com.puneeth.recipedemo.service.RecipeServiceImpl;

public class IndexControllerTest {

	IndexController indexController;

	@Mock
	RecipeServiceImpl recipeServiceImpl;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		indexController = new IndexController();
		indexController.recipeServiceImpl = recipeServiceImpl;
	}

	@Test
	public void testMockMVC() throws Exception {
		MockMvc mockMVC = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMVC.perform(get("/recipes")).andExpect(status().isOk());
	}

	@Test
	public void getRecipes() {

		List<Recipe> recipeMock = new ArrayList<>();
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		recipeMock.add(recipe);
		// ArgumentCaptor<Set<Recipe>> argCaptor = ArgumentCaptor.forClass(Set.class);
		when(recipeServiceImpl.getRecipeList()).thenReturn(recipeMock);
		assertEquals(recipeServiceImpl.getRecipeList(), recipeMock);
		verify(recipeServiceImpl, times(1)).getRecipeList();
		/*
		 * Set<Recipe> setInController = argCaptor.getValue(); assertEquals(1,
		 * setInController.size());
		 */
	}

}
