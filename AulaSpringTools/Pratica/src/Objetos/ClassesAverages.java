package Objetos;

import java.util.Scanner;

public class ClassesAverages {

	public static void main(String[] args) {

		// cria Scanner para obter entrada a partir da janela de comando
		Scanner input = new Scanner(System.in);
		
		// fase de inicialização
		int total = 0; // inicializa a soma das notas
		int gradeCounter = 0; // inicializa o nº de notas inseridas até agora
		
		// fase de processamento 
		// solicita entrada e lê a nota do usuário
		System.out.println("Enter grade or -1 to quit: ");
		int grade = input.nextInt();
		
		// fa um loop até ler o valor de sentinela inserido pelo usuário
		while (grade != -1)
		{
			total = total + grade; // adiciona grande o total
			gradeCounter = gradeCounter + 1; // incrementa counter
			
		// solicita entrada e lê a próxima nota fornecida pelo usuário
			System.out.println("Enter grade or -1 to quit: ");
			grade = input.nextInt();
		}
		
		// fase de término
		// se usuário inseriu pelo menos uma nota...
		if (gradeCounter != 0)
		{
			// usa número com ponto decimal para calcular média das outras
			double average = (double) total / gradeCounter;
			
			// exibe o tatal e a média (com dois digitos de precisão)
			System.out.printf("%nTotal of the %d grades entered is %d%n",
					gradeCounter, total);
			System.out.printf("Class average is %.2f%n", average);
		}
		else // nenhuma nota foi inserida, assim gera a saida da mensagem apropriada
			System.out.println("No grades were entered");
		
	}

}// fim da classe ClassAverages
