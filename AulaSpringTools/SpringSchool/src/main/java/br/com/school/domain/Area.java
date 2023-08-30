package br.com.school.domain;

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
	
	@Column(nullable=false)
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

	public String getTituloarea() {
		return tituloarea;
	}

	public void setTituloarea(String tituloarea) {
		this.tituloarea = tituloarea;
	}
	
}
