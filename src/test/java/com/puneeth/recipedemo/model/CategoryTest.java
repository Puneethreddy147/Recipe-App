package com.puneeth.recipedemo.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	Category category = null;

	@Before
	public void setUp() {
		category = new Category();
	}

	@Test
	public void getId() {
		Long idVal = 3L;
		category.setId(3L);
		assertEquals(idVal, category.getId());
	}

}
