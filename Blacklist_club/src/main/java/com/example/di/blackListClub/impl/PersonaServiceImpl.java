package com.example.di.blackListClub.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.di.blackListClub.dao.IPersonaDAO;
import com.example.di.blackListClub.entity.Persona;
import com.example.di.blackListClub.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService{
	
	@Autowired
	private IPersonaDAO personaDao;

	@Override
	public List<Persona> listAll() {
		return personaDao.findAll();
	}

	@Override
	public void save(Persona persona) {
		personaDao.save(persona);
	}

	@Override
	public Persona get(long id) {
		return personaDao.findById(id).get();
	}

	@Override
	public void delete(long id) {
		personaDao.deleteById(id);
	}

}
