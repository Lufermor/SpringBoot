package com.example.di.blackListClub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientevip")
//@SecondaryTable(name = "vipzone", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class ClienteVip {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@Column(name = "dni", unique = true)
    private String dni;
	
	@Column(name = "nombre", length = 100)
    private String nombre;
	
	@Column(name = "edad", columnDefinition = "INT(2)")
    private int edad;
	
	@Column(name = "ciudad")
    private String ciudad;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "vipzone_id", nullable = false)
    private VipZone vipzone;
	
	public ClienteVip() {
	}

	public ClienteVip(Long id, String dni, String nombre, int edad, String ciudad, VipZone vipzone) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.ciudad = ciudad;
		this.vipzone = vipzone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public VipZone getVipzone() {
		return vipzone;
	}

	public void setVipzone(VipZone vipzone) {
		this.vipzone = vipzone;
	}
	
}
