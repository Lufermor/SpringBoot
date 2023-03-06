package com.di.JPACryptos.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.di.JPACryptos.entity.Country;
import com.di.JPACryptos.service.ICountryService;
import com.di.JPACryptos.service.ICryptocurrencyService;

import static org.junit.Assert.assertEquals;

import java.util.List;

@SpringBootTest
public class ICountryServiceTest {

	@Autowired
	private ICountryService countryService;
	// @Autowired
	// private ICryptocurrencyService cryptocurrencyService;
	
	@Test
	public void findByName() {
		// Creamos objeto mockCountry
		Country mockCountry1 = new Country();
		mockCountry1.setName("mockCountry1");
		// Guardamos objeto Mock en DB
		countryService.save(mockCountry1);
		// Creamos nuevo objeto para contrastar
		Country mockCountry1Test = countryService.findByName("mockCountry1").get(0);
		
		//Realizamos la comprobación
		assertEquals("El nombre obtenido es incorrecto", "mockCountry1", mockCountry1Test.getName());
		
	}
	
	@Test
	public void get() {
		/* Obtenemos objeto conocido de la DB, este objeto se creó al realizar 
		 * el testing del método findByName */
		Country mockCountry1Test = countryService.get(19);
		
		//Realizamos la comprobación
		assertEquals("El nombre obtenido es incorrecto", "mockCountry1", mockCountry1Test.getName());
		
	}
	
	@Test
	public void countriesMasDeXCryptos() {
		/* Llamamos al método del service para obtener una lista, y comprobamos
		 * su longitud */
		List<Country> mockCountryList1 = countryService.countriesMasDeXCryptos(2);
		
		//Realizamos la comprobación
		assertEquals("El numero de paises obtenidos es incorrecto", 7, mockCountryList1.size());
		
	}
	
	@Test
	public void countriesIgualCryptosDe() {
		/* Llamamos al método del service para obtener una lista, y comprobamos
		 * su longitud */
		List<Country> mockCountryList1 = countryService.countriesIgualCryptosDe(1);
		
		//Realizamos la comprobación
		assertEquals("El numero de paises obtenidos es incorrecto", 1, mockCountryList1.size());
		
	}
	
}
