package com.clubes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubes.app.entity.Entrenador;
import com.clubes.app.interfacesService.IEntrenadorService;
import com.clubes.app.interfaces.IEntrenador;

@Service
public class EntrenadorService implements IEntrenadorService {
	
	@Autowired
	private IEntrenador data;

	public List<Entrenador> listar() {
		return (List<Entrenador>)data.findAll();
	}

	public Optional<Entrenador> listarId(int id) {
		return data.findById(id);
	}

	public int save(Entrenador f) {
		int res = 0;
		Entrenador Entrenador = data.save(f);
		
		if (!Entrenador.equals(null)) {
			res = 1;
		}
		
		return res;
	}

	public void delete(int id) {
		data.deleteById(id);
	}

}

