package com.puneeth.recipedemo.repository;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.puneeth.recipedemo.model.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

	@Autowired
	UnitOfMeasureRepository uomRepo;

	@Before
	public void setUp() {

	}

	@Test
	public void findByDescription() {
		Optional<UnitOfMeasure> uomOptional = uomRepo.findByUom("Teaspoon");
		assertEquals("Teaspoon", uomOptional.get().getUom());
	}
	
	@Test
	public void findByDescriptionCup() {
		Optional<UnitOfMeasure> uomOptional = uomRepo.findByUom("Cup");
		assertEquals("Cup", uomOptional.get().getUom());
	}

}
