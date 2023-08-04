package br.com.paperbook.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcontato;
	
	@Column(length=20, unique=true)
	private String telefonecelular;
	
	@Column(length=20, nullable=true)
	private String telefoneresidencial;
	
	@Column(length=50, unique=true)
	private String email;

	public Contato() {
	}

	public Contato(Integer idcontato, String telefonecelular, String telefoneresidencia, String email) {
		this.idcontato = idcontato;
		this.telefonecelular = telefonecelular;
		this.telefoneresidencial = telefoneresidencia;
		this.email = email;
	}

	public Integer getIdcontato() {
		return idcontato;
	}

	public void setIdcontato(Integer idcontato) {
		this.idcontato = idcontato;
	}

	public String getTelefonecelular() {
		return telefonecelular;
	}

	public void setTelefonecelular(String telefonecelular) {
		this.telefonecelular = telefonecelular;
	}

	public String getTelefoneresidencia() {
		return telefoneresidencial;
	}

	public void setTelefoneresidencia(String telefoneresidencia) {
		this.telefoneresidencial = telefoneresidencia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
