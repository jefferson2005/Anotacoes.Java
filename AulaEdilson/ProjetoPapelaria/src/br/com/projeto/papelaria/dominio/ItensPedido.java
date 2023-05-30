package br.com.projeto.papelaria.dominio;

public class ItensPedido {
	
	private Long iditenspedido;
	private Pedido idpedido;
	private Produto idproduto;
	private Double desconto;
	private int quantidade;
	private Double precototal;
	
	
	public Long getIditenspedido() {
		return iditenspedido;
	}
	public void setIditenspedido(Long iditenspedido) {
		this.iditenspedido = iditenspedido;
	}
	public Pedido getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(Pedido idpedido) {
		this.idpedido = idpedido;
	}
	public Produto getIdproduto() {
		return idproduto;
	}
	public void setIdproduto(Produto idproduto) {
		this.idproduto = idproduto;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPrecototal() {
		return precototal;
	}
	public void setPrecototal(Double precototal) {
		this.precototal = precototal;
	}

	
}
