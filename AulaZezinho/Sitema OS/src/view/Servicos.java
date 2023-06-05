package view;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.DAO;
import utils.Validador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Servicos extends JDialog {
	
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtOS;
	private JTextField txtData;
	private JTextField txtBrinquedo;
	private JTextField txtDefeito;
	private JTextField txtID;
	private JButton btnEditar;
	private JButton btnAdicionar;
	private JButton btnExcluir;
	private JButton btnBuscar;
	private JButton btnLimpar;
	private JTextField txtValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servicos dialog = new Servicos();
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
	public Servicos() {
		setTitle("Serviços ");
		setModal(true);
		setBounds(100, 100, 560, 350);
		getContentPane().setLayout(null);
		
		JLabel lblOS = new JLabel("OS:");
		lblOS.setBounds(24, 14, 46, 14);
		getContentPane().add(lblOS);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(24, 57, 46, 14);
		getContentPane().add(lblData);
		
		JLabel lblBrinquedo = new JLabel("Brinquedo:");
		lblBrinquedo.setBounds(24, 100, 80, 14);
		getContentPane().add(lblBrinquedo);
		
		JLabel lblDefeito = new JLabel("Defeito:");
		lblDefeito.setBounds(24, 144, 46, 14);
		getContentPane().add(lblDefeito);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(24, 190, 46, 14);
		getContentPane().add(lblValor);
		
		JLabel lblID = new JLabel("ID do Cliente:");
		lblID.setBounds(292, 15, 80, 14);
		getContentPane().add(lblID);
		
		txtOS = new JTextField();
		txtOS.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";

				if (!caracteres.contains(e.getKeyChar() + "")) {

					e.consume();
				}
			}
		});
		txtOS.setBounds(55, 11, 86, 20);
		getContentPane().add(txtOS);
		txtOS.setColumns(10);
		
		txtData = new JTextField();
		txtData.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";

				if (!caracteres.contains(e.getKeyChar() + "")) {

					e.consume();
				}
			}
		});
		txtData.setBounds(65, 54, 132, 20);
		getContentPane().add(txtData);
		txtData.setColumns(10);
		
		txtBrinquedo = new JTextField();
		txtBrinquedo.setBounds(110, 97, 370, 20);
		getContentPane().add(txtBrinquedo);
		txtBrinquedo.setColumns(10);
		
		txtDefeito = new JTextField();
		txtDefeito.setBounds(110, 141, 370, 20);
		getContentPane().add(txtDefeito);
		txtDefeito.setColumns(10);
		txtDefeito.setDocument(new Validador(200));
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setEnabled(false);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnAdicionar.setBounds(24, 251, 89, 23);
		getContentPane().add(btnAdicionar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.setBounds(155, 251, 89, 23);
		getContentPane().add(btnEditar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirServico();
			}
		});
		btnExcluir.setBounds(279, 251, 89, 23);
		getContentPane().add(btnExcluir);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setBounds(168, 11, 89, 23);
		getContentPane().add(btnBuscar);
		
		txtID = new JTextField();
		txtID.setBounds(376, 11, 86, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(410, 251, 89, 23);
		getContentPane().add(btnLimpar);
		
		getRootPane().setDefaultButton(btnBuscar);
		
		txtValor = new JTextField();
		txtValor.setBounds(68, 187, 86, 20);
		getContentPane().add(txtValor);
		txtValor.setColumns(10);

	}// construtor
	
	
	/**
	 * METODO LIMPAR CAMPOS
	 */
	private void limparCampos() {
		txtData.setText(null);
		txtDefeito.setText(null);
		txtBrinquedo.setText(null);
		txtID.setText(null);
		txtOS.setText(null);
		txtValor.setText(null);
		btnBuscar.setEnabled(true);
		
	}
	
	/**
	 * METODO BUSCAR
	 */
	private void buscar() {
		// Dica - testar o evento preimeiro
		// System.out.println("teste do botão buscar");
		// Criar ua variável com a query (instruções do banco)
		String read = "select * from servicos where os = ?";
		// Tratamento de exceções
		try {
			// Abrir a conexão
			con = dao.conectar();

			// Preparar a exucução da query(instrução sql - CRUD Read)
			// O paraêmtro 1 substitui a ? pelo conteúdo da caixa de texto
			pst = con.prepareStatement(read);
			pst.setString(1, txtOS.getText());
			// executar a query e buscar o resultado
			rs = pst.executeQuery();
			// uso da estrutura if else parar verificar se existe o contato
			// rs.next() -> se existir um contato no banco
			if (rs.next()) {
				txtData.setText(rs.getString(2));
				txtBrinquedo.setText(rs.getString(3)); 
				txtDefeito.setText(rs.getString(4));
				txtValor.setText(rs.getString(5));
				txtID.setText(rs.getString(6));
				
				
				btnEditar.setEnabled(true);
				btnExcluir.setEnabled(true);
				btnBuscar.setEnabled(false);
			} else {
				// se não existir um contato no banco
				JOptionPane.showMessageDialog(null, "serviço inexistente");
				btnAdicionar.setEnabled(true);
				
			}

		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	private void adicionar() {
		// System.out.println("teste");
		// Validação de campos obrigatóriios
		if (txtOS.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a OS do Cliente");
			txtOS.requestFocus();
		}else if (txtBrinquedo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Brinquedo do Cliente");
			txtBrinquedo.requestFocus();
		}else if(txtDefeito.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Defeito do Brinquedo do Cliente");
			txtDefeito.requestFocus();
		} else {
			
			// lógica pricipal
			// CRUD Creat
			String create = "insert into servicos (brinquedo,defeito,valor,idcli) value (?, ?, ?, ?)";
			// tratamento com exceções
			try {
				//abrir conexão 
				con = dao.conectar();
				//preparar a execução da query(instrução sql - CRUD Create)
				pst = con.prepareStatement(create);
				pst.setString(1, txtBrinquedo.getText());
				pst.setString(2, txtDefeito.getText());
				pst.setString(3, txtValor.getText());
				pst.setString(4, txtID.getText());
				
				//executar a query(instruição sql (CRUD - Creat))
				pst.executeUpdate();
				//Confirmar
				JOptionPane.showMessageDialog(null, "Ordem de serviço adicionado");  
				limparCampos();
				//fechar a conexão
			} catch (Exception e) {
				System.out.print(e);
			}
			}
	}
	private void excluirServico() {
		// System.out.println("Teste do botão excluir");
		// validação de exclusão - a variável confima captura a opção escolhida

		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste serviço ?", "Atenção !",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_NO_OPTION) {
			// CRUD - Delete
			String delete = "delete from servicos where OS=?";
			// tratamento de exceções
			try {
				// abrir a conexão
				con = dao.conectar();
				// preparar a query (instrução sql)
				pst = con.prepareStatement(delete);
				// substituir a ? pelo id do contato
				pst.setString(1, txtOS.getText());
				// executar a query
				pst.executeUpdate();
				// limpar Campos
				limparCampos();
				// exibir uma mensagem ao usuário
				JOptionPane.showMessageDialog(null, " Serviço excluido");
				// fechar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	private void editarServico() {
		// System.out.println("teste do Método");

		// Validação dos campos obrigátorios
		if (txtOS.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o nome");
			txtOS.requestFocus();
		} else if (txt.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o login do Usuário");
			txtLogin.requestFocus();
		} else if (txtSenha.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite a Senha do Usuário");
			txtSenha.requestFocus();
		} else {

			// Lógica principal
			// CRUD - Update
			String update = "update usuarios set nome=?, login=?, senha = md5(?) where id=?";
			// tratamentos de exceçoes
			try {

				// como a conexão
				con = dao.conectar();
				// preparar a query (instrução sql)
				pst = con.prepareStatement(update);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtLogin.getText());
				pst.setString(3, txtSenha.getText());
				pst.setString(4, txtID.getText());
				// executar a query
				pst.executeUpdate();
				// confirmar para o usuário
				JOptionPane.showMessageDialog(null, "Dados do Usuário editados com sucesso");
				// limpar campos
				limparcampos();
				// fechar conexão
				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
