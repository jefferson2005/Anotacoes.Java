package br.com.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.dao.CRUDChamado;
import br.com.dominio.Chamado;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFormattedTextField;

public class SistemaSuporte extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDepartamento;
	private JTextField txtDescricao;
	CRUDChamado cc = new CRUDChamado();
	private JFormattedTextField txtDataAbertura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaSuporte frame = new SistemaSuporte();
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
	public SistemaSuporte() {
		setTitle("Sistema de Suporte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAviso = new JLabel("Preencha todos os campos para efetuar um chamado");
		lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAviso.setBounds(10, 11, 424, 14);
		contentPane.add(lblAviso);

		JLabel lblNome = new JLabel("Insira seu nome:");
		lblNome.setBounds(213, 48, 119, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(213, 73, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblInforme = new JLabel("Informe com qual departamento deseja falar: ");
		lblInforme.setBounds(213, 118, 221, 14);
		contentPane.add(lblInforme);

		txtDepartamento = new JTextField();
		txtDepartamento.setBounds(213, 143, 86, 20);
		contentPane.add(txtDepartamento);
		txtDepartamento.setColumns(10);

		JLabel lblContenos = new JLabel("Conte-nos mais sobre sei problema:");
		lblContenos.setBounds(213, 191, 205, 14);
		contentPane.add(lblContenos);

		JLabel lblRegistrar = new JLabel("Registrar chamado");
		lblRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chamado soliChamado = new Chamado();
				{

					if (txtNome.getText().trim().equals("") || 
						txtDepartamento.getText().trim().equals("") ||
						txtDescricao.getText().trim().equals("") || 
						txtDataAbertura.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro 4000765x",
								JOptionPane.ERROR_MESSAGE);
					} else {

						soliChamado.setSolicitacao(txtNome.getText());

						soliChamado.setDepSolicitado(txtDepartamento.getText());

						soliChamado.setDescChamado(txtDescricao.getText());
						
						soliChamado.setDataAbertura(txtDataAbertura.getText());

						JOptionPane.showMessageDialog(null, cc.registrar(soliChamado));

					}
				}
			}}
		);
		lblRegistrar.setBounds(42, 146, 119, 14);
		contentPane.add(lblRegistrar);
		txtDescricao = new JTextField();
		txtDescricao.setBounds(213, 217, 298, 108);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblData = new JLabel("Data de Abertura:");
		lblData.setBounds(372, 48, 119, 14);
		contentPane.add(lblData);
		
		MaskFormatter msf = null;
		try { msf = new MaskFormatter("##/##/####");}
		catch(Exception e ) {e.printStackTrace();}
		
		txtDataAbertura = new JFormattedTextField(msf);
		txtDataAbertura.setBounds(372, 73, 119, 20);
		contentPane.add(txtDataAbertura);
		}

}

