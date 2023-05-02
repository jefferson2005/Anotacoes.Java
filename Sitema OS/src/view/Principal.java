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
						lblStatus.setIcon(new ImageIcon(Usuarios.class.getResource("/img/2124505_app_data_essential_ui_icon.png")));
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
		lblData.setBounds(10, 393, 274, 26);
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
		bntUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/img/309041_users_group_people_icon (1).png")));
		bntUsuarios.setToolTipText("Usuaríos");
		bntUsuarios.setBounds(433, 59, 122, 130);
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
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/8960622_hospital_sign_cross_health_pharmacy_icon.png")));
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
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setToolTipText("Clientes");
		btnClientes.setIcon(new ImageIcon(Principal.class.getResource("/img/4850490_clients_communication_discussion_media_social_icon (1).png")));
		btnClientes.setBounds(49, 59, 122, 130);
		contentPane.add(btnClientes);
		
		JButton btnOrdemSRV = new JButton("");
		btnOrdemSRV.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOrdemSRV.setIcon(new ImageIcon(Principal.class.getResource("/img/3709732_call_performance_report_service_statistics_icon.png")));
		btnOrdemSRV.setToolTipText("Ordem de Serviço");
		btnOrdemSRV.setBounds(151, 200, 128, 128);
		contentPane.add(btnOrdemSRV);
		
		JButton btnRelatorio = new JButton("");
		btnRelatorio.setIcon(new ImageIcon(Principal.class.getResource("/img/3709751_complaint_dissatisfaction_expression_feedback_report_icon (1).png")));
		btnRelatorio.setToolTipText("Relátorio");
		btnRelatorio.setBounds(319, 200, 128, 128);
		contentPane.add(btnRelatorio);
	}
}

