package br.com.projeto.papelaria.dominio;

public class Pagamento {
	
	private Long idpagamento;
	private Pedido pedido;
	private  TipoPagamento tipo;
	private String descricao;
	private Double valor;
	private Double parcelas;
	private Double valorparcela;
	
	public Long getIdpagamento() {
		return idpagamento;
	}
	public void setIdpagamento(Long idpagamento) {
		this.idpagamento = idpagamento;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public TipoPagamento getTipo() {
		return tipo;
	}
	public void setTipo(TipoPagamento tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Double getParcelas() {
		return parcelas;
	}
	public void setParcelas(Double parcelas) {
		this.parcelas = parcelas;
	}
	public Double getValorparcela() {
		return valorparcela;
	}
	public void setValorparcela(Double valorparcela) {
		this.valorparcela = valorparcela;
	}
	
	
}
