package com.di.SpringCache.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pcs")
public class Pc implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "Marca")
	private String marca;
	
	@Column(name = "Modelo")
	private String modelo;
	
	@Column(name = "Precio")
	private Double precio;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "estado", nullable = false)
    private Estado estado;
	
	@Column(name = "Disco")
	private String disco;
	
	@Column(name = "RAM")
	private String ram;

	public Pc() {
	}

	public Pc(Long id, String marca, String modelo, Double precio, Estado estado, String disco, String ram) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.estado = estado;
		this.disco = disco;
		this.ram = ram;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getDisco() {
		return disco;
	}

	public void setDisco(String disco) {
		this.disco = disco;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	@Override
	public String toString() {
		return "Pc [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", precio=" + precio 
				+ ", estado=" + estado.getEstado() + ", disco=" + disco + ", ram=" + ram + "]";
	}
	
}
