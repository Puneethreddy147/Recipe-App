package com.puneeth.recipedemo.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure uom;
	@ManyToOne(fetch = FetchType.EAGER)
	private Recipe recipe;
	private String description;
	private BigDecimal amount;

	public Ingredient(UnitOfMeasure uom, Recipe recipe, String description, BigDecimal amount) {
		super();
		this.uom = uom;
		this.recipe = recipe;
		this.description = description;
		this.amount = amount;
	}

}
