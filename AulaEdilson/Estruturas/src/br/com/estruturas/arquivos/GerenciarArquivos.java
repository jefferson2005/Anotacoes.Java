package br.com.estruturas.arquivos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GerenciarArquivos extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeArquivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarArquivos frame = new GerenciarArquivos();
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
	public GerenciarArquivos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GerenciarArquivos.class.getResource("/br/com/estruturas/imagens/2695599_sobbing_emoticon_crying_emojis_icon.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConteudo = new JLabel("Conteúdo");
		lblConteudo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblConteudo.setBounds(10, 84, 185, 51);
		contentPane.add(lblConteudo);
		
		JLabel lblNomeArquivo = new JLabel("Nome do Arquivo");
		lblNomeArquivo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNomeArquivo.setBounds(10, 11, 161, 51);
		contentPane.add(lblNomeArquivo);
		
		txtNomeArquivo = new JTextField();
		txtNomeArquivo.setBounds(194, 11, 230, 35);
		contentPane.add(txtNomeArquivo);
		txtNomeArquivo.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(422, 134, -422, 116);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(419, 134, -419, 116);
		contentPane.add(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 146, 404, 104);
		contentPane.add(scrollPane_1);
		
		JTextArea txtConteudo = new JTextArea();
		scrollPane_1.setViewportView(txtConteudo);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(20, 146, 404, 104);
		contentPane.add(textArea_1);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtNomeArquivo.getText().trim().equals("") ||
					txtConteudo.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Você deve preencher os campos");
				}
				String s = GerarArquivo.gravar(txtNomeArquivo.getText(),txtConteudo.getText());
				JOptionPane.showMessageDialog(null, s);
			}
			
			
		});
		btnGravar.setBounds(335, 113, 89, 23);
		contentPane.add(btnGravar);
		
		JComboBox cboCidades = new JComboBox();
		cboCidades.setModel(new DefaultComboBoxModel(new String[] {"São Paulo", "Guarulhos", "Osasco", "Florianópolis", "Leme", "Camspinas", "Palmas", "Natal", "Porto Seguro"}));
		cboCidades.setBounds(10, 62, 253, 23);
		contentPane.add(cboCidades);
		setLocationRelativeTo(null);//centraliza a janela
	}
}
