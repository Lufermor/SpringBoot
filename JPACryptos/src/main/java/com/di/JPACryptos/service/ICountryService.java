package com.di.JPACryptos.service;

import java.util.List;

import com.di.JPACryptos.entity.Country;

public interface ICountryService {
	
	public List<Country> listAll();
	public void save(Country estado);
	public Country get(long id);
	public void delete(long id);
	public List<Country> countriesMasDeXCryptos(int n);
	public List<Country> countriesMenosCryptosDe(int n);
	public List<Country> countriesIgualCryptosDe(int n);
}
