package com.clubes.app.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.clubes.app.entity.Asociacion;

@Repository
public interface IAsociacion extends CrudRepository<Asociacion, Integer> {

}
