package com.di.RESTFulService.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "rama")
	private String rama;

	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	
	@Column(name = "alumnos")
	private int alumnos;
	
	@Column(name = "years")
	private float years;

	public Curso() {
		super();
	}
	
	public Curso(String nombre, String rama, int alumnos, float years) {
		super();
		this.nombre = nombre;
		this.rama = rama;
		this.fechaInicio = new Date();
		this.alumnos = alumnos;
		this.years = years;
	}

	public Curso(String nombre, String rama, Date fechaInicio, int alumnos, float years) {
		super();
		this.nombre = nombre;
		this.rama = rama;
		this.fechaInicio = fechaInicio;
		this.alumnos = alumnos;
		this.years = years;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRama() {
		return rama;
	}

	public void setRama(String rama) {
		this.rama = rama;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(int alumnos) {
		this.alumnos = alumnos;
	}

	public float getYears() {
		return years;
	}

	public void setYears(float f) {
		this.years = f;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", rama=" + rama + ", fechaInicio=" + fechaInicio
				+ ", alumnos=" + alumnos + ", years=" + years + "]";
	}

}
