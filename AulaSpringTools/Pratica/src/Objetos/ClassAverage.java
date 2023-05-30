package Objetos;
import java.util.Scanner;

public class ClassAverage {

	public static void main(String[] args) {
		
		// cria Scanner para obter entrada a partir da janela de comando
		Scanner input = new Scanner(System.in);
		
		//fase de inicialização
		int total = 0; // inicizaliza a soma das notas inseridas pelo usuário
		int gradeCounter = 1; // inicializa n° da nota a ser inserido em seguida
		
		//fase de processamento utiliza repetição controlada por contador
		while (gradeCounter <= 10) // faz o loop 10 vezes
		{
			System.out.println("Enter grande: "); // prompt
			int grande = input.nextInt(); // insere a próxima nota
			total = total + grande; // adiciona grade a total
			gradeCounter = gradeCounter +1; // incrementa o contador por 1
		}
		
		//fase de término
		int average = total / 10; // divisão de inteiros um resultado inteiro
		
		// exibe o total e a média das notas
		System.out.printf("%nTotal of all 10 grades is %d%n", total);
		System.out.printf("Class average is %d%n", average);
	}

}// fim da classe ClassAverage
