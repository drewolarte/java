package com.clubes.app.interfacesService;

import java.util.List;
import java.util.Optional;

import com.clubes.app.entity.Entrenador;


public interface IEntrenadorService {
	
	public List<Entrenador> listar();
	public Optional<Entrenador> listarId(int id);
	public int save(Entrenador f);
	public void delete (int id);

}

