package com.clubes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubes.app.entity.Asociacion;
import com.clubes.app.interfacesService.IAsociacionService;
import com.clubes.app.interfaces.IAsociacion;

@Service
public class AsociacionService implements IAsociacionService {
	
	@Autowired
	private IAsociacion data;

	public List<Asociacion> listar() {
		return (List<Asociacion>)data.findAll();
	}

	public Optional<Asociacion> listarId(int id) {
		return data.findById(id);
	}

	public int save(Asociacion f) {
		int res = 0;
		Asociacion Asociacion = data.save(f);
		
		if (!Asociacion.equals(null)) {
			res = 1;
		}
		
		return res;
	}

	public void delete(int id) {
		data.deleteById(id);
	}

}
