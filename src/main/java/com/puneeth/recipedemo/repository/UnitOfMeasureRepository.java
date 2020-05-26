package com.puneeth.recipedemo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.puneeth.recipedemo.model.UnitOfMeasure;

@Repository
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

	public Optional<UnitOfMeasure> findByUom(String uom);

}
