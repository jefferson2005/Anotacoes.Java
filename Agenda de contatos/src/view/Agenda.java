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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.DAO;
import utils.Validador;

public class Agenda extends JFrame {
	// Instanciar objetos JDBC
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel btnTela;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtEmail;
	private JLabel lblStatus;
	private JButton btnAdicionar;
	private JButton btnEditar;
	private JButton btnExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
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
	public Agenda() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				// ativação da janela
				status();
			}
		});
		setTitle("Agenda de  contatos ");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Agenda.class.getResource("/img/notebook.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		btnTela = new JPanel();
		btnTela.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(btnTela);
		btnTela.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(10, 11, 31, 14);
		btnTela.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("NOME:");
		lblNewLabel_1.setBounds(10, 46, 46, 14);
		btnTela.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("FONE:");
		lblNewLabel_2.setBounds(10, 89, 46, 14);
		btnTela.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("E_mail:");
		lblNewLabel_3.setBounds(10, 125, 46, 14);
		btnTela.add(lblNewLabel_3);

		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(61, 8, 86, 20);
		btnTela.add(txtID);
		txtID.setColumns(10);

		txtNome = new JTextField();
		txtNome.setBounds(61, 43, 193, 20);
		btnTela.add(txtNome);
		txtNome.setColumns(10);
		//uso do validador para limitar o número de caracteres 
		txtNome.setDocument(new Validador (50));

		txtFone = new JTextField();
		txtFone.setBounds(61, 86, 120, 20);
		btnTela.add(txtFone);
		txtFone.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(61, 122, 246, 20);
		btnTela.add(txtEmail);
		txtEmail.setColumns(10);

		JButton btnSobre = new JButton("");
		btnSobre.setContentAreaFilled(false);
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// clicar no botão sobre
				// mostrar a janela sobre
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setBorder(null);
		btnSobre.setToolTipText("Sobre");
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setIcon(new ImageIcon(Agenda.class.getResource("/img/about.png")));
		btnSobre.setBounds(376, 11, 48, 48);
		btnTela.add(btnSobre);

		JButton btnPesquisar = new JButton("");
		btnPesquisar.setContentAreaFilled(false);
		btnPesquisar.setToolTipText("Pesquisar");
		btnPesquisar.setIcon(new ImageIcon(Agenda.class.getResource("/img/pesquisar.png")));
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.setBorder(null);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// evento clicar no botão
				buscar();

			}
		});
		btnPesquisar.setBounds(264, 43, 32, 32);
		btnTela.add(btnPesquisar);

		btnAdicionar = new JButton("");
		btnAdicionar.setEnabled(false);
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnAdicionar.setBorder(null);
		btnAdicionar.setIcon(new ImageIcon(Agenda.class.getResource("/img/adicionar.png")));
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setBounds(22, 172, 64, 64);
		btnTela.add(btnAdicionar);

		btnEditar = new JButton("");
		btnEditar.setEnabled(false);
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setContentAreaFilled(false);
		btnEditar.setToolTipText("Editar");
		btnEditar.setIcon(new ImageIcon(Agenda.class.getResource("/img/editar.png")));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarContato();
			}
		});
		btnEditar.setBorder(null);
		btnEditar.setBounds(106, 172, 64, 64);
		btnTela.add(btnEditar);

		btnExcluir = new JButton("");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirContato();
			}
		});
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setIcon(new ImageIcon(Agenda.class.getResource("/img/excluir.png")));
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.setBorder(null);
		btnExcluir.setBounds(191, 172, 64, 64);
		btnTela.add(btnExcluir);

		JButton btnLimpar = new JButton("");
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setIcon(new ImageIcon(Agenda.class.getResource("/img/eraser.png")));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setBorder(null);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparcampos();
			}
		});
		btnLimpar.setBounds(264, 172, 64, 64);
		btnTela.add(btnLimpar);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff.png")));
		lblStatus.setBounds(361, 184, 48, 48);
		btnTela.add(lblStatus);

		// subtistuir o click pela tecla <ENTER> em um botão
		getRootPane().setDefaultButton(btnPesquisar);

	}// Fim do construtor

	/**
	 * Método resposável por limpar os campos e setar botões
	 */
	private void limparcampos() {
		txtID.setText(null);
		txtNome.setText(null);
		txtFone.setText(null);
		txtEmail.setText(null);
		btnTela.setEnabled(false);
		btnEditar.setEnabled(false);
		btnExcluir.setEnabled(false);
		
	}// fim do método limpar campos()

	/**
	 * Método reponsável por exibir o status da conexão
	 */
	private void status() {
		try {
			// abrir a conexão
			con = dao.conectar();
			if (con == null) {
				// System.out.println("Erro de conexão");
				lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff.png")));
			} else {
				// System.out.println("Banco conectado");
				lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dbon.png")));
			}
			// NUNCA esquecer de fechar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}// fim do método status()

	/**
	 * Método para buscar um contato pelo nome
	 */

	private void buscar() {
		// Dica - testar o evento preimeiro
		// System.out.println("teste do botão buscar");
		// Criar ua variável com a query (instruções do banco)
		String read = "select * from contatos where nome = ?";
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
				txtEmail.setText(rs.getString(4)); // 4 campo (email)
				//validação (liberação dos botões alterar e excluir)
				btnEditar.setEnabled(true);
				btnExcluir.setEnabled(true);

			} else {

				// se não existir um contato no banco
				JOptionPane.showMessageDialog(null, "Contato Inexistente");
				//validação (liberação do botão adicionar)
				btnAdicionar.setEnabled(true);

			}

		} catch (Exception e) {
			System.out.print(e);
		}
	}// Fim do método buscar

	/**
	 * Método para adicionar um novo contato
	 */
	private void adicionar() {
		// System.out.println("teste");
		// Validação de campos obrigatóriios
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome do contato");
			txtNome.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o fone do contato");
			txtFone.requestFocus();
		} else {
			// lógica pricipal
			// CRUD Creat
			String create = "insert into contatos(nome,fone,email) values (?,?,?)";
			// tratamento com exceções
			try {
				// abrir conexão
				con = dao.conectar();
				// preparar a execução da query(instrução sql - CRUD Create)
				pst = con.prepareStatement(create);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtFone.getText());
				pst.setString(3, txtEmail.getText());
				// executar a query(instruição sql (CRUD - Creat))
				pst.executeUpdate();
				// Confirmar
				JOptionPane.showMessageDialog(null, "Contato adicionado");
				// limpar campos
				limparcampos();
				// fechar a conexão

			} catch (Exception e) {
				System.out.println(e);

			}

		}

	}// Fim do método adicionar

	/**
	 * Método para editar um contato (ATENÇÃO! usar id)
	 */
	private void editarContato() {
		// System.out.println("teste do Método");

		// Validação dos campos obrigátorios
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o nome");
			txtNome.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o fone do contato");
			txtFone.requestFocus();
		} else {
			// Lógica principal
			// CRUD - Update
			String upadate = "update contatos set nome=?, fone=?, email=? where id=?";
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
				// executar a query
				pst.executeUpdate();
				// confirmar para o usuário
				JOptionPane.showMessageDialog(null, "Dados do contato editados com sucesso");
				// limpar campos
				limparcampos();
				// fechar conexão
				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}// Fim do Método editar contato

	// Método usado para excluir um contato

	private void excluirContato() {
		// System.out.println("Teste do botão excluir");
		// validação de exclusão - a variável confima captura a opção escolhida

		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste contato ?", "Atenção !",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_NO_OPTION) {
			//CRUD - Delete
			String delete = "delete from contatos where id=?";
			//tratamento de exceções
			try {
				//abrir a conexão 
				con = dao.conectar();
				//preparar a query (instrução sql)
				pst = con.prepareStatement(delete);
				//substituir a ? pelo id do contato
				pst.setString(1, txtID.getText());
				//executar a query
				pst.executeUpdate();
				//limpar Campos
				limparcampos();
				//exibir uma mensagem ao usuário
				JOptionPane.showMessageDialog(null, "Contato excluido");
				//fechar a conexão 
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		}

}// Final do CÓDIGO