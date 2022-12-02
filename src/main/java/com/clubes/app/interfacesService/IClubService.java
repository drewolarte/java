package com.clubes.app.interfacesService;

import java.util.List;
import java.util.Optional;

import com.clubes.app.entity.Club;


public interface IClubService {
	
	public List<Club> listar();
	public Optional<Club> listarId(int id);
	public int save(Club f);
	public void delete (int id);

}


