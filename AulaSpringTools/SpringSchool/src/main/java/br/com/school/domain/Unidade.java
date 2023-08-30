package br.com.school.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Unidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idunidade;
	
	@Column(nullable=false)
	private String nomeunidade;
	
	@Column(nullable=false)
	private String endereco;

	public Unidade() {
	}

	public Unidade(Integer idunidade, String nomeunidade, String endereco) {
		this.idunidade = idunidade;
		this.nomeunidade = nomeunidade;
		this.endereco = endereco;
	}

	public Integer getIdunidade() {
		return idunidade;
	}

	public void setIdunidade(Integer idunidade) {
		this.idunidade = idunidade;
	}

	public String getNomeunidade() {
		return nomeunidade;
	}

	public void setNomeunidade(String nomeunidade) {
		this.nomeunidade = nomeunidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
