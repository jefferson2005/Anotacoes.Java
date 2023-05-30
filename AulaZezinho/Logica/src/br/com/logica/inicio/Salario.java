package br.com.logica.inicio;

import java.util.Scanner;

public class Salario {

	public static void main(String[] args) {
		

		double salario, convenio, transporte, desconto, total;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite seu salário: ");
		salario = entrada.nextDouble();
		
		
		convenio = salario * (7.0 / 100);
		transporte = salario * (6.22 / 100);
		total = salario - convenio - transporte; 
		
		System.out.println("Desconto de 7% do Convênio Médico: " + convenio);
		System.out.println("Desconto de 6,22% do Vale Transporte: " + transporte);
		System.out.println("O Valor Total dos Descontos será: " + (transporte + convenio));
		System.out.println("O Salário final será: " + total);
		
		
		
	}

}
