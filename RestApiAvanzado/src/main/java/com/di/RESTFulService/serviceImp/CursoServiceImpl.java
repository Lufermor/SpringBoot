package com.di.RESTFulService.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.di.RESTFulService.dao.ICursoDao;
import com.di.RESTFulService.entity.Curso;
import com.di.RESTFulService.service.ICursoService;

@Service
public class CursoServiceImpl implements ICursoService{
	
	@Autowired
	private ICursoDao cursoDao;
	
	@Override
	public List<Curso> findAll(){
		return cursoDao.findAll();
	}

	@Override
	public List<Curso> findByRamaContaining(String cadena) {
		return cursoDao.findByRamaContaining(cadena);
	}

	@Override
	public Optional<Curso> findById(long id) {
		return cursoDao.findById(id);
	}

	@Override
	public Curso save(Curso curso) {
		return cursoDao.save(curso);
	}

	@Override
	public void deleteById(long id) {
		cursoDao.deleteById(id);
	}

	@Override
	public void deleteAll() {
		cursoDao.deleteAll();
	}

	@Override
	public List<Curso> masDeXAlumnos(int alumnos) {
		return cursoDao.masDeXAlumnos(alumnos);
	}

}
