package com.clubes.app.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.clubes.app.entity.Jugador;

@Repository
public interface IJugador extends CrudRepository<Jugador, Integer> {

}
