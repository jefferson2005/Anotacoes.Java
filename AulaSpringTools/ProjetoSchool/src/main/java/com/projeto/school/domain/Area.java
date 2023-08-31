package com.projeto.school.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Area {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idarea;
	
	@Column(nullable = false, unique=true)
	private String tituloarea;

	public Area() {
	}

	public Area(Integer idarea, String tituloarea) {
		this.idarea = idarea;
		this.tituloarea = tituloarea;
	}

	public Integer getIdarea() {
		return idarea;
	}

	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}

	public String gettituloarea() {
		return tituloarea;
	}

	public void settituloarea(String tituloarea) {
		this.tituloarea = tituloarea;
	}

	
}
