package com.di.JPACryptos.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.di.JPACryptos.entity.Country;
import com.di.JPACryptos.entity.Cryptocurrency;

@Repository
public interface ICryptocurrencyDAO extends JpaRepository<Cryptocurrency, Long> {

	public List<Cryptocurrency> findByCountry(Country country);
	
	/*
	 * Pre: ---
	 * Post: Consulta la BBDD y devuelve una lista con 
	 * las cryptos cuyo precio es menor que el número dado por el usuario
	 */
	@Query("SELECT cr FROM Cryptocurrency cr WHERE cr.value < :n")
	public List<Cryptocurrency> cryptosPrecioMenosDe(@Param("n") float n);

}
