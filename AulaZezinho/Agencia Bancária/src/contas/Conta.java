package contas;

public class Conta {
	// atributos
	public double saldo;
	public String cliente;

	// construtor
	public Conta() {
		super();
		System.out.println("Agência 2167");
	}
	// Métodos

	/**
	 * Método simples (void) Exibir o saldo da conta
	 */
	public void exibirSaldo() {
		System.out.println("Saldo: R$ " + saldo);
	}

	/**
	 * Método com parâmetro (variável)
	 * 
	 * @param valor
	 */
	public void depositar(double valor) {
		saldo += valor;
		System.out.println("Crédito: R$ " + valor);

	}

	/**
	 * Método com parâmetro (variável)
	 * 
	 * @param valor
	 */

	public void sacar(double valor) {
		saldo -= valor;
		System.out.println("Débito: R$ " + valor);
	}

	/**
	 * Método com 2 parâmetros (objeto e variável)
	 * 
	 * @param destino
	 * @param valor
	 */

	public void tranferir(Conta destino, double valor) {
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
	
	public double soma(double cc1, double cc2) {
		double total = cc1 + cc2;
		return total;
	}

}
