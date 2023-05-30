package br.com.poo.objetos.ui;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GerenciarContas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarContas frame = new GerenciarContas();
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
	public GerenciarContas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GerenciarContas.class.getResource("/imagem/conta-digital-next_460-460.png")));
		setTitle("Gerenciar Contas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mmuAberturaConta = new JMenu("Abertura de Conta");
		menuBar.add(mmuAberturaConta);
		
		JMenuItem mnPoupanca = new JMenuItem("Conta Poupança");
		mnPoupanca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaPoupanca poupanca = new JanelaPoupanca();
				poupanca.setVisible(true);
			}
		});
		mnPoupanca.setIcon(new ImageIcon(GerenciarContas.class.getResource("/imagem/3319597_bank_banking_safe_secure_icon.png")));
		mmuAberturaConta.add(mnPoupanca);
		
		JMenuItem mnCorrente = new JMenuItem("Conta Corrente");
		mnCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaCorrente corrente = new JanelaCorrente();
				corrente.setVisible(true);
			}
		});
		mnCorrente.setIcon(new ImageIcon(GerenciarContas.class.getResource("/imagem/3319627_banking_coin_dollar_money_transfer_icon.png")));
		mmuAberturaConta.add(mnCorrente);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GerenciarContas.class.getResource("/imagem/unnamed.png")));
		lblNewLabel.setBounds(0, 0, 484, 239);
		contentPane.add(lblNewLabel);
	}
}
