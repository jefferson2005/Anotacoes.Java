package contas;

public class Conta {
	// atributos
	// POO - Encapsulamento
	// 1) usar o modificador private nas variáveis
	// 2) criar métodos( getters e setters) para acessar as variáveis (botão direito -> souce)
	private double saldo;
	private String cliente;
	
	

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	// construtor
	public Conta() {
		super();
		System.out.println("Agência 2167");
	}
	
	//----------------------Encapsulamento
	
	
	// Métodos

	/**
	 * Método simples (void) Exibir o saldo da conta
	 */
	protected void exibirSaldo() {
		System.out.println("Saldo: R$ " + saldo);
	}

	/**
	 * Método com parâmetro (variável)
	 * 
	 * @param valor
	 */
	 void depositar(double valor) {
		saldo += valor;
		System.out.println("Crédito: R$ " + valor);

	}

	/**
	 * Método com parâmetro (variável)
	 * 
	 * @param valor
	 */

	 void sacar(double valor) {
		saldo -= valor;
		System.out.println("Débito: R$ " + valor);
	}

	/**
	 * Método com 2 parâmetros (objeto e variável)
	 * 
	 * @param destino
	 * @param valor
	 */

	 void tranferir(Conta destino, double valor) {
		this.sacar(valor);
		destino.depositar(valor);
		System.out.println("Transferência: R$ " + valor);
	}
	/**
	 * Método com 2 parâmetros (variável)
	 * @param cc1
	 * @param cc2
	 * @return
	 */
	
	 double soma(double cc1, double cc2) {
		double total = cc1 + cc2;
		return total;
	}

}
