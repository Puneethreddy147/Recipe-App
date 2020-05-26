package com.puneeth.recipedemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String deptName;

	@ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
	private Set<Recipe> recipes = new HashSet<>();

}
