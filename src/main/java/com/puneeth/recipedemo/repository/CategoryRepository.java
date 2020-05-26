package com.puneeth.recipedemo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.puneeth.recipedemo.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

	
	Optional<Category> findByDeptName(String deptName);
}
