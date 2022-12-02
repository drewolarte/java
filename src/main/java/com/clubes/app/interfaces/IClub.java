package com.clubes.app.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.clubes.app.entity.Club;

@Repository
public interface IClub extends CrudRepository<Club, Integer> {

}
