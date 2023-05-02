package br.com.poo.objetos;

import javax.swing.JOptionPane;

import br.com.poo.classes.Clientes;

public class UsarCliente {

	public static void main(String[] args) {
			Clientes cli = new Clientes();		
			cli.setIdCliente(10);
			cli.setNomeCliente("Wagner");
			cli.setEmailCliente("Wagner@terra.com.br");
			cli.setIdadeCliente(23);
			cli.setCpfCliente("111.444.777-35");
			
			String retorno = cli.cadastro();
			JOptionPane.showMessageDialog(null, retorno);
		}

}
