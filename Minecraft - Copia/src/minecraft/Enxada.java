package minecraft;

// extends = Herança
public class Enxada extends Bloco {
	//atributos
	//boolean (Variável - true / false)
	boolean conquista;
	//métodos
	
	//construtor 
	public Enxada() {
		System.out.println("");
		System.out.println("  ___");
		System.out.println(" /");
		System.out.println("/");
	}
	
	public void arar() {
		System.out.println("Terra arada ._._._.");
		conquista = true;
	}
	
	//Uso do polimorfismo para modificar o comportamento  de método
	//Obrigatório usar o mesmo nome do método
	public void minerar() {
		System.out.println("Dano causado!");
	}
	
	
}
