package com.di.RESTFulService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.di.RESTFulService.entity.Curso;


@Service
public interface ICursoService {
	
	public List<Curso> findAll();
	public List<Curso> findByRamaContaining(String cadena);
	public Optional<Curso> findById(long id);
	public Curso save(Curso curso);
	public void deleteById(long id);
	public void deleteAll();
	public List<Curso> masDeXAlumnos(int alumnos);

}
