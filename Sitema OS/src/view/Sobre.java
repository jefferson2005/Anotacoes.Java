package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class Sobre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/993813_matreshka_matrioshka_mother_open_souvenir_icon.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		setModal(true);
		setTitle("Sobre");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("sistema OS");
		lblNewLabel.setBounds(10, 68, 215, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Autor: Jefferson L");
		lblNewLabel_1.setBounds(10, 236, 152, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sob a licença MIT:");
		lblNewLabel_2.setBounds(302, 122, 122, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("MIT");
		lblNewLabel_3.setBounds(285, 122, 128, 128);
		lblNewLabel_3.setIcon(new ImageIcon(Sobre.class.getResource("/img/mit-icon.png")));
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gestão de serviços Hospital de Brinquedos");
		lblNewLabel_4.setBounds(10, 11, 398, 22);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel_4);

	}
}
