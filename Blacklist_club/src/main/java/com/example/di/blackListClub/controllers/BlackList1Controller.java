package com.example.di.blackListClub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.di.blackListClub.entity.Persona;
import com.example.di.blackListClub.service.IPersonaService;

@Controller
public class BlackList1Controller {
	
	@Autowired
	private IPersonaService personaService;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Persona> listPersonas = personaService.listAll();
		model.addAttribute("listaPersonas", listPersonas);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewPersonPage(Model model) {
		Persona persona = new Persona();
		model.addAttribute("persona", persona);
		
		return "new_contact";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePerson(@ModelAttribute("persona") Persona persona) {
		personaService.save(persona);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditPersonPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_contact");
		Persona persona = personaService.get(id);
		mav.addObject("persona", persona);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deletePerson(@PathVariable(name = "id") int id) {
		personaService.delete(id);
		return "redirect:/";		
	}

}
