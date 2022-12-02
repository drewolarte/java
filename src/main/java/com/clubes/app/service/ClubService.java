package com.clubes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubes.app.entity.Club;
import com.clubes.app.interfacesService.IClubService;
import com.clubes.app.interfaces.IClub;

@Service
public class ClubService implements IClubService {
	
	@Autowired
	private IClub data;

	public List<Club> listar() {
		return (List<Club>)data.findAll();
	}

	public Optional<Club> listarId(int id) {
		return data.findById(id);
	}

	public int save(Club f) {
		int res = 0;
		Club Club = data.save(f);
		
		if (!Club.equals(null)) {
			res = 1;
		}
		
		return res;
	}

	public void delete(int id) {
		data.deleteById(id);
	}

}


