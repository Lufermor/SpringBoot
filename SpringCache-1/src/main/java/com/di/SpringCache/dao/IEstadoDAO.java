package com.di.SpringCache.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.di.SpringCache.entity.Estado;

@Repository
public interface IEstadoDAO extends JpaRepository<Estado, Long> {
	@Query("select e from Estado e where e.estado like ?1 ")
	public Estado findByName(String estado);

}
