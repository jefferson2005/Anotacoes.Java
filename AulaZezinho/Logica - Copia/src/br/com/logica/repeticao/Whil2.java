package br.com.logica.repeticao;

import javax.swing.JOptionPane;

public class Whil2 {

	public static void main(String[] args) {

		String texto = JOptionPane.showInputDialog("Digite sair para fechar");
		
		while(!texto.equals("sair")) {
			JOptionPane.showMessageDialog(null, "Você digitou o texto errado");
			
			texto = JOptionPane.showInputDialog("Digite sair para fechar");
			
			
			 
		}
		
	}

}
