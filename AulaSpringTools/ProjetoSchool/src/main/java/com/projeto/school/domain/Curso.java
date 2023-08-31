package com.projeto.school.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcurso;
	
	@Column(nullable = false)
	private String titulocurso;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private String cargahoraria;
	
	@Column(nullable = false)
	private Integer idarea;
	
	@Column(nullable = false)
	private Integer idunidade ;

	public Curso() {
	}

	public Curso(Integer idcurso, String titulocurso, String descricao, String cargahoraria, Integer idarea,
			Integer idunidade) {
		this.idcurso = idcurso;
		this.titulocurso = titulocurso;
		this.descricao = descricao;
		this.cargahoraria = cargahoraria;
		this.idarea = idarea;
		this.idunidade = idunidade;
	}

	public Integer getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(Integer idcurso) {
		this.idcurso = idcurso;
	}

	public String getTitulocurso() {
		return titulocurso;
	}

	public void setTitulocurso(String titulocurso) {
		this.titulocurso = titulocurso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCargahoraria() {
		return cargahoraria;
	}

	public void setCargahoraria(String cargahoraria) {
		this.cargahoraria = cargahoraria;
	}

	public Integer getIdarea() {
		return idarea;
	}

	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}

	public Integer getIdunidade() {
		return idunidade;
	}

	public void setIdunidade(Integer idunidade) {
		this.idunidade = idunidade;
	}



		
}
