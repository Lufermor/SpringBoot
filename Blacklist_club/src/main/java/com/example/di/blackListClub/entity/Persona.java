package com.example.di.blackListClub.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPersona")
	private Long id;
	@Column(name = "Nombre")
	private String nombre;
	@Column(name = "Apellidos")
	private String apellidos;
	@Column(name = "FechaNac")
	private LocalDate fechaNac;
	@Column(name = "Telefono")
	private String telefono;
	@Column(name = "Provincia")
	private String provincia;
	@Column(name = "Profesion")
	private String profesion;

	public Persona() {
	}

	public Persona(Long id, String nombre, String apellidos, LocalDate fechaNac, String telefono, String provincia,
			String profesion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
		this.telefono = telefono;
		this.provincia = provincia;
		this.profesion = profesion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
