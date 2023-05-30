package br.com.projeto.papelaria.dominio;

public class Fornecedor extends InformacoesPessoais {
	
	private Long idfornecedor;
	private String razaosocial;
	private String cnpj;
	
	public Fornecedor(Usuario us, Contato ct, Endereco end) {
		super.usuario = us;
		super.contato = ct;
		super.endereco = end;

}

	public Long getIdfornecedor() {
		return idfornecedor;
	}

	public void setIdfornecedor(Long idfornecedor) {
		this.idfornecedor = idfornecedor;
	}

	public String getRazaosocial() {
		return razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}