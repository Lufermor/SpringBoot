package com.di.RESTFulService.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.di.RESTFulService.entity.Curso;
import com.di.RESTFulService.entity.Widget;
import com.di.RESTFulService.service.ICursoService;
import com.di.RESTFulService.service.IWidgetService;

@RestController
@RequestMapping("/api")
public class BaseController {

	@Autowired
	private IWidgetService widgetService;

	@RequestMapping("/")
	public String welcome() {// Welcome page, non-rest
		return "Welcome to RestTemplate Example.";
	}

	@RequestMapping("/saluda")
	public Widget message() {

		Widget widget = new Widget();
		widget.setGreetings(widgetService.getAllGreetings());
		return widget;
	}

	@RequestMapping("/saluda/{name}")
	public Widget message2(@PathVariable String name) {

		Widget widget = new Widget();
		widget.setName(name);
		widget.setGreetings(widgetService.getAllGreetings());
		return widget;
	}

	@Autowired
	ICursoService cursoService;

	// Devuelve todos los cursos
	@GetMapping("/cursos")
	public ResponseEntity<List<Curso>> getAllCursos(@RequestParam(required = false) String nombre) {
		try {
			List<Curso> cursos = new ArrayList<Curso>();

			if (nombre == null)
				cursoService.findAll().forEach(cursos::add);
			else
				cursoService.findByRamaContaining(nombre).forEach(cursos::add);

			if (cursos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(cursos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Devuelve el curso con id = id
	@GetMapping("/cursos/{id}")
	public ResponseEntity<Curso> getTutorialById(@PathVariable("id") long id) {
		Optional<Curso> cursoData = cursoService.findById(id);

		if (cursoData.isPresent()) {
			return new ResponseEntity<>(cursoData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Guarda el curso que se le pasa como parámetro y lo devuelve
	@PostMapping("/cursos")
	public ResponseEntity<Curso> createTutorial(@RequestBody Curso curso) {
		try {
			Curso curso1 = cursoService
					.save(new Curso(curso.getNombre(), curso.getRama(), curso.getAlumnos(), curso.getYears()));
			return new ResponseEntity<>(curso1, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/cursos/{id}")
	public ResponseEntity<Curso> updateTutorial(@PathVariable("id") long id, @RequestBody Curso curso) {
		Optional<Curso> cursoData = cursoService.findById(id);

		if (cursoData.isPresent()) {
			Curso curso1 = cursoData.get();
			curso1.setNombre(curso.getNombre());
			curso1.setRama(curso.getRama());
			curso1.setFechaInicio(curso.getFechaInicio());
			curso1.setAlumnos(curso.getAlumnos());
			curso1.setYears(curso.getYears());
			return new ResponseEntity<>(cursoService.save(curso1), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/cursos/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			cursoService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/cursos")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			cursoService.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/cursos/masDeAlumnos/{alumnos}")
	public ResponseEntity<List<Curso>> findByMasdeXAlumnos(@PathVariable("alumnos") int alumnos) {
		try {
			List<Curso> cursos = cursoService.masDeXAlumnos(alumnos);

			if (cursos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(cursos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
