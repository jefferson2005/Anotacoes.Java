package br.com.view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.dao.CRUDChamado;
import br.com.dominio.Chamado;
import javax.swing.JFormattedTextField;

public class SistemaSA extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtResponsavel;
	CRUDChamado cc = new CRUDChamado();
	private JFormattedTextField txtDataResolucao;
	private JLabel lblExcluir;
	private JTextPane txtObs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaSA frame = new SistemaSA();
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
	public SistemaSA() {
		setTitle("Sistema de Suporte - Atendente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblChamado = new JLabel("ID do Chamado:");
		lblChamado.setBounds(171, 31, 117, 14);
		contentPane.add(lblChamado);

		JLabel lblStatus = new JLabel("Status Chamado");
		lblStatus.setBounds(384, 31, 99, 14);
		contentPane.add(lblStatus);

		JLabel lblData = new JLabel("Data de resolucão do chamado:");
		lblData.setBounds(171, 118, 182, 14);
		contentPane.add(lblData);

		JLabel lblResponsavel = new JLabel("Responsável do Chamado:");
		lblResponsavel.setBounds(384, 118, 140, 14);
		contentPane.add(lblResponsavel);

		JLabel lblObservacoes = new JLabel("Observações:");
		lblObservacoes.setBounds(307, 182, 74, 14);
		contentPane.add(lblObservacoes);

		lblExcluir = new JLabel("Excluir Chamado");
		lblExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CRUDChamado cc = new CRUDChamado();

				if (txtID.equals(null)) {
					JOptionPane.showMessageDialog(null, "Selecione o chamado a ser excluído.", "Erro 4000770x",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (JOptionPane.showConfirmDialog(null,
							"Você tem certeza desta ação? \nEstá ação é  permanente " + "e não pode ser desfeita",
							"ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0) {

						Chamado cr = new Chamado();
						cr.setIdChamado(Long.parseLong(txtID.getText()));
						JOptionPane.showMessageDialog(null, cc.apagar(cr));
					}
				}
			}
		});
		lblExcluir.setBounds(24, 182, 129, 14);
		contentPane.add(lblExcluir);

		JLabel lblAtualizar = new JLabel("Atualizar Chamado");
		lblAtualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chamado cr = new Chamado();

				if (txtResponsavel.getText().trim().equals("") || txtResponsavel.getText().trim().equals("")
						|| txtID.getText().trim().equals("") || txtDataResolucao.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Os campos Responsável Chamado, Id do Chamado, Status do Chamado e Data de Resolução devem ser preenchidos",
							"Erro 4000765x", JOptionPane.ERROR_MESSAGE);
				} else {

					cr.setDataResolucao(String.valueOf(txtDataResolucao.getText()));
					cr.setStatusChamado(txtResponsavel.getText().toString());
					cr.setAtendente(txtResponsavel.getText());
					cr.setObservacoes(txtObs.getText());
					cr.setIdChamado(Long.parseLong(txtID.getText()));
					cc.atualizar(cr);
					JOptionPane.showMessageDialog(null, "Chamado Atualizado");
				}
			}
		});
		lblAtualizar.setBounds(24, 142, 129, 14);
		contentPane.add(lblAtualizar);

		txtID = new JTextField();
		txtID.setBounds(171, 56, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);

		txtResponsavel = new JTextField();
		txtResponsavel.setBounds(384, 143, 86, 20);
		contentPane.add(txtResponsavel);
		txtResponsavel.setColumns(10);

		JComboBox cboStatus = new JComboBox();
		cboStatus.setModel(new DefaultComboBoxModel(new String[] { "Aberto", "Resolvido", "Pendente" }));
		cboStatus.setBounds(384, 56, 129, 20);
		contentPane.add(cboStatus);

		txtObs = new JTextPane();
		txtObs.setBounds(183, 209, 325, 117);
		contentPane.add(txtObs);

		MaskFormatter msf = null;
		try {
			msf = new MaskFormatter("##/##/####");
		} catch (Exception e) {
			e.printStackTrace();
		}

		txtDataResolucao = new JFormattedTextField(msf);
		txtDataResolucao.setBounds(171, 139, 86, 20);
		contentPane.add(txtDataResolucao);
	}
}
