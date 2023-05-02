package br.com.poo.objetos.ui;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.poo.classes.ContaPoupanca;
import javax.swing.ImageIcon;

public class JanelaPoupanca extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroBanco;
	private JTextField txtNumeroAgencia;
	private JTextField txtNumeroConta;
	private JTextField txtTitularConta;
	private JTextField txtSaldoConta;
	private JTextField txtAniversario;
	private ContaPoupanca cp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPoupanca frame = new JanelaPoupanca();
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
	public JanelaPoupanca() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaPoupanca.class.getResource("/imagem/conta-digital-next_460-460.png")));
		setTitle("Poupança");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumeroBando = new JLabel("Número do Banco:");
		lblNumeroBando.setBounds(10, 11, 120, 14);
		contentPane.add(lblNumeroBando);
		
		JLabel lblNumeroAgencia = new JLabel("Número da Agência:");
		lblNumeroAgencia.setBounds(140, 11, 123, 14);
		contentPane.add(lblNumeroAgencia);
		
		JLabel lblNumeroConta = new JLabel("Número da Conta:");
		lblNumeroConta.setBounds(273, 11, 120, 14);
		contentPane.add(lblNumeroConta);
		
		txtNumeroBanco = new JTextField();
		txtNumeroBanco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//digitação...
				//definir caracteres permitidos
				String caracteres = "0123456789.";
				
				//se for digitando algum caracteres não permitido
				if (!caracteres.contains(e.getKeyChar() + "")){
					
					//ignorar
					e.consume();
			}
			}
		});
		txtNumeroBanco.setBounds(10, 36, 102, 20);
		contentPane.add(txtNumeroBanco);
		txtNumeroBanco.setColumns(10);
		
		txtNumeroAgencia = new JTextField();
		txtNumeroAgencia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//digitação...
				//definir caracteres permitidos
				String caracteres = "0123456789.";
				
				//se for digitando algum caracteres não permitido
				if (!caracteres.contains(e.getKeyChar() + "")){
					
					//ignorar
					e.consume();
			}
			}
		});
		txtNumeroAgencia.setBounds(140, 36, 112, 20);
		contentPane.add(txtNumeroAgencia);
		txtNumeroAgencia.setColumns(10);
		
		txtNumeroConta = new JTextField();
		txtNumeroConta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//digitação...
				//definir caracteres permitidos
				String caracteres = "0123456789.";
				
				//se for digitando algum caracteres não permitido
				if (!caracteres.contains(e.getKeyChar() + "")){
					
					//ignorar
					e.consume();
			}
			}
		});
		txtNumeroConta.setBounds(273, 36, 107, 20);
		contentPane.add(txtNumeroConta);
		txtNumeroConta.setColumns(10);
		
		JLabel lblTitularConta = new JLabel("Titular da Conta:");
		lblTitularConta.setBounds(10, 82, 130, 14);
		contentPane.add(lblTitularConta);
		
		txtTitularConta = new JTextField();
		txtTitularConta.setBounds(10, 107, 349, 20);
		contentPane.add(txtTitularConta);
		txtTitularConta.setColumns(10);
		
		JLabel lblSaldoConta = new JLabel("Saldo da Conta:");
		lblSaldoConta.setBounds(10, 154, 130, 14);
		contentPane.add(lblSaldoConta);
		
		txtSaldoConta = new JTextField();
		txtSaldoConta.setBounds(10, 179, 130, 20);
		contentPane.add(txtSaldoConta);
		txtSaldoConta.setColumns(10);
		
		JLabel lblAniversario = new JLabel("Aniverário:");
		lblAniversario.setBounds(260, 154, 120, 14);
		contentPane.add(lblAniversario);
		
		txtAniversario = new JTextField();
		txtAniversario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//digitação...
				//definir caracteres permitidos
				String caracteres = "0123456789.";
				
				//se for digitando algum caracteres não permitido
				if (!caracteres.contains(e.getKeyChar() + "")){
					
					//ignorar
					e.consume();
			}
			}
		});
		txtAniversario.setBounds(260, 179, 121, 20);
		contentPane.add(txtAniversario);
		txtAniversario.setColumns(10);
		
		JButton btnAbrirConta = new JButton("Abrir Conta");
		
		btnAbrirConta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAbrirConta.setBounds(10, 229, 133, 38);
		contentPane.add(btnAbrirConta);
		
		JButton bntVerificarSaldo = new JButton("Verificar Saldo");
		
		bntVerificarSaldo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bntVerificarSaldo.setBounds(260, 229, 133, 38);
		contentPane.add(bntVerificarSaldo);
		
		JButton bntDepositar = new JButton("Depositar");
		
		bntDepositar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bntDepositar.setBounds(10, 301, 133, 38);
		contentPane.add(bntDepositar);
		
		JButton bntSacar = new JButton("Sacar");
		
		bntSacar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bntSacar.setBounds(260, 301, 133, 38);
		contentPane.add(bntSacar);
		
		JTextArea txtResultado = new JTextArea();
		txtResultado.setBounds(10, 350, 380, 100);
		contentPane.add(txtResultado);
		
		
		
		btnAbrirConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campos();
				cp = new ContaPoupanca();
				String rs = cp.abrirConta(
						Long.parseLong(txtNumeroBanco.getText()),
						Long.parseLong(txtNumeroAgencia.getText()),
						Long.parseLong(txtNumeroConta.getText()),
						txtTitularConta.getText(),
						Double.parseDouble(txtSaldoConta.getText()));
				txtResultado.setText(rs);
				txtNumeroBanco.setEnabled(false);
				txtNumeroAgencia.setEnabled(false);
				txtNumeroConta.setEnabled(false);
				txtTitularConta.setEnabled(false);
				txtSaldoConta.setEnabled(false);
				btnAbrirConta.setEnabled(false);
			}
		});

		bntVerificarSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtResultado.setText(String.valueOf(cp.verificarSaldo()));
			}
		});	
		
		
		bntDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor = JOptionPane.showInputDialog("Digite o valor do depósito");
				txtResultado.setText(cp.depositar(Double.parseDouble(valor)));
			}
		});
		
		bntSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor = JOptionPane.showInputDialog("Digite o valor que deseja sacar");
				txtResultado.setText(cp.sacar(Double.parseDouble(valor)));
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
			JOptionPane.showMessageDialog(null, "Preencha o Número da conta");
			txtNumeroBanco.requestDefaultFocus();			
		}else if (txtAniversario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o seu Anivesário");
			txtAniversario.requestDefaultFocus();
			
		}else {
			
		}
	
	}
}
