package br.com.projeto.papelaria.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.projeto.papelaria.dao.DAOUsuario;
import br.com.projeto.papelaria.dominio.Usuario;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Logar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeUsuario = new JLabel("Nome de Usuário:");
		lblNomeUsuario.setBounds(10, 40, 117, 14);
		contentPane.add(lblNomeUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(54, 100, 46, 14);
		contentPane.add(lblSenha);
		
		JButton btnLogar = new JButton("Logar");
		
		btnLogar.setBounds(77, 175, 89, 23);
		contentPane.add(btnLogar);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(125, 37, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(125, 97, 86, 20);
		contentPane.add(txtSenha);
		
		getRootPane().setDefaultButton(btnLogar);
		
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Usuario us = new Usuario();
				us.setNomeUsuario(txtUsuario.getText()); 
				us.setSenha(txtSenha.getText());
				
				DAOUsuario du = new DAOUsuario();
				if(du.logar(us)) {
					Principal p = new Principal();
					p.setState(MAXIMIZED_BOTH);
					p.setVisible(true);
					setVisible(true);
					
					setVisible(false);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto");
				}
			}
		});
		
		
	}//Fim do construtor

}//Fim do codigo
