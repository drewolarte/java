package com.clubes.app.interfacesService;

import java.util.List;
import java.util.Optional;

import com.clubes.app.entity.Asociacion;


public interface IAsociacionService {
	
	public List<Asociacion> listar();
	public Optional<Asociacion> listarId(int id);
	public int save(Asociacion f);
	public void delete (int id);

}
