package com.di.JPACryptos.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CountryController {
	
	@Autowired
	private ICountryService countryService;
	@Autowired
	private ICryptocurrencyService cryptocurrencyService;
	@Autowired
	private HttpServletRequest request;
	
	/*
	 * Pre: ---
	 * Post: Carga una lista de todos los countries en el modelo, y
	 * se lo envía a la vista.
	 */
	@RequestMapping("/listar_countries")
	public String viewCountriesPage(Model model) {
		List<Country> listCountriess = countryService.listAll();
		model.addAttribute("listaCountries", listCountriess);
		
		return "listar_countries";
	}
	
	/*
	 * Pre: ---
	 * Post: Carga un objeto Country vacío en el modelo y lo
	 * envía a la vista 
	 */
	@RequestMapping("/newCountry")
	public String showNewCountryPage(Model model) {
		Country country = new Country();
		model.addAttribute("country", country);
		
		return "new_country";
	}
	
	/*
	 * Pre: ---
	 * Post: Obtiene un objeto Country del modelo y lo guarda en la BBDD
	 * A continuación redirije al mapping listar_countries
	 */
	@RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
	public String saveCountry(@ModelAttribute("country") Country country) {
		Country country1 = null;
		try {
			if(country.getId() != null) country1 =countryService.get(country.getId());
		}catch (Exception e) {throw e;}
		if(country1 != null) country.setCryptocurrencies(country1.getCryptocurrencies());
		else {
//			Set<Cryptocurrency> cryptocurrencies = new HashSet<>();
			country.setCryptocurrencies(new HashSet<>());
		}
		//Buscamos el country:
		countryService.save(country);
		
		return "redirect:/listar_countries";
	}
	
	/*
	 * Pre: ---
	 * Post: Obtiene de la BBDD el country que se corresponde con el id
	 * que llega con la petición, y junto con la vista edit_country, 
	 * lo carga en un mav y se lo muestra al usuario
	 */
	@RequestMapping("/editCountry/{id}")
	public ModelAndView showEditCountryPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_country");
		Country country = countryService.get(id);
		mav.addObject("country", country);
		
		return mav;
	}
	
	/*
	 * Pre: ---
	 * Post: Llama al service para eliminar de la BBDD el Country con 
	 * la id que le llega en la petición.  
	 * Por último redirije al mapping listar_countries.
	 */
	@RequestMapping("/deleteCountry/{id}")
	public String deleteCountry(@PathVariable(name = "id") int id) {
		countryService.delete(id);
		return "redirect:/listar_countries";		
	}
	
	/*
	 * Pre: ---
	 * Post: Método que se encarga de cargar en una lista todas los las cryptocurrencies 
	 * disponibles para un country particular y enviarlos a la vista.  
	 */
	@RequestMapping("/listarCryptocurrenciesPorCountry/{id}")
	public String viewCryptocurrenciesPorCountry(Model model, @PathVariable(name = "id") int countryID) {
		Country country = countryService.get(countryID);
		List<Cryptocurrency> listaCryptocurrencies = cryptocurrencyService.listByCountry(country);
		model.addAttribute("listaCryptocurrencies", listaCryptocurrencies);
		model.addAttribute("country", country);
		
		return "listar_cryptocurrencies_country";
	}
	
	/*
	 * Pre: ---
	 * Post: Redirige al usuario a la petición raiz
	 */
	@RequestMapping("/ToHomePage")
	public String toHomePage(Model model) {
		return "redirect:/";	
	}
	
	/*
	 * Pre: ---
	 * Post: Pide al service para obtener la lista de paises con 
	 * más cryptos de las que solicita el usuario, envía la lista
	 * al modelo y carga una nueva vista
	 */
	@RequestMapping("/countriesMasCryptosDe")
	public String countriesMasCryptosDe(Model model, @RequestParam("MasDeCryptos") int n) {
//	    int n = Integer.parseInt(request.getParameter("MasDeCryptos"));
	    List<Country> listCountries = countryService.countriesMasDeXCryptos(n);
	    model.addAttribute("listaCountries", listCountries);
	    return "listar_countries_cryptos";
	}
	
	/*
	 * Pre: ---
	 * Post: Pide al service para obtener la lista de paises con 
	 * menos cryptos de las que solicita el usuario, envía la lista
	 * al modelo y carga una nueva vista
	 */
	@RequestMapping("/countriesMenosCryptosDe")
	public String countriesMenosCryptosDe(Model model, @RequestParam("MenosDeCryptos") int n) {
//		int n = Integer.parseInt(request.getParameter("MenosDeCryptos"));
		List<Country> listCountriess = countryService.countriesMenosCryptosDe(n);
		model.addAttribute("listaCountries", listCountriess);
		return "listar_countries_cryptos";
	}
	
	/*
	 * Pre: ---
	 * Post: Pide al service para obtener la lista de paises con 
	 * el numero de cryptos que solicita el usuario, envía la lista
	 * al modelo y carga una nueva vista
	 */
	@RequestMapping("/countriesIgualCryptosDe")
	public String countriesIgualCryptosDe(Model model, @RequestParam("IgualCryptos") int n) {
//		int n = Integer.parseInt(request.getParameter("IgualCryptos"));
		List<Country> listCountriess = countryService.countriesIgualCryptosDe(n);
		model.addAttribute("listaCountries", listCountriess);
		return "listar_countries_cryptos";
	}

}
