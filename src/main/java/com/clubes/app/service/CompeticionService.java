package com.clubes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubes.app.entity.Competicion;
import com.clubes.app.interfacesService.ICompeticionService;
import com.clubes.app.interfaces.ICompeticion;

@Service
public class CompeticionService implements ICompeticionService {
	
	@Autowired
	private ICompeticion data;

	public List<Competicion> listar() {
		return (List<Competicion>)data.findAll();
	}

	public Optional<Competicion> listarId(int id) {
		return data.findById(id);
	}

	public int save(Competicion f) {
		int res = 0;
		Competicion Competicion = data.save(f);
		
		if (!Competicion.equals(null)) {
			res = 1;
		}
		
		return res;
	}

	public void delete(int id) {
		data.deleteById(id);
	}

}

