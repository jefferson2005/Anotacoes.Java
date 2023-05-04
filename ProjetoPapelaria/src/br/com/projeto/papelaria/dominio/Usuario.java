package br.com.projeto.papelaria.dominio;

public class Usuario {
	
	private Long idUsuario;
	private String nomeUsuario;
	private String Senha;
	private String nivelAcesso;
	
	
	/**
	 * @return the idUsuario
	 */
	public Long getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return the nomeUsuario
	 */
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	/**
	 * @param nomeUsuario the nomeUsuario to set
	 */
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return Senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		Senha = senha;
	}
	/**
	 * @return the nivelAcesso
	 */
	public String getNivelAcesso() {
		return nivelAcesso;
	}
	/**
	 * @param nivelAcesso the nivelAcesso to set
	 */
	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
	
	

}
