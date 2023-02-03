package com.di.SpringCache.service;

import java.util.List;

import com.di.SpringCache.entity.Estado;

public interface IEstadoService {
	
	public List<Estado> listAll();
	public void save(Estado estado);
	public Estado get(long id);
	public void delete(long id);

}
