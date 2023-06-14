package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class Fornecedor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtEmail;
	private JTextField txtCpf;
	private JTextField txtCep;
	private JTextField txtendereco;
	private JTextField txtComplemento;
	private JTextField txt;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Fornecedor dialog = new Fornecedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Fornecedor() {
		setBounds(100, 100, 690, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(27, 363, 89, 23);
		contentPanel.add(btnAdicionar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(126, 363, 89, 23);
		contentPanel.add(btnExcluir);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(227, 363, 89, 23);
		contentPanel.add(btnEditar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(335, 363, 89, 23);
		contentPanel.add(btnLimpar);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(26, 21, 46, 14);
		contentPanel.add(lblID);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(26, 46, 46, 14);
		contentPanel.add(lblNome);
		
		JLabel lblFone = new JLabel("Telefone");
		lblFone.setBounds(26, 71, 46, 14);
		contentPanel.add(lblFone);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(26, 96, 46, 14);
		contentPanel.add(lblEmail);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(26, 121, 46, 14);
		contentPanel.add(lblCpf);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(26, 145, 46, 14);
		contentPanel.add(lblCep);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(26, 177, 62, 14);
		contentPanel.add(lblEndereco);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setBounds(98, 21, 46, 14);
		contentPanel.add(lblNumero);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(98, 46, 95, 14);
		contentPanel.add(lblComplemento);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(98, 81, 95, 14);
		contentPanel.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(98, 108, 95, 14);
		contentPanel.add(lblCidade);
		
		JLabel lblUF = new JLabel("UF:");
		lblUF.setBounds(98, 133, 46, 14);
		contentPanel.add(lblUF);
		
		JComboBox cboUF = new JComboBox();
		cboUF.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboUF.setBounds(585, 17, 62, 23);
		contentPanel.add(cboUF);
		
		txtID = new JTextField();
		txtID.setBounds(227, 18, 86, 20);
		contentPanel.add(txtID);
		txtID.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(227, 53, 86, 20);
		contentPanel.add(txtNome);
		txtNome.setColumns(10);
		
		txtFone = new JTextField();
		txtFone.setBounds(227, 93, 86, 20);
		contentPanel.add(txtFone);
		txtFone.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(227, 130, 86, 20);
		contentPanel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(227, 161, 86, 20);
		contentPanel.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtCep = new JTextField();
		txtCep.setBounds(227, 192, 86, 20);
		contentPanel.add(txtCep);
		txtCep.setColumns(10);
		
		txtendereco = new JTextField();
		txtendereco.setBounds(335, 18, 86, 20);
		contentPanel.add(txtendereco);
		txtendereco.setColumns(10);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(335, 53, 86, 20);
		contentPanel.add(txtComplemento);
		txtComplemento.setColumns(10);
		
		txt = new JTextField();
		txt.setBounds(338, 93, 86, 20);
		contentPanel.add(txt);
		txt.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(335, 121, 86, 20);
		contentPanel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(335, 161, 86, 20);
		contentPanel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(335, 192, 86, 20);
		contentPanel.add(textField_11);
	}
}
