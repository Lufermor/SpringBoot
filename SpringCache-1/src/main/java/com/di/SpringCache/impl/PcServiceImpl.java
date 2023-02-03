package com.di.SpringCache.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.di.SpringCache.dao.IPcDAO;
import com.di.SpringCache.entity.Estado;
import com.di.SpringCache.entity.Pc;
import com.di.SpringCache.service.IPcService;

@Service
public class PcServiceImpl implements IPcService{
	
	@Autowired
	private IPcDAO pcDAO;

	@Override
	@Cacheable("listaDePcs")
	public List<Pc> listAll() {
		System.out.println("Pc service: listando Pcs");
		return pcDAO.findAll();
	}

	@Override
	@CacheEvict(value="listaDePcs", allEntries=true)
	public void save(Pc pc) {
		pcDAO.save(pc);	
	}

	@Override
	public Pc get(long id) {
		return pcDAO.findById(id).get();
	}

	@Override
	@CacheEvict(value="listaDePcs", allEntries=true)
	public void delete(long id) {
		pcDAO.deleteById(id);	
	}

	@Override
	public List<Pc> listByEstado(Estado estado) {
		return pcDAO.findByEstado(estado);
	}

}
