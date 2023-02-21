package com.di.JPACryptos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.di.JPACryptos.entity.Country;

@Repository
public interface ICountryDAO extends JpaRepository<Country, Long> {

	public List<Country> findByName(String name);
	
//	@Query("SELECT c FROM countries c WHERE n.title = ?1 AND n.featured = ?2")
//	@Query("SELECT c.* FROM Country c INNER JOIN Cryptocurrency cr ON c.id = cr.country\r\n"
//			+ "GROUP BY c.id\r\n HAVING COUNT(cr.id) > ?1")
//	public List<Country> countriesConMasDeNCryptos(int n);

	@Query("SELECT c FROM Country c JOIN c.cryptocurrencies cr GROUP BY c.id HAVING COUNT(cr) > :n")
	public List<Country> countriesConMasDeNCryptos(@Param("n") int n);
	
//	@Query("SELECT c.* FROM Country c INNER JOIN Cryptocurrency cr ON c.id = cr.country\r\n"
//			+ "GROUP BY c.id\r\n HAVING COUNT(cr.id) < ?1")
//	public List<Country> countriesMenosDeXCryptos(int n);
	
	@Query("SELECT c FROM Country c JOIN c.cryptocurrencies cr GROUP BY c.id HAVING COUNT(cr) < :n")
	public List<Country> countriesMenosDeXCryptos(@Param("n") int n);
	
//	@Query(value = "SELECT c.* FROM countries c INNER JOIN cryptocurrency cr ON c.id = cr.country"
//			+ "GROUP BY c.id HAVING COUNT(cr.id) = ?1", nativeQuery = true)
//	@Query("SELECT c.* FROM Country c INNER JOIN Cryptocurrency cr ON c.id = cr.country "
//			+ "GROUP BY c.id HAVING COUNT(cr.id) = ?1")
//	@Query("Select c from Country c")
//	public List<Country> countriesIgualCryptos(int n);
	
	@Query("SELECT c FROM Country c JOIN c.cryptocurrencies cr GROUP BY c.id HAVING COUNT(cr) = :n")
	public List<Country> countriesIgualCryptos(@Param("n") int n);

}
