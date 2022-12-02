package com.clubes.app.interfacesService;

import java.util.List;
import java.util.Optional;

import com.clubes.app.entity.Competicion;


public interface ICompeticionService {
	
	public List<Competicion> listar();
	public Optional<Competicion> listarId(int id);
	public int save(Competicion f);
	public void delete (int id);

}

