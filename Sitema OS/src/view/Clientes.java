package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.DAO;

public class Clientes extends JDialog {
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtEmail;
	private JTextField txtCpf;
	private JTextField txtID;
	
	// Instanciar objetos JDBC
		DAO dao = new DAO();
		private Connection con;
		private PreparedStatement pst;
		private ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes dialog = new Clientes();
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
	public Clientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/img/Cadastro Clientes.png")));
		setTitle("Cadastro Clientes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 44, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblFone = new JLabel("Telefone:");
		lblFone.setBounds(10, 119, 57, 14);
		getContentPane().add(lblFone);
		
		JLabel lblemail = new JLabel("E-mail:");
		lblemail.setBounds(10, 152, 46, 14);
		getContentPane().add(lblemail);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 80, 46, 14);
		getContentPane().add(lblCpf);
		
		txtNome = new JTextField();
		txtNome.setBounds(74, 41, 110, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtFone = new JTextField();
		txtFone.setBounds(74, 116, 110, 20);
		getContentPane().add(txtFone);
		txtFone.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(74, 149, 110, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(74, 77, 110, 20);
		getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.setBorderPainted(false);
		btnPesquisar.setDefaultCapable(false);
		btnPesquisar.setContentAreaFilled(false);
		btnPesquisar.setIcon(new ImageIcon(Clientes.class.getResource("/img/pesquisar.png")));
		btnPesquisar.setBounds(194, 30, 48, 48);
		getContentPane().add(btnPesquisar);
		
		getRootPane().setDefaultButton(btnPesquisar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnNewButton.setToolTipText("Limpar");
		btnNewButton.setIcon(new ImageIcon(Clientes.class.getResource("/img/clear icon.png")));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(345, 11, 48, 48);
		getContentPane().add(btnNewButton);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(10, 11, 46, 14);
		getContentPane().add(lblID);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(74, 10, 46, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		JButton btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarContato();
			}
		});
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setIcon(new ImageIcon(Clientes.class.getResource("/img/Editor.png")));
		btnEditar.setBounds(345, 70, 48, 48);
		getContentPane().add(btnEditar);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setIcon(new ImageIcon(Clientes.class.getResource("/img/ADD.png")));
		btnAdicionar.setBounds(41, 202, 48, 48);
		getContentPane().add(btnAdicionar);

	}//Fim do construtor
	
	private void limparCampos() {
		txtID.setText(null);
		txtNome.setText(null);
		txtFone.setText(null);
		txtEmail.setText(null);
		txtCpf.setText(null);
	}
	
	private void buscar() {
		// Dica - testar o evento preimeiro
		// System.out.println("teste do botão buscar");
		// Criar ua variável com a query (instruções do banco)
		String read = "select * from clientes where nome = ?";
		// Tratamento de exceções
		try {
			// Abrir a conexão
			con = dao.conectar();

			// Preparar a exucução da query(instrução sql - CRUD Read)
			// O paraêmtro 1 substitui a ? pelo conteúdo da caixa de texto
			pst = con.prepareStatement(read);
			pst.setString(1, txtNome.getText());
			// executar a query e buscar o resultado
			rs = pst.executeQuery();
			// uso da estrutura if else parar verificar se existe o contato
			// rs.next() -> se existir um contato no banco
			if (rs.next()) {
				txtID.setText(rs.getString(1)); // 1 campo da tabela
				txtFone.setText(rs.getString(3)); // 3 campo (fone)
				txtEmail.setText(rs.getString(4));// 4 campo (email)
				txtCpf.setText(rs.getString(5));//5 campo (CPF)
				//validação (liberação dos botões alterar e excluir)
				
			} else {

				// se não existir um contato no banco
				JOptionPane.showMessageDialog(null, "Contato Inexistente");
				//validação (liberação do botão adicionar)
				
			}

		} catch (Exception e) {
			System.out.print(e);
		}
	}// Fim do método buscar

	
	private void editarContato() {
		// System.out.println("teste do Método");

		// Validação dos campos obrigátorios
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o nome");
			txtNome.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o fone do contato");
			txtFone.requestFocus();
		} else if (txtCpf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digita o CPF");
			txtCpf.requestFocus();
		}else {
			// Lógica principal
			// CRUD - Update
			String upadate = "update clientes set nome=?, fone=?, email=? where idcli=?";
			// tratamentos de exceçoes
			try {

				// como a conexão
				con = dao.conectar();
				// preparar a query (instrução sql)
				pst = con.prepareStatement(upadate);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtFone.getText());
				pst.setString(3, txtEmail.getText());
				pst.setString(4, txtID.getText());
				pst.setString(5, txtCpf.getText());
				// executar a query
				pst.executeUpdate();
				// confirmar para o usuário
				JOptionPane.showMessageDialog(null, "Dados do contato editados com sucesso");
				// limpar campos
				limparCampos();
				// fechar conexão
				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}// Fim do Método editar contato
	
}//Fim do Codigo

