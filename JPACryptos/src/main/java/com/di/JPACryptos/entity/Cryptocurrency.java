package com.di.JPACryptos.entity;

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
@Table(name = "cryptocurrency")
public class Cryptocurrency implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "value")
	private Double value;

	@Column(name = "based_in")
	private String basedIn;
	
	@Column(name = "author")
	private String author;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "country", nullable = false)
    private Country country;

	public Cryptocurrency() {
	}

	public Cryptocurrency(Long id, String name, String description, Double value, String basedIn, String author,
			Country country) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.value = value;
		this.basedIn = basedIn;
		this.author = author;
		this.country = country;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getBasedIn() {
		return basedIn;
	}

	public void setBasedIn(String basedIn) {
		this.basedIn = basedIn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Cryptocurrency [id=" + id + ", name=" + name + ", description=" + description + ", value=" + value
				+ ", basedIn=" + basedIn + ", author=" + author + ", country=" + country.getName() + "]";
	}
	

}