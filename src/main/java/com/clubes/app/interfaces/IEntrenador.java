package com.clubes.app.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.clubes.app.entity.Entrenador;

@Repository
public interface IEntrenador extends CrudRepository<Entrenador, Integer> {

}
