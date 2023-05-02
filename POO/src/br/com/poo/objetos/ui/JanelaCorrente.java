package br.com.poo.objetos.ui;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.poo.classes.ContaCorrente;
import br.com.poo.classes.ContaPoupanca;
import javax.swing.ImageIcon;

public class JanelaCorrente extends JFrame {

	private JPanel contentPane; 
	private JTextField txtNumeroBanco;
	private JTextField txtNumeroAgencia;
	private JTextField txtNumeroConta;
	private JTextField txtTitularConta;
	private JTextField txtSaldoConta;
	private JTextField txtLimite;
	private JTextField txtResultado;
	private ContaCorrente cc;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCorrente frame = new JanelaCorrente();
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
	public JanelaCorrente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaCorrente.class.getResource("/imagem/conta-digital-next_460-460.png")));
		setTitle("Correntes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBanco = new JLabel("Número Banco:");
		lblBanco.setBounds(10, 14, 97, 14);
		contentPane.add(lblBanco);
		
		JLabel lblAgencia = new JLabel("Número da Agência:");
		lblAgencia.setBounds(149, 14, 107, 14);
		contentPane.add(lblAgencia);
		
		JLabel lblNumeroConta = new JLabel("Número da Conta:");
		lblNumeroConta.setBounds(282, 14, 101, 14);
		contentPane.add(lblNumeroConta);
		
		txtNumeroBanco = new JTextField();
		txtNumeroBanco.setBounds(10, 41, 86, 20);
		contentPane.add(txtNumeroBanco);
		txtNumeroBanco.setColumns(10);
		
		txtNumeroAgencia = new JTextField();
		txtNumeroAgencia.setBounds(147, 41, 86, 20);
		contentPane.add(txtNumeroAgencia);
		txtNumeroAgencia.setColumns(10);
		
		txtNumeroConta = new JTextField();
		txtNumeroConta.setBounds(282, 41, 86, 20);
		contentPane.add(txtNumeroConta);
		txtNumeroConta.setColumns(10);
		
		JLabel lbTitularConta = new JLabel("Titular da Conta:");
		lbTitularConta.setBounds(10, 91, 113, 14);
		contentPane.add(lbTitularConta);
		
		txtTitularConta = new JTextField();
		txtTitularConta.setBounds(10, 116, 383, 20);
		contentPane.add(txtTitularConta);
		txtTitularConta.setColumns(10);
		
		JLabel lblSaldoConta = new JLabel("Saldo da Conta:");
		lblSaldoConta.setBounds(26, 162, 97, 14);
		contentPane.add(lblSaldoConta);
		
		txtSaldoConta = new JTextField();
		txtSaldoConta.setBounds(21, 187, 86, 20);
		contentPane.add(txtSaldoConta);
		txtSaldoConta.setColumns(10);
		
		JLabel lblLimite = new JLabel("Limite:");
		lblLimite.setBounds(309, 162, 46, 14);
		contentPane.add(lblLimite);
		
		txtLimite = new JTextField();
		txtLimite.setBounds(307, 187, 86, 20);
		contentPane.add(txtLimite);
		txtLimite.setColumns(10);
		
		JButton btnAbrirConta = new JButton("Abrir Conta");
		
		btnAbrirConta.setBounds(18, 233, 118, 23);
		contentPane.add(btnAbrirConta);
		
		JButton btnDepositar = new JButton("Depositar");
		
		btnDepositar.setBounds(18, 293, 118, 23);
		contentPane.add(btnDepositar);
		
		JButton btnVerificarSaldo = new JButton("Verificar Saldo");
		
		btnVerificarSaldo.setBounds(285, 233, 113, 23);
		contentPane.add(btnVerificarSaldo);
		
		JButton btnSacar = new JButton("Sacar");
		
		btnSacar.setBounds(285, 293, 113, 23);
		contentPane.add(btnSacar);
		
		txtResultado = new JTextField();
		txtResultado.setBounds(10, 327, 414, 123);
		contentPane.add(txtResultado);
		txtResultado.setColumns(10);
		
		btnAbrirConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campos();
				cc = new ContaCorrente();
				String rs = cc.abrir(
						Long.parseLong(txtNumeroBanco.getText()),
						Long.parseLong(txtNumeroAgencia.getText()),
						Long.parseLong(txtNumeroConta.getText()),
						txtTitularConta.getText(),
						Double.parseDouble(txtSaldoConta.getText()),
						Double.parseDouble(txtLimite.getText()));
				txtResultado.setText(rs);
				txtNumeroBanco.setEnabled(false);
				txtNumeroAgencia.setEnabled(false);
				txtNumeroBanco.setEnabled(false);
				txtTitularConta.setEnabled(false);
				txtSaldoConta.setEnabled(false);
				btnAbrirConta.setEnabled(false);
			}
		});
		
		btnVerificarSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtResultado.setText(String.valueOf(cc.verificarSaldo()));
			}
		});
		
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor = JOptionPane.showInputDialog("Digite o valor do depósito");
				txtResultado.setText(cc.depositar(Double.parseDouble(valor)));
			}
		});
		
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor = JOptionPane.showInputDialog("Digite o valor que deseja sacar");
				txtResultado.setText(cc.sacar(Double.parseDouble(valor)));
			}
		});
		
		
		
	
	}
	private void campos() {
		// teste do botão calcular
		// System.out.println("teste");

		if (txtNumeroConta.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preeencha o Número da conta");
			txtNumeroConta.requestDefaultFocus();
		} else if (txtNumeroAgencia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Número da agência");
			txtNumeroAgencia.requestDefaultFocus();
		} else if (txtNumeroBanco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Número do Banco");
			txtNumeroBanco.requestDefaultFocus();			
		}else if (txtLimite.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o seu Limite");
			txtLimite.requestDefaultFocus();
			
		}else {
			
		}
	
}
}
