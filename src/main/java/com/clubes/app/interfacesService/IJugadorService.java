package com.clubes.app.interfacesService;

import java.util.List;
import java.util.Optional;

import com.clubes.app.entity.Jugador;


public interface IJugadorService {
	
	public List<Jugador> listar();
	public Optional<Jugador> listarId(int id);
	public int save(Jugador f);
	public void delete (int id);

}


