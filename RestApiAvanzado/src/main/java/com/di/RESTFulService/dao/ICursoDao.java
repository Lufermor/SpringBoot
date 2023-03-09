package com.di.RESTFulService.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.di.RESTFulService.entity.Curso;

@Repository
public interface ICursoDao extends JpaRepository<Curso, Long> {
	
	public List<Curso> findByNombre(String nombre);
	public List<Curso> findByRamaContaining(String rama);
	
	@Query("SELECT c FROM Curso c WHERE c.alumnos > :n")
	public List<Curso> masDeXAlumnos(@Param("n") int n);

}
