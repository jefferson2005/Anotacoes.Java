package br.cpm.estruturas.atividades;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.estruturas.arquivos.GerarArquivo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class OrdemSRV extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtDataDeixado;
	private JTextField txtDataRetirada;
	private JTextField textField_1;
	private JTextField txtTecnico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdemSRV frame = new OrdemSRV();
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
	public OrdemSRV() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(OrdemSRV.class.getResource("/br/com/estruturas/imagens/9042845_pc_warning_icon.png")));
		setTitle("Ordem de Serviço");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(57, 11, 181, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 36, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(57, 36, 181, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 76, 60, 14);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(80, 73, 158, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JComboBox cboEquipamento = new JComboBox();
		cboEquipamento.setModel(new DefaultComboBoxModel(new String[] {"(Selecionar)", "Notebook", "Teclado", "Mouse", "Computador"}));
		cboEquipamento.setBounds(494, 7, 181, 18);
		contentPane.add(cboEquipamento);
		setLocationRelativeTo(null);//centraliza a janela
		
		JLabel lblEquipamento = new JLabel("Equipamento Com Problema:");
		lblEquipamento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEquipamento.setBounds(335, 11, 149, 14);
		contentPane.add(lblEquipamento);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 129, 665, 37);
		contentPane.add(scrollPane);
		
		JTextArea cboDiagnostico = new JTextArea();
		scrollPane.setViewportView(cboDiagnostico);
		
		JLabel lblDiagnostico = new JLabel("Diagnostico do Podruto:");
		lblDiagnostico.setBounds(10, 104, 158, 14);
		contentPane.add(lblDiagnostico);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 129, 663, 35);
		contentPane.add(textArea);
		
		JLabel lblSolução = new JLabel("Solução para o Equipamento:");
		lblSolução.setBounds(10, 176, 215, 14);
		contentPane.add(lblSolução);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 201, 665, 37);
		contentPane.add(scrollPane_1);
		
		JTextArea txtSolucao = new JTextArea();
		scrollPane_1.setViewportView(txtSolucao);
		
		JLabel lblData = new JLabel("Data em que o equipamento foi deixado:");
		lblData.setBounds(312, 36, 267, 14);
		contentPane.add(lblData);
		
		txtDataDeixado = new JTextField();
		txtDataDeixado.setBounds(589, 33, 86, 20);
		contentPane.add(txtDataDeixado);
		txtDataDeixado.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Data em que o equipamento deve ser retirado:");
		lblNewLabel.setBounds(312, 61, 283, 14);
		contentPane.add(lblNewLabel);
		
		txtDataRetirada = new JTextField();
		txtDataRetirada.setBounds(589, 58, 86, 20);
		contentPane.add(txtDataRetirada);
		txtDataRetirada.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor do Serviço:");
		lblValor.setBounds(10, 294, 109, 14);
		contentPane.add(lblValor);
		
		textField_1 = new JTextField();
		textField_1.setBounds(117, 291, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFuncionario = new JLabel("técnico responsável:");
		lblFuncionario.setBounds(347, 294, 158, 14);
		contentPane.add(lblFuncionario);
		
		txtTecnico = new JTextField();
		txtTecnico.setBounds(509, 291, 166, 20);
		contentPane.add(txtTecnico);
		txtTecnico.setColumns(10);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.setBounds(269, 348, 89, 23);
		contentPane.add(btnGravar);
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtNome.getText().trim().equals("") ||
						txtEmail.getText().trim().equals("")) {
						txtTelefone.getText().trim().equals("");
						txtDataRetirada.getText().trim().equals("");
						txtDataDeixado.getText().trim().equals("");
						txtTecnico.getText().trim().equals("");
						cboDiagnostico.getText().trim().equals("");
						txtSolucao.getText().trim().equals("");
						JOptionPane.showMessageDialog(null, "Você deve preencher os campos");
			}
				String j = txtNome.getText()+ "-" + txtEmail.getText()+ "-" + txtTelefone.getText() + "-" + txtDataDeixado.getText() + "-"+
						   txtDataRetirada.getText()+ "-" + cboDiagnostico.getText() + "-" + txtSolucao.getText()+ "-" + txtTecnico.getText();
						
				String i = txtNome.getText()+ txtTelefone.getText()+".txt";		   
				String s = GerarArquivo.gravar("D:/Jefferson/"+i, j);
				
				JOptionPane.showMessageDialog(null, s);
				
				
				
				
				
			}
		});
		
		}
}


