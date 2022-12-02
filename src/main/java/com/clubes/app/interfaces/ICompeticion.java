package com.clubes.app.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.clubes.app.entity.Competicion;

@Repository
public interface ICompeticion extends CrudRepository<Competicion, Integer> {

}
