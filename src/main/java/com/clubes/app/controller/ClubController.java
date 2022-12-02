package com.clubes.app.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.clubes.app.entity.Club;
import com.clubes.app.interfacesService.IClubService;
import com.clubes.app.entity.Asociacion;
import com.clubes.app.interfacesService.IAsociacionService;
import com.clubes.app.entity.Competicion;
import com.clubes.app.interfacesService.ICompeticionService;
import com.clubes.app.entity.Entrenador;
import com.clubes.app.interfacesService.IEntrenadorService;
import com.clubes.app.entity.Jugador;
import com.clubes.app.interfacesService.IJugadorService;

@Controller
@RequestMapping("/admins")
public class ClubController {
	
	@Autowired
	private IClubService service;
	
	@Autowired
	private IAsociacionService serviceAsociacion;
	
	@Autowired
	private ICompeticionService serviceCompeticion;
	
	@Autowired
	private IEntrenadorService serviceEntrenador;
	
	@Autowired
	private IJugadorService serviceJugador;
	
	@GetMapping("/listarClub")
	public String listar(Model model) {
		List<Club> club =  service.listar();
		model.addAttribute("club", club);
		model.addAttribute("titulo", "Listar Clubs");
		
		return "club/listarClub";
	}
	
	@GetMapping("/agregarClub")
	public String crear(Model model) {
		List<Asociacion> asociacion =  serviceAsociacion.listar();
		model.addAttribute("asociacion", asociacion);
		
		List<Competicion> competicion =  serviceCompeticion.listar();
		model.addAttribute("competicion", competicion);
		
		List<Entrenador> entrenador =  serviceEntrenador.listar();
		model.addAttribute("entrenador", entrenador);
		
		List<Jugador> jugador =  serviceJugador.listar();
		model.addAttribute("jugador", jugador);
		
		model.addAttribute("club", new Club());
		model.addAttribute("titulo", "Crear Club");
		
		return "club/agregarClub";
	}
	
	@PostMapping("/saveClub")
	public String save(@Validated Club f, Model model, BindingResult result, @RequestParam("file") MultipartFile foto,SessionStatus status) {

		if (result.hasErrors())
		{
			
			return "club/agregarClub";
		}
		if (!foto.isEmpty()) {
				
				Path directorioRecursos = Paths.get("src//main//resources//static//uploads");
				String rootPath = directorioRecursos.toFile().getAbsolutePath();

				try {

					byte[] bytes = foto.getBytes();
					Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
					Files.write(rutaCompleta, bytes);
					

					f.setFoto(foto.getOriginalFilename());

				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		service.save(f);
		return "redirect:/admins/listarClub";
	}
	
	@GetMapping("/actualizarClub/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Club>club = service.listarId(id);
		model.addAttribute("club", club);
		
		List<Asociacion> asociacion =  serviceAsociacion.listar();
		model.addAttribute("asociacion", asociacion);
		
		List<Competicion> competicion =  serviceCompeticion.listar();
		model.addAttribute("competicion", competicion);
		
		List<Entrenador> entrenador =  serviceEntrenador.listar();
		model.addAttribute("entrenador", entrenador);
		
		List<Jugador> jugador =  serviceJugador.listar();
		model.addAttribute("jugador", jugador);
		
		model.addAttribute("titulo", "Editar Club");
		
		return "club/actualizarClub";
	}
	
	@GetMapping("/eliminarClub/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/admins/listarClub"; // /Admin/listar
	}

}

