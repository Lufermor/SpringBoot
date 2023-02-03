package com.di.SpringCache.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.di.SpringCache.entity.Estado;
import com.di.SpringCache.entity.Pc;

@Repository
public interface IPcDAO extends JpaRepository<Pc, Long> {
	@Query("select p from Pc p where p.marca like ?1 ")
	public Pc findByMarca(String marca);
	
//	@Query("select p from Pc p where p.estado = ?1 ")
	public List<Pc> findByEstado(Estado estado);

}