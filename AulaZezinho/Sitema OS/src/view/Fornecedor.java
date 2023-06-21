package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import model.DAO;
import utils.Validador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fornecedor extends JDialog {
	
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtFone;
	private JTextField txtEmail;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtComplemento;
	private JTextField txtCidade;
	private JTextField txtNumero;
	private JComboBox cboUF;
	private JTextField txtBairro;
	private JButton btnBuscarCep;
	private JScrollPane scrollPaneFornecedor;
	private JList listFornecedor;
	private JTextField txtNome;
	private JTextField txtCNPJ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Fornecedor dialog = new Fornecedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Fornecedor() {
		setTitle("Fornecedor");
		setBounds(100, 100, 690, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPaneFornecedor = new JScrollPane();
		scrollPaneFornecedor.setVisible(false);
		scrollPaneFornecedor.setBounds(137, 46, 210, 23);
		contentPanel.add(scrollPaneFornecedor);
		
		listFornecedor = new JList();
		scrollPaneFornecedor.setViewportView(listFornecedor);
		listFornecedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarFornecedor();
			}
		});
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adicionar();
			}
		});
		btnAdicionar.setBounds(27, 363, 89, 23);
		contentPanel.add(btnAdicionar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirFornecedor();
			}
		});
		btnExcluir.setBounds(126, 363, 89, 23);
		contentPanel.add(btnExcluir);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarFornecedor();
			}
		});
		btnEditar.setBounds(227, 363, 89, 23);
		contentPanel.add(btnEditar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(335, 363, 89, 23);
		contentPanel.add(btnLimpar);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(27, 21, 37, 14);
		contentPanel.add(lblID);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(138, 21, 46, 14);
		contentPanel.add(lblNome);
		
		JLabel lblFone = new JLabel("Telefone:");
		lblFone.setBounds(27, 160, 62, 14);
		contentPanel.add(lblFone);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(236, 160, 68, 14);
		contentPanel.add(lblEmail);
		
		JLabel lblCNPJ = new JLabel("CNPJ:");
		lblCNPJ.setBounds(408, 21, 46, 14);
		contentPanel.add(lblCNPJ);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(476, 138, 46, 14);
		contentPanel.add(lblCep);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(408, 204, 62, 14);
		contentPanel.add(lblEndereco);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setBounds(420, 304, 68, 14);
		contentPanel.add(lblNumero);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(393, 229, 95, 14);
		contentPanel.add(lblComplemento);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(415, 254, 95, 14);
		contentPanel.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(415, 279, 95, 14);
		contentPanel.add(lblCidade);
		
		JLabel lblUF = new JLabel("UF:");
		lblUF.setBounds(430, 329, 46, 14);
		contentPanel.add(lblUF);
		
		cboUF = new JComboBox();
		cboUF.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboUF.setBounds(476, 329, 62, 23);
		contentPanel.add(cboUF);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(27, 32, 52, 20);
		contentPanel.add(txtID);
		txtID.setColumns(10);
		
		txtFone = new JTextField();
		txtFone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";

				if (!caracteres.contains(e.getKeyChar() + "")) {

					e.consume();
				}
			}
		});
		txtFone.setBounds(84, 157, 132, 20);
		contentPanel.add(txtFone);
		txtFone.setColumns(10);
		txtFone.setDocument(new Validador(15));
		
		txtEmail = new JTextField();
		txtEmail.setBounds(277, 157, 179, 20);
		contentPanel.add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.setDocument(new Validador(30));
		
		txtCep = new JTextField();
		txtCep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";

				if (!caracteres.contains(e.getKeyChar() + "")) {

					e.consume();
				}
			}
		});
		txtCep.setBounds(477, 152, 86, 20);
		contentPanel.add(txtCep);
		txtCep.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(476, 201, 86, 20);
		contentPanel.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(476, 226, 86, 20);
		contentPanel.add(txtComplemento);
		txtComplemento.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(476, 251, 86, 20);
		contentPanel.add(txtBairro);
		txtBairro.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(476, 276, 86, 20);
		contentPanel.add(txtCidade);
		
		txtNumero = new JTextField();
		txtNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";

				if (!caracteres.contains(e.getKeyChar() + "")) {

					e.consume();
				}
			}
		});
		txtNumero.setBounds(476, 304, 86, 20);
		contentPanel.add(txtNumero);
		txtNumero.setColumns(10);
		
		btnBuscarCep = new JButton("Buscar");
		btnBuscarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();
			}
		});
		btnBuscarCep.setBounds(564, 151, 89, 23);
		contentPanel.add(btnBuscarCep);
		
		getRootPane().setDefaultButton(btnBuscarCep);
		
		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				listarFornecedor();
			}
		});
		txtNome.setBounds(137, 32, 210, 20);
		contentPanel.add(txtNome);
		txtNome.setColumns(10);
		txtNome.setDocument(new Validador(50));
		
		txtCNPJ = new JTextField();
		txtCNPJ.setBounds(408, 32, 111, 20);
		contentPanel.add(txtCNPJ);
		txtCNPJ.setColumns(10);
		txtCNPJ.setDocument(new Validador(15));
	}
	/**
	 * buscarCep
	 */
	private void buscarCep() {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txtCep.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					txtCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					txtBairro.setText(element.getText());
				}
				if (element.getQualifiedName().equals("uf")) {
					cboUF.setSelectedItem(element.getText());
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					txtEndereco.setText(element.getText());
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {
						System.out.println("OK");
						} else {
							JOptionPane.showMessageDialog(null, "CEP não encontrado");
						}
					}
				}
				txtEndereco.setText(tipoLogradouro + " " + logradouro);
		} catch (Exception e) {
				System.out.println(e);
		}
	}
	/**
	 * Método usado para buscar usuário pela lista
	 */
	private void buscarFornecedor() {
		// System.out.println("teste");
		// variável que captura o indice da linha da lista
		int linha = listFornecedor.getSelectedIndex();
		if (linha >= 0) {
			// Query (instrução sql)
			// limit (0,1) -> seleciona o indice 0 e 1 usuário da lista
			String readListafornecedor =  "select * from fornecedor where nome like '" + txtNome.getText() + "%'" + "order by nome";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readListafornecedor);
				rs = pst.executeQuery();
				if (rs.next()) {
					// esconder a lista
					scrollPaneFornecedor.setVisible(false);
					// setar campos
					txtID.setText(rs.getString(1));
					txtNome.setText(rs.getString(2));
					txtFone.setText(rs.getString(3));
					txtEmail.setText(rs.getString(4));
					txtCNPJ.setText(rs.getString(5));
					txtBairro.setText(rs.getString(6));
					txtCep.setText(rs.getString(7));
					txtCidade.setText(rs.getString(8));
					txtComplemento.setText(rs.getString(9));
					txtEndereco.setText(rs.getString(10));
					txtNumero.setText(rs.getString(11));
					
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			// se não existir no banco um usuário da lista
			scrollPaneFornecedor.setVisible(false);
		}
		
	}
	/**
	 * METODO LIMPAR CAMPOS
	 */
	private void limparCampos() {
		txtBairro.setText(null);
		txtCep.setText(null);
		txtCidade.setText(null);
		txtID.setText(null);
		txtCNPJ.setText(null);
		txtComplemento.setText(null);
		txtEmail.setText(null);	
		txtFone.setText(null);		
		txtNome.setText(null);		
		txtNumero.setText(null);	
		txtEndereco.setText(null);		


	}
	private void listarFornecedor() {
		// System.out.println("Teste");
		// a linha abaixo cria um objeto usando como referência um vetor dinâmico, este
		// obejto irá temporariamente armazenar os dados
		DefaultListModel<String> modelo = new DefaultListModel<>();
		// setar o model (vetor na lista)
		listFornecedor.setModel(modelo);
		// Query (instrução sql)
		String readLista = "select* from fornecedor where nome like '" + txtNome.getText() + "%'" + "order by nome";
		try {
			// abri conexão
			con = dao.conectar();

			pst = con.prepareStatement(readLista);

			rs = pst.executeQuery();

			// uso do while para trazer os usuários enquanto exisitr
			while (rs.next()) {
				// mostrar a lista
				scrollPaneFornecedor.setVisible(true);
				// adicionar os usuarios no vetor -> lista
				modelo.addElement(rs.getString(2));
				// esconder a lista se nenhuma letra for digitada
				if (txtNome.getText().isEmpty()) {
					scrollPaneFornecedor.setVisible(false);
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void Adicionar() {
		// System.out.println("teste");
		// Validação de campos obrigatóriios
		if  (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome do fornecedor");
			txtNome.requestFocus();
		}else if(txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o telefone do fornecedor");
			txtFone.requestFocus();
		}else if(txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o e-mail do fornecedor");
			txtEmail.requestFocus();
		}else if(txtCNPJ.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CNPJ do fornecedor");
			txtCNPJ.requestFocus();
		}else if(txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CEP do fornecedor");
			txtCep.requestFocus();
		}else if(txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o número do endereço do fornecedor");
			txtNumero.requestFocus();
		} else {
			
			// lógica pricipal
			// CRUD Creat
			String create = "insert into fornecedor (nome,fone,email,cnpj,cep,endereco,numero,bairro,cidade,uf) value (?, ?, ?, ?,?,?,?,?,?,?)";
			// tratamento com exceções
			try {
				//abrir conexão 
				con = dao.conectar();
				//preparar a execução da query(instrução sql - CRUD Create)
				pst = con.prepareStatement(create);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtFone.getText());
				pst.setString(3, txtEmail.getText());
				pst.setString(5, txtCNPJ.getText());
				pst.setString(4, txtCep.getText());
				pst.setString(6, txtEndereco.getText());
				pst.setString(7, txtNumero.getText());
				pst.setString(8, txtBairro.getText());
				pst.setString(9, txtCidade.getText());
				pst.setString(10, cboUF.getSelectedItem().toString());
				
				//executar a query(instruição sql (CRUD - Creat))
				pst.executeUpdate();
				//Confirmar
				JOptionPane.showMessageDialog(null, "Fornecedor adicionado!");  
				limparCampos();
				//fechar a conexão
			} catch (Exception e) {
				System.out.print(e);
			}
			}
	}
	/*
	 * 
	 */
	private void excluirFornecedor() {
		// System.out.println("Teste do botão excluir");
		// validação de exclusão - a variável confima captura a opção escolhida

		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste fornecedor ?", "Atenção !",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_NO_OPTION) {
			// CRUD - Delete
			String delete = "delete from fornecedor where nome=?";
			// tratamento de exceções
			try {
				// abrir a conexão
				con = dao.conectar();
				// preparar a query (instrução sql)
				pst = con.prepareStatement(delete);
				// substituir a ? pelo id do contato
				pst.setString(1, txtNome.getText());
				// executar a query
				pst.executeUpdate();
				// limpar Campos
				limparCampos();
				// exibir uma mensagem ao usuário
				JOptionPane.showMessageDialog(null, " Fornecedor excluido");
				// fechar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	private void editarFornecedor() {
		// System.out.println("teste do Método");

		// Validação dos campos obrigátorios
		if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Brinquedo do Serviço");
			txtEmail.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Valor de Serviço");
			txtFone.requestFocus();
		} else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Defeito do Serviço");
			txtCep.requestFocus();
		} else if (txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Defeito do Serviço");
			txtNumero.requestFocus();
		} else {

			// Lógica principal
			// CRUD - Update
			String update = "update fornecedor set email=?, fone=?, cep=?, numero=? where idfornecedor=?";
			// tratamentos de exceçoes
			try {
				// como a conexão
				con = dao.conectar();
				// preparar a query (instrução sql)
				pst = con.prepareStatement(update);
				pst.setString(1, txtFone.getText());
				pst.setString(2, txtEmail.getText());
				pst.setString(3, txtCep.getText());
				pst.setString(4, txtNumero.getText());
				pst.setString(5, txtID.getText());
				// executar a query
				pst.executeUpdate();
				// confirmar para o usuário
				JOptionPane.showMessageDialog(null, "Dados do Fornecedor editado com sucesso");
				// limpar campos
				limparCampos();
				// fechar conexão
				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
