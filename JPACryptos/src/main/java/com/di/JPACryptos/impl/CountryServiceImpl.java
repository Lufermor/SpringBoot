package com.di.JPACryptos.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.di.JPACryptos.dao.ICountryDAO;
import com.di.JPACryptos.entity.Country;
import com.di.JPACryptos.service.ICountryService;

@Service
public class CountryServiceImpl implements ICountryService{
	
	@Autowired
	private ICountryDAO countryDao;

	@Override
	@Cacheable("countriesList")
	public List<Country> listAll() {
		System.out.println("Country service: listando countries");
		return countryDao.findAll();
	}

	@Override
	@CacheEvict(value="countriesList", allEntries=true)
	public void save(Country country) {
		countryDao.save(country);		
	}

	@Override
	public Country get(long id) {
		return countryDao.findById(id).get();
	}

	@Override
	@Caching(evict = {
			@CacheEvict(value="countriesList", allEntries=true),
			@CacheEvict(value="listaDeCryptocurrencys", allEntries=true)})
	public void delete(long id) {
		countryDao.deleteById(id);		
	}

	@Override
	public List<Country> countriesMasDeXCryptos(int n) {
		return countryDao.countriesConMasDeNCryptos(n);
	}
	
	@Override
	public List<Country> countriesMenosCryptosDe(int n) {
		return countryDao.countriesMenosDeXCryptos(n);
	}
	@Override
	public List<Country> countriesIgualCryptosDe(int n) {
		return countryDao.countriesIgualCryptos(n);
	}

}

