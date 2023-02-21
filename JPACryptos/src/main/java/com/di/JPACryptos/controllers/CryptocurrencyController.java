package com.di.JPACryptos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.di.JPACryptos.entity.Country;
import com.di.JPACryptos.entity.Cryptocurrency;
import com.di.JPACryptos.service.ICountryService;
import com.di.JPACryptos.service.ICryptocurrencyService;

@Controller
public class CryptocurrencyController {
	
	@Autowired
	private ICryptocurrencyService cryptocurrencyService;
	@Autowired
	private ICountryService countryService;
	
	/*
	 * Pre: ---
	 * Post: Carga una lista de todos los cryptocurrencies en el modelo, y
	 * se lo envía a la vista.
	 */
	@RequestMapping("/listarCryptocurrencies")
	public String viewCryptocurrenciesPage(Model model) {
		List<Cryptocurrency> listCryptocurrencies = cryptocurrencyService.listAll();
		model.addAttribute("listaCryptocurrencies", listCryptocurrencies);
		
		return "listar_cryptocurrencies";
	}
	
	/*
	 * Pre: ---
	 * Post: Carga un objeto Cryptocurrency vacío en el modelo y lo
	 * envía a la vista 
	 */
	@RequestMapping("/newCryptocurrency")
	public String showNewCryptocurrencyPage(Model model) {
		Cryptocurrency cryptocurrency = new Cryptocurrency();
		List<Country> countries = countryService.listAll();
		model.addAttribute("cryptocurrency", cryptocurrency);
		model.addAttribute("listaCountries", countries);
		
		return "new_cryptocurrency";
	}
	
	/*
	 * Pre: Se ha completado el formulario de creación o de edición de  de cryptocurrencies.
	 * Post: Obtiene un objeto Cryptocurrency del modelo y lo guarda en la BBDD,
	 * antes de guardarlo, necesita buscar en la BBDD el pais seleccionado por el usuario.
	 * A continuación redirije al mapping listarCryptocurrencies
	 */
	/*
	 * Pre: Se ha completado el formulario de creación de modelos.
	 * Post: Método que se encarga de guardar un nuevo modelo en la base de datos.
	 * Si se viene de editar un modelo en lugar de insertar uno nuevo, se 
	 * necesita volverle a asignar el set de vehículos que tenía ese modelo 
	 * anteriormente.
	 */
	@RequestMapping(value = "/saveCryptocurrency", method = RequestMethod.POST)
	public String saveCryptocurrency(@ModelAttribute("cryptocurrency") Cryptocurrency cryptocurrency, int idCountry) {
		Country country = countryService.get((long) idCountry);
		cryptocurrency.setCountry(country);
		cryptocurrencyService.save(cryptocurrency);
		
		return "redirect:/listarCryptocurrencies";
	}
	
	/*
	 * Pre: ---
	 * Post: Obtiene de la BBDD el cryptocurrency que se corresponde con el id
	 * que llega con la petición, y junto con la vista edit_cryptocurrency, 
	 * lo carga en un mav y se lo muestra al usuario
	 */
	@RequestMapping("/editCryptocurrency/{id}")
	public ModelAndView showEditCryptocurrencyPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_cryptocurrency");
		Cryptocurrency cryptocurrency = cryptocurrencyService.get(id);
		List<Country> countries = countryService.listAll();
		mav.addObject("cryptocurrency", cryptocurrency);
		mav.addObject("listaCountries", countries);
		
		return mav;
	}
	
	/*
	 * Pre: ---
	 * Post: Llama al service para eliminar de la BBDD el Cryptocurrency con 
	 * la id que le llega en la petición.  
	 * Por último redirije al mapping listarCryptocurrencies.
	 */
	@RequestMapping("/deleteCryptocurrency/{id}")
	public String deleteCryptocurrency(@PathVariable(name = "id") int id) {
		cryptocurrencyService.delete(id);
		return "redirect:/listarCryptocurrencies";		
	}
	
	/*
	 * Pre: ---
	 * Post: Redirige al mapping listarCryptocurrencies
	 */
	@RequestMapping("/")
	public String inicioPage() {
		return "redirect:/listarCryptocurrencies";
	}
	
	/*
	 * Pre: ---
	 * Post: Pide al service para obtener la lista de Cryptocurrencies  con 
	 * precio menor de un numero dado por el usuario, envía la lista
	 * al modelo y carga una nueva vista
	 */
	@RequestMapping("/cryptosMenosCosteDe")
	public String countriesMasCryptosDe(Model model, @RequestParam("PrecioMayor") float n) {
//	    int n = Integer.parseInt(request.getParameter("MasDeCryptos"));
	    List<Cryptocurrency> listCryptocurrencies = cryptocurrencyService.cryptosPrecioMenosDe(n);
		model.addAttribute("listaCryptocurrencies", listCryptocurrencies);
		return "listar_cryptocurrencies";
	}

}
