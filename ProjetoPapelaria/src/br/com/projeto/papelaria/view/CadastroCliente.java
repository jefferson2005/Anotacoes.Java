package br.com.projeto.papelaria.view;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.projeto.papelaria.dominio.Tipo;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class CadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtLougradouro;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCep;
	private JTextField txtComplemento;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
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
	public CadastroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(285, 85, 46, 14);
		contentPane.add(lblCpf);
		MaskFormatter msf = null;
		try { msf = new MaskFormatter("###.###.###.##");}
		catch(Exception e ) {e.printStackTrace();}
		JFormattedTextField formattedCpf = new JFormattedTextField(msf);
		formattedCpf.setBounds(284, 99, 126, 20);
		contentPane.add(formattedCpf);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(285, 34, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(285, 54, 125, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Tipo.values()));
		comboBox.setBounds(10, 30, 125, 22);
		contentPane.add(comboBox);
		
		JLabel lblLougradouro = new JLabel("Lougradouro:");
		lblLougradouro.setBounds(10, 75, 107, 14);
		contentPane.add(lblLougradouro);
		
		txtLougradouro = new JTextField();
		txtLougradouro.setBounds(10, 99, 86, 20);
		contentPane.add(txtLougradouro);
		txtLougradouro.setColumns(10);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setBounds(127, 75, 101, 14);
		contentPane.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(127, 99, 46, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 134, 46, 14);
		contentPane.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(10, 159, 86, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(127, 134, 46, 14);
		contentPane.add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setBounds(127, 159, 52, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(10, 206, 86, 14);
		contentPane.add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(10, 230, 86, 20);
		contentPane.add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setBounds(10, 0, 46, 14);
		contentPane.add(lblEndereco);
		
		JLabel lblDados = new JLabel("Dados");
		lblDados.setBounds(285, 0, 46, 14);
		contentPane.add(lblDados);
		
		JLabel lblContato = new JLabel("Contato");
		lblContato.setBounds(285, 137, 46, 14);
		contentPane.add(lblContato);
		
		JLabel lblFone = new JLabel("Telefone:");
		lblFone.setBounds(285, 162, 86, 14);
		contentPane.add(lblFone);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(285, 206, 46, 14);
		contentPane.add(lblEmail);
		
		JTextField txtFone = new JTextField();
		txtFone.setBounds(285, 175, 86, 20);
		contentPane.add(txtFone);
		txtFone.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(285, 230, 86, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.setBounds(153, 227, 89, 23);
		contentPane.add(btnGravar);
		

	
	}
}
