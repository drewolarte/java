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

import com.clubes.app.entity.Entrenador;
import com.clubes.app.interfacesService.IEntrenadorService;

@Controller
@RequestMapping("/admins")
public class EntrenadorController {
	
	@Autowired
	private IEntrenadorService service;
	
	@GetMapping("/listarEntrenador")
	public String listar(Model model) {
		List<Entrenador> entrenador =  service.listar();
		model.addAttribute("entrenador", entrenador);
		model.addAttribute("titulo", "Listar Entrenadors");
		
		return "entrenador/listarEntrenador";
	}
	
	@GetMapping("/agregarEntrenador")
	public String crear(Model model) {
		model.addAttribute("entrenador", new Entrenador());
		model.addAttribute("titulo", "Crear Entrenador");
		
		return "entrenador/agregarEntrenador";
	}
	
	@PostMapping("/saveEntrenador")
	public String save(@Validated Entrenador f, Model model, BindingResult result, @RequestParam("file") MultipartFile foto,SessionStatus status) {
		
		if (result.hasErrors())
		{
			
			return "entrenador/agregarEntrenador";
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
		return "redirect:/admins/listarEntrenador";
	}
	
	@GetMapping("/actualizarEntrenador/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Entrenador>entrenador = service.listarId(id);
		model.addAttribute("entrenador", entrenador);
		model.addAttribute("titulo", "Editar Entrenador");
		
		return "entrenador/actualizarEntrenador";
	}
	
	@GetMapping("/eliminarEntrenador/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/admins/listarEntrenador"; // /Admin/listar
	}

}
