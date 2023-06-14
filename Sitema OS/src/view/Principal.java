package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import model.DAO;
import java.awt.Color;
import java.awt.Font;

public class Principal extends JFrame {
	
	//Instanciar objetos JDBC
		DAO dao = new DAO();
		private Connection con;
		private PreparedStatement pst;
		private ResultSet rs;	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblStatus;
	private JLabel lblData;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
				setarData();
			}

			private void status() {
				try {
					//abrir a conexão 
					con = dao.conectar();
					if (con == null) {
						//System.out.println("Erro de conexão");
						lblStatus.setIcon(new ImageIcon(Usuarios.class.getResource("/img/dboff.png")));
					} else {
						//System.out.println("Banco conectado");
						lblStatus.setIcon(new ImageIcon(Usuarios.class.getResource("/img/2124501_app_check_data_essential_ui_icon.png")));
					}
					// NUNCA esquecer de fechar a conexão 
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}//Fim do método status()
			
				/**
				 * Método responsável por setar a data do rodapé 
				 */
				private void setarData() {
					Date date = new Date();
					//Criar objeto para formatar a data
					DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
					//alterar o texto da label pela data atual formatada
					lblData.setText(formatador.format(date));
		
				}	
				
		});
		setTitle("Sistema - Hospital de brinquedos");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/993813_matreshka_matrioshka_mother_open_souvenir_icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 215, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblStatus = new JLabel("");
		lblStatus.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
			{
			}
		});
		
		lblData = new JLabel("New label");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblData.setBounds(10, 393, 437, 26);
		contentPane.add(lblData);
		lblStatus.setBounds(550, 360, 74, 91);
		lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/2124505_app_data_essential_ui_icon.png")));
		lblStatus.setToolTipText("DBon");
		contentPane.add(lblStatus);
		
		JButton bntUsuarios = new JButton("");
		bntUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//abrir a tela de Usuaríos
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
			}
		});
		bntUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bntUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/img/usuarios (2).png")));
		bntUsuarios.setToolTipText("Usuaríos");
		bntUsuarios.setBounds(431, 80, 64, 64);
		contentPane.add(bntUsuarios);
		
		JButton bntSobre = new JButton("");
		bntSobre.setContentAreaFilled(false);
		bntSobre.setBorder(null);
		bntSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bntSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);

			}
		});
		bntSobre.setIcon(new ImageIcon(Principal.class.getResource("/img/about.png")));
		bntSobre.setToolTipText("Sobre");
		bntSobre.setBounds(566, 11, 48, 48);
		contentPane.add(bntSobre);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/Hospital.png")));
		lblNewLabel.setBounds(230, 11, 133, 122);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(255, 91, 91));
		lblNewLabel_1.setBounds(0, 360, 624, 81);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNomeEmpresa = new JLabel("Toys Help");
		lblNomeEmpresa.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNomeEmpresa.setBounds(252, 140, 92, 26);
		contentPane.add(lblNomeEmpresa);
		
		JButton btnClientes = new JButton("");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes();
				clientes.setVisible(true);
			}
		});
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setToolTipText("Clientes");
		btnClientes.setIcon(new ImageIcon(Principal.class.getResource("/img/User.png")));
		btnClientes.setBounds(78, 80, 64, 64);
		contentPane.add(btnClientes);
		
		JButton btnOrdemSRV = new JButton("");
		btnOrdemSRV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Servicos servico = new Servicos();
				servico.setVisible(true);
			}
		});
		btnOrdemSRV.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOrdemSRV.setIcon(new ImageIcon(Principal.class.getResource("/img/OrdemSRV.png")));
		btnOrdemSRV.setToolTipText("Ordem de Serviço");
		btnOrdemSRV.setBounds(147, 186, 64, 64);
		contentPane.add(btnOrdemSRV);
		
		JButton btnRelatorio = new JButton("");
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios relatorios = new Relatorios();
				relatorios.setVisible(true);	
			}
		});
		btnRelatorio.setIcon(new ImageIcon(Principal.class.getResource("/img/Relatorio (2).png")));
		btnRelatorio.setToolTipText("Relátorio");
		btnRelatorio.setBounds(365, 186, 64, 64);
		contentPane.add(btnRelatorio);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(21, 240, 92, 101);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(503, 186, 98, 101);
		contentPane.add(lblNewLabel_3);
	}
}

