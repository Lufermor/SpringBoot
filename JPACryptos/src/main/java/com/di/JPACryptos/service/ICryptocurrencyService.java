package com.di.JPACryptos.service;

import java.util.List;

import com.di.JPACryptos.entity.Country;
import com.di.JPACryptos.entity.Cryptocurrency;

public interface ICryptocurrencyService {
	
	public List<Cryptocurrency> listAll();
	public void save(Cryptocurrency Cryptocurrency);
	public Cryptocurrency get(long id);
	public void delete(long id);
	public List<Cryptocurrency> listByCountry(Country country);
	public List<Cryptocurrency> cryptosPrecioMenosDe(float n);

}
