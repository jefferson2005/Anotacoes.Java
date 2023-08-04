package Objetos;

public class Increment {

	public static void main(String[] args) {
		
		//demonstra o operador de pós-incremento
		int c = 5;
		System.out.printf("c before posticrement: %d%n", c);// imprime 5
		System.out.printf("    postincrementing C: %d%n", c++);// imprime 5
		System.out.printf(" c after postincrement: %d%n", c);// imprime 6

		System.out.println(); // pula uma linha
		
		// demonstra o operador de pré-incremento
		c = 5;
		System.out.printf("c before posticrement: %d%n", c);// imprime 5
		System.out.printf("    preincrementing C: %d%n", ++c);// imprime 5
		System.out.printf(" c after postincrement: %d%n", c);// imprime 6
	}

}// fim da classe Increment
