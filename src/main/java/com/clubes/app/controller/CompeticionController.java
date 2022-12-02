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

import com.clubes.app.entity.Competicion;
import com.clubes.app.interfacesService.ICompeticionService;

@Controller
@RequestMapping("/admins")
public class CompeticionController {
	
	@Autowired
	private ICompeticionService service;
	
	@GetMapping("/listarCompeticion")
	public String listar(Model model) {
		List<Competicion> competicion =  service.listar();
		model.addAttribute("competicion", competicion);
		model.addAttribute("titulo", "Listar Competicions");
		
		return "competicion/listarCompeticion";
	}
	
	@GetMapping("/agregarCompeticion")
	public String crear(Model model) {
		model.addAttribute("competicion", new Competicion());
		model.addAttribute("titulo", "Crear Competicion");
		
		return "competicion/agregarCompeticion";
	}
	
	@PostMapping("/saveCompeticion")
	public String save(@Validated Competicion f, Model model, BindingResult result, @RequestParam("file") MultipartFile foto,SessionStatus status) {
		
		if (result.hasErrors())
		{
			
			return "competicion/agregarCompeticion";
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
		return "redirect:/admins/listarCompeticion";
	}
	
	@GetMapping("/actualizarCompeticion/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Competicion>competicion = service.listarId(id);
		model.addAttribute("competicion", competicion);
		model.addAttribute("titulo", "Editar Competicion");
		
		return "competicion/actualizarCompeticion";
	}
	
	@GetMapping("/eliminarCompeticion/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/admins/listarCompeticion"; // /Admin/listar
	}

}
