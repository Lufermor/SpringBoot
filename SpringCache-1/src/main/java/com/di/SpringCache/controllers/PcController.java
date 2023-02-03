package com.di.SpringCache.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.di.SpringCache.entity.Estado;
import com.di.SpringCache.entity.Pc;
import com.di.SpringCache.service.IEstadoService;
import com.di.SpringCache.service.IPcService;

@Controller
public class PcController {
	
	@Autowired
	private IPcService pcService;
	@Autowired
	private IEstadoService estadoService;
	
	/*
	 * Pre: ---
	 * Post: carga una lista de pcs que contienen el estado con id igual al que 
	 * se le pasa como parámetro
	 */
	@RequestMapping("/pcsEstado/{id}")
	public String viewPcsEstadoPage(Model model, @PathVariable(name = "id") int estadoID) {
		Estado estado = estadoService.get(estadoID);
		List<Pc> listPcs = pcService.listByEstado(estado);
		model.addAttribute("listaPcs", listPcs);
		model.addAttribute("estado", estado);
		
		return "pcsEstado";
	}
	
	/*
	 * Pre: ---
	 * Post: Redirige al mapping lista_pcs
	 */
	@RequestMapping("/")
	public String inicioPage() {
		return "redirect:/lista_pcs";
	}
	
	/*
	 * Pre: ---
	 * Post:
	 * Carga en el modelo una lista de todos los registros de pcs
	 */
	@RequestMapping("/lista_pcs")
	public String viewPcsPage(Model model) {
		List<Pc> listPcs = pcService.listAll();
		model.addAttribute("listaPcs", listPcs);
		
		return "lista_pcs";
	}
	
	/*
	 * Pre: ---
	 * Post: Carga en el modelo un nuevo objeto Pc, a este objeto se le asigna
	 * un objeto Estado que se ha cargado a partir de llamar al service con su id.
	 * Luego carga la vista new_Pc donde se introducirán los datos del objeto Pc
	 */
	@RequestMapping("/newPc/{id}")
	public String showNewPcEstadoPage(Model model, @PathVariable(name = "id") int estadoID) {
		Pc pc = new Pc();
		Estado estado = estadoService.get(estadoID);
		pc.setEstado(estado);
		List<Estado> estados = estadoService.listAll();
		model.addAttribute("listaEstados", estados);
		model.addAttribute("pc", pc);
		
		return "new_Pc";
	}
	
	/*
	 * Pre: ---
	 * Post: Crea un objeto Pc vacío y lo carga en el modelo, a continuación
	 * llama a la vista new_Pc para que el usuario introduzca los datos del objeto
	 */
	@RequestMapping("/nuevoPc")
	public String showNewPcPage(Model model) {
		Pc pc = new Pc();
		List<Estado> listaEstados = estadoService.listAll();
		model.addAttribute("listaEstados", listaEstados);
		model.addAttribute("pc", pc);
		
		return "new_Pc";
	}
	
	/*
	 * Pre: ---
	 * Post:Guarda un objeto pc que se extrae del modelo, en la BBDD
	 */
	@RequestMapping(value = "/savePc", method = RequestMethod.POST)
	public String saveEstado(@ModelAttribute("pc") Pc pc, int idEstado) {
		Estado estado = estadoService.get((long) idEstado);
		pc.setEstado(estado);
		pcService.save(pc);
		
		return "redirect:/lista_pcs";
	}
	
	/*
	 * Pre: ---
	 * Post: Carga en el mav un objeto pc del que se le pasa la id, obteniéndolo
	 * de la BBDD. El mav se mezcla con la vista edit_pc para que el usuario
	 * pueda editar el objeto Pc
	 */
	@RequestMapping("/editPc/{id}")
	public ModelAndView showEditEstadoPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_pc");
		Pc pc = pcService.get(id);
		List<Estado> listaEstados = estadoService.listAll();
		mav.addObject("listaEstados", listaEstados);
		mav.addObject("pc", pc);
		return mav;
	}
	
	/*
	 * Pre: ---
	 * Post: Elimina de la BBDD un objeto Pc del que se le pasa la id.
	 * Después redirige al método con maping "lista_pcs"
	 */
	@RequestMapping("/deletePc/{id}")
	public String deleteEstado(@PathVariable(name = "id") int id) {
		Pc pc = pcService.get(id);
		pcService.delete(pc.getId());
		return "redirect:/lista_pcs";
	}
	
	/*
	 * Pre: ---
	 * Post: Redirige al usuario a la vista inicial
	 */
	@RequestMapping("/ToHomePage")
	public String toHomePage(Model model) {
		return "redirect:/";	
	}

}