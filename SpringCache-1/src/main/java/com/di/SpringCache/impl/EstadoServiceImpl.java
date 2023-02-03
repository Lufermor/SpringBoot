package com.di.SpringCache.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.di.SpringCache.dao.IEstadoDAO;
import com.di.SpringCache.entity.Estado;
import com.di.SpringCache.service.IEstadoService;

@Service
public class EstadoServiceImpl implements IEstadoService{
	
	@Autowired
	private IEstadoDAO estadoDao;

	@Override
	@Cacheable("listaDeEstados")
	public List<Estado> listAll() {
		System.out.println("Estado service: listando estados");
		return estadoDao.findAll();
	}

	@Override
	@CacheEvict(value="listaDeEstados", allEntries=true)
	public void save(Estado estado) {
		estadoDao.save(estado);		
	}

	@Override
	public Estado get(long id) {
		return estadoDao.findById(id).get();
	}

	@Override
	@CacheEvict(value="listaDeEstados", allEntries=true)
	public void delete(long id) {
		estadoDao.deleteById(id);		
	}

}
