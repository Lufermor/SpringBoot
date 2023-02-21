package com.di.JPACryptos.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "countries")
public class Country implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "country")
	private String name;
	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Cryptocurrency> cryptocurrencies;

	public Country() {
	}

	public Country(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Country(Long id, String name, Set<Cryptocurrency> cryptocurrencies) {
		super();
		this.id = id;
		this.name = name;
		this.cryptocurrencies = cryptocurrencies;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Cryptocurrency> getCryptocurrencies() {
		return cryptocurrencies;
	}

	public void setCryptocurrencies(Set<Cryptocurrency> cryptocurrencies) {
		this.cryptocurrencies = cryptocurrencies;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", cryptocurrencies=" + cryptocurrencies.size() + "]";
	}

}
