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

import com.clubes.app.entity.Jugador;
import com.clubes.app.interfacesService.IJugadorService;

@Controller
@RequestMapping("/admins")
public class JugadorController {
	
	@Autowired
	private IJugadorService service;
	
	@GetMapping("/listarJugador")
	public String listar(Model model) {
		List<Jugador> jugador =  service.listar();
		model.addAttribute("jugador", jugador);
		model.addAttribute("titulo", "Listar Jugadors");
		
		return "jugador/listarJugador";
	}
	
	@GetMapping("/agregarJugador")
	public String crear(Model model) {
		model.addAttribute("jugador", new Jugador());
		model.addAttribute("titulo", "Crear Jugador");
		
		return "jugador/agregarJugador";
	}
	
	@PostMapping("/saveJugador")
	public String save(@Validated Jugador f, Model model, BindingResult result, @RequestParam("file") MultipartFile foto,SessionStatus status) {
		
		if (result.hasErrors())
		{
			
			return "jugador/agregarJugador";
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
		return "redirect:/admins/listarJugador";
	}
	
	@GetMapping("/actualizarJugador/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Jugador>jugador = service.listarId(id);
		model.addAttribute("jugador", jugador);
		model.addAttribute("titulo", "Editar Jugador");
		
		return "jugador/actualizarJugador";
	}
	
	@GetMapping("/eliminarJugador/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/admins/listarJugador"; // /Admin/listar
	}

}

