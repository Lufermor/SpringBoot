package com.di.JPACryptos.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.di.JPACryptos.dao.ICryptocurrencyDAO;
import com.di.JPACryptos.entity.Country;
import com.di.JPACryptos.entity.Cryptocurrency;
import com.di.JPACryptos.service.ICryptocurrencyService;

@Service
public class CryptocurrencyServiceImpl implements ICryptocurrencyService{
	
	@Autowired
	private ICryptocurrencyDAO cryptocurrencyDAO;

	@Override
	@Cacheable("listaDeCryptocurrencys")
	public List<Cryptocurrency> listAll() {
		System.out.println("Cryptocurrency service: listando Cryptocurrencys");
		return cryptocurrencyDAO.findAll();
	}

	@Override
	@CacheEvict(value="listaDeCryptocurrencys", allEntries=true)
	public void save(Cryptocurrency cryptocurrency) {
		cryptocurrencyDAO.save(cryptocurrency);	
	}

	@Override
	public Cryptocurrency get(long id) {
		return cryptocurrencyDAO.findById(id).get();
	}

	@Override
	@CacheEvict(value="listaDeCryptocurrencys", allEntries=true)
	public void delete(long id) {
		cryptocurrencyDAO.deleteById(id);	
	}

	@Override
	public List<Cryptocurrency> listByCountry(Country country) {
		return cryptocurrencyDAO.findByCountry(country);
	}

	/*
	 * Pre: ---
	 * Post: Obtiene del repository una lista de cryptos con
	 * precio menor de n
	 */
	@Override
	public List<Cryptocurrency> cryptosPrecioMenosDe(float n) {
		return cryptocurrencyDAO.cryptosPrecioMenosDe(n);
	}

}
