package com.example.di.blackListClub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vipzone")
public class VipZone {
	
	private static final long serialVersionUID = 3233149207833106460L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, columnDefinition = "INT(11)")
    private Long id;
	
	@Column(name = "zona", length = 100)
    private String zona;
	
	@Column(name = "numPersonas", columnDefinition = "INT(3)")
    private int numPersonas;
	
	@Column(name = "gasto")
    private double gasto;
	
	@Column(name = "disponibilidad", columnDefinition = "INT(1)")
    private int disponibilidad;

	public VipZone() {
	}

	public VipZone(Long id, String zona, int numPersonas, double gasto, int disponibilidad) {
		this.id = id;
		this.zona = zona;
		this.numPersonas = numPersonas;
		this.gasto = gasto;
		this.disponibilidad = disponibilidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	public double getGasto() {
		return gasto;
	}

	public void setGasto(double gasto) {
		this.gasto = gasto;
	}

	public int getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
