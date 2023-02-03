package com.di.SpringCache.service;

import java.util.List;

import com.di.SpringCache.entity.Estado;
import com.di.SpringCache.entity.Pc;

public interface IPcService {
	
	public List<Pc> listAll();
	public void save(Pc pc);
	public Pc get(long id);
	public void delete(long id);
	public List<Pc> listByEstado(Estado estado);

}