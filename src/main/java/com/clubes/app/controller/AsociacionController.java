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

import com.clubes.app.entity.Asociacion;
import com.clubes.app.interfacesService.IAsociacionService;

@Controller
@RequestMapping("/admins")
public class AsociacionController {
	
	@Autowired
	private IAsociacionService service;
	
	@GetMapping("/listarAsociacion")
	public String listar(Model model) {
		List<Asociacion> asociacion =  service.listar();
		model.addAttribute("asociacion", asociacion);
		model.addAttribute("titulo", "Listar Asociacions");
		
		return "asociacion/listarAsociacion";
	}
	
	
	@GetMapping("/agregarAsociacion")
	public String crear(Model model) {
		model.addAttribute("asociacion", new Asociacion());
		model.addAttribute("titulo", "Crear Asociacion");
		
		return "asociacion/agregarAsociacion";
	}
	
	@PostMapping("/saveAsociacion")
	public String save(@Validated Asociacion f, Model model, BindingResult result, @RequestParam("file") MultipartFile foto,SessionStatus status) {
		
		if (result.hasErrors())
		{
			
			return "asociacion/agregarAsociacion";
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
		return "redirect:/admins/listarAsociacion";
	}
	
	@GetMapping("/actualizarAsociacion/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Asociacion>asociacion = service.listarId(id);
		model.addAttribute("asociacion", asociacion);
		model.addAttribute("titulo", "Editar Asociacion");
		
		return "asociacion/actualizarAsociacion";
	}
	
	@GetMapping("/eliminarAsociacion/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/admins/listarAsociacion"; // /Admin/listar
	}

}
