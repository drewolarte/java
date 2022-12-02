package com.clubes.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controllers {
	
	
	@GetMapping({"/","/index"})
	public String incio(Model model) {
		
		return "index";
	}
	
	@GetMapping({"/matches"})
	public String matches(Model model) {
		
		return "matches";
	}
	
	@GetMapping({"/players"})
	public String players(Model model) {
		
		return "players";
	}
	
	@GetMapping({"/blog"})
	public String blog(Model model) {
		
		return "blog";
	}
	
	@GetMapping({"/contact"})
	public String contact(Model model) {
		
		return "contact";
	}
	
	@GetMapping({"/single"})
	public String single(Model model) {
		
		return "single";
	}
	
	@GetMapping({"/login"})
	public String login(Model model) {
		
		return "login";
	}
	
	@GetMapping({"/admin"})
	public String admin(Model model) {
		
		return "admin";
	}
	
	@GetMapping({"/logout"})
	public String logout(Model model) {
		
		return "login";
	}
	
	
}
