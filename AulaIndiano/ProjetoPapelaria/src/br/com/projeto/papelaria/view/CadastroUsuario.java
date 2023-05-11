package br.com.projeto.papelaria.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.projeto.papelaria.dao.DAOUsuario;
import br.com.projeto.papelaria.dominio.Usuario;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroUsuario extends JFrame {
	
	DAOUsuario DAO = new DAOUsuario();

	private JPanel contentPane;
	private JTextField txtUsuario;
	
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	private final JPasswordField txtSenha = new JPasswordField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario();
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
	public CadastroUsuario() {
		setTitle("Cadastro Usuário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome de Usuário:");
		lblNome.setBounds(10, 28, 88, 14);
		contentPane.add(lblNome);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 74, 46, 14);
		contentPane.add(lblSenha);
		
		JLabel lblNivel = new JLabel("Nivel Acesso:");
		lblNivel.setBounds(10, 121, 88, 14);
		contentPane.add(lblNivel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(111, 25, 113, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JComboBox cboNivel = new JComboBox();
		cboNivel.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Usuario", "Operator", "Sales"}));
		cboNivel.setBounds(111, 113, 113, 22);
		contentPane.add(cboNivel);
		
		JButton btnGravar = new JButton("Gravar");
		
		btnGravar.setBounds(135, 199, 89, 23);
		contentPane.add(btnGravar);
		txtSenha.setBounds(111, 71, 113, 20);
		contentPane.add(txtSenha);
		
		
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario us = new Usuario();
				us.setNomeUsuario(txtUsuario.getText());
				us.setSenha(txtSenha.getText());
				us.setNivelAcesso(cboNivel.getSelectedItem().toString());
				DAOUsuario du = new DAOUsuario();
				JOptionPane.showMessageDialog(null, du.cadastro(us));
				
			}
		});
	}//Fim do construtor
}//Fim do codigo