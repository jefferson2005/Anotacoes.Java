package br.com.logica.desvioif;

import javax.swing.JOptionPane;

public class estruturaIF2 {

	public static void main(String[] args) {
		
		//Vamos criar um progama para calcular a média do aluno.
		//Teremos de inserir 4 notas, calcular a média destas 4
		//e exibir o resultado ao final
		
		double nota1,nota2,nota3,nota4,media;
		
		nota1 = Double.parseDouble (JOptionPane.showInputDialog("Digite a primeira nota"));
		
		nota2 = Double.parseDouble (JOptionPane.showInputDialog("Digite a segunda nota"));
		
		nota3 = Double.parseDouble (JOptionPane.showInputDialog("Digite a terceira nota"));
		
		nota4 = Double.parseDouble (JOptionPane.showInputDialog("Digite a quarta nota"));
		
		media = (nota1 + nota2 + nota3 + nota4) /4;
		
		if (media >= 5)
			JOptionPane.showMessageDialog(null, "A média do aluno é "+media+" ele está Aprovado");
		else
			JOptionPane.showMessageDialog(null, "A média do aluno é "+media+" ele está Reprovado");
		
				

	}

}
