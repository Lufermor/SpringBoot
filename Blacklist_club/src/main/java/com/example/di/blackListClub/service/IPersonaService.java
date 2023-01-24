package com.example.di.blackListClub.service;

import java.util.List;

import com.example.di.blackListClub.entity.Persona;

public interface IPersonaService {

	public List<Persona> listAll();
	public void save(Persona persona);
	public Persona get(long id);
	public void delete(long id);
}
