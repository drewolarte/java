package com.clubes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubes.app.entity.Jugador;
import com.clubes.app.interfacesService.IJugadorService;
import com.clubes.app.interfaces.IJugador;

@Service
public class JugadorService implements IJugadorService {
	
	@Autowired
	private IJugador data;

	public List<Jugador> listar() {
		return (List<Jugador>)data.findAll();
	}

	public Optional<Jugador> listarId(int id) {
		return data.findById(id);
	}

	public int save(Jugador f) {
		int res = 0;
		Jugador Jugador = data.save(f);
		
		if (!Jugador.equals(null)) {
			res = 1;
		}
		
		return res;
	}

	public void delete(int id) {
		data.deleteById(id);
	}

}

