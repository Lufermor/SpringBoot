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
import com.di.SpringCache.service.IEstadoService;

@Controller
public class EstadoController {
	
	@Autowired
	private IEstadoService estadoService;
	
	/*
	 * Pre: ---
	 * Post: Carga una lista de todos los estados en el modelo, y
	 * se lo envía a la vista.
	 */
	@RequestMapping("/listar_estados")
	public String viewEstadosPage(Model model) {
		List<Estado> listEstados = estadoService.listAll();
		model.addAttribute("listaEstados", listEstados);
		
		return "estados";
	}
	
	/*
	 * Pre: ---
	 * Post: Carga un objeto Estado vacío en el modelo y lo
	 * envía a la vista 
	 */
	@RequestMapping("/newEstado")
	public String showNewEstadoPage(Model model) {
		Estado estado = new Estado();
		model.addAttribute("estado", estado);
		
		return "new_estado";
	}
	
	/*
	 * Pre: ---
	 * Post: Obtiene un objeto Estado del modelo y lo guarda en la BBDD
	 * A continuación redirije al mapping listar_estados
	 */
	@RequestMapping(value = "/saveEstado", method = RequestMethod.POST)
	public String saveEstado(@ModelAttribute("estado") Estado estado) {
		estadoService.save(estado);
		
		return "redirect:/listar_estados";
	}
	
	/*
	 * Pre: ---
	 * Post: Obtiene de la BBDD el estado que se corresponde con el id
	 * que llega con la petición, y junto con la vista edit_estado, 
	 * lo carga en un mav y se lo muestra al usuario
	 */
	@RequestMapping("/editEstado/{id}")
	public ModelAndView showEditEstadoPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_estado");
		Estado estado = estadoService.get(id);
		mav.addObject("estado", estado);
		
		return mav;
	}
	
	/*
	 * Pre: ---
	 * Post: Llama al service para eliminar de la BBDD el Estado con 
	 * la id que le llega en la petición.  
	 * Por último redirije al mapping listar_estados.
	 */
	@RequestMapping("/deleteEstado/{id}")
	public String deleteEstado(@PathVariable(name = "id") int id) {
		estadoService.delete(id);
		return "redirect:/listar_estados";		
	}

}