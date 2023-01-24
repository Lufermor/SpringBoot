package com.example.di.blackListClub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.di.blackListClub.entity.Persona;

@Repository
public interface IPersonaDAO extends JpaRepository<Persona, Long>{
	@Query("select p from Persona p where p.nombre like ?1 ")
	public Persona findByName(String name);

}