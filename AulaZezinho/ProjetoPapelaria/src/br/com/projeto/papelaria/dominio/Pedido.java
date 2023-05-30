package br.com.projeto.papelaria.dominio;

import java.util.Date;

public class Pedido {
	
	private Long idPedido;
	private Usuario usuario;
	private Date dataPedido;
	
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getDatapedido() {
		return dataPedido;
	}
	public void setDatapedido(Date datapedido) {
		this.dataPedido = datapedido;
	}
	 

}
