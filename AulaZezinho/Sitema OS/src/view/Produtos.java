package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import model.DAO;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Produtos extends JDialog {

	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtProdutos;
	private JTextField txtEstoque;
	private JTextField txtEstoqueMin;
	private JTextField txtValor;
	private JTextField txtLocal;
	private JTextField txtFornecedor;
	private JList listFornecedor;
	private JScrollPane scrollPaneFornecedor;
	private JTextField txtIDFornecedor;
	private JComboBox cboUN;
	private JButton btnEditar;
	private JButton btnAdicionar;
	private JButton btnLimpar;
	private JButton btnExcluir;
	private JButton btnBuscar;
	private JTextPane txtDescricao;
	private JTextField txtBarcode;
	private JTextField txtFoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Produtos dialog = new Produtos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Produtos() {
		setTitle("Produtos");
		setBounds(100, 100, 601, 401);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Fornecedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 286, 222, 65);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		txtFornecedor = new JTextField();
		txtFornecedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				listarFornecedor();
			}
		});
		txtFornecedor.setBounds(110, 19, 94, 17);
		panel.add(txtFornecedor);
		txtFornecedor.setColumns(10);
		
		JLabel lblFornecedor = new JLabel("Nome Fornecedor:");
		lblFornecedor.setBounds(10, 21, 100, 14);
		panel.add(lblFornecedor);
		
		scrollPaneFornecedor = new JScrollPane();
		scrollPaneFornecedor.setVisible(false);
		scrollPaneFornecedor.setBounds(110, 32, 94, 26);
		panel.add(scrollPaneFornecedor);
		
		listFornecedor = new JList();
		listFornecedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 buscarFornecedor();
			}
		});
		scrollPaneFornecedor.setViewportView(listFornecedor);
		
		JLabel lblIDFornecedor = new JLabel("ID:");
		lblIDFornecedor.setBounds(10, 40, 46, 14);
		panel.add(lblIDFornecedor);
		
		txtIDFornecedor = new JTextField();
		txtIDFornecedor.setEditable(false);
		txtIDFornecedor.setBounds(33, 38, 46, 20);
		panel.add(txtIDFornecedor);
		txtIDFornecedor.setColumns(10);
		{
			JLabel lblID = new JLabel("ID:");
			lblID.setBounds(10, 11, 46, 14);
			contentPanel.add(lblID);
		}
		{
			JLabel lblProduto = new JLabel("Produtos");
			lblProduto.setBounds(10, 37, 59, 14);
			contentPanel.add(lblProduto);
		}
		{
			JLabel lblBarcode = new JLabel("Barcode");
			lblBarcode.setBounds(342, 11, 59, 14);
			contentPanel.add(lblBarcode);
		}
		{
			JLabel lblDescricao = new JLabel("Descrição:");
			lblDescricao.setBounds(302, 212, 59, 14);
			contentPanel.add(lblDescricao);
		}
		{
			JLabel lblFoto = new JLabel("Foto:");
			lblFoto.setBounds(342, 67, 46, 14);
			contentPanel.add(lblFoto);
		}
		{
			JLabel lblEstoque = new JLabel("Estoque:");
			lblEstoque.setBounds(10, 137, 86, 14);
			contentPanel.add(lblEstoque);
		}
		{
			JLabel lblEstoqueMin = new JLabel("Estoque Minimo:");
			lblEstoqueMin.setBounds(10, 162, 86, 14);
			contentPanel.add(lblEstoqueMin);
		}
		{
			JLabel lblValor = new JLabel("Valor:");
			lblValor.setBounds(10, 187, 46, 14);
			contentPanel.add(lblValor);
		}
		{
			JLabel lblUnidade = new JLabel("Unidade de Medida:");
			lblUnidade.setBounds(10, 212, 46, 14);
			contentPanel.add(lblUnidade);
		}
		{
			JLabel lblLocal = new JLabel("Local Armazenagem:");
			lblLocal.setBounds(10, 237, 46, 14);
			contentPanel.add(lblLocal);
		}
		{
			txtID = new JTextField();
			txtID.setEditable(false);
			txtID.setBounds(66, 8, 86, 20);
			contentPanel.add(txtID);
			txtID.setColumns(10);
		}
		{
			txtProdutos = new JTextField();
			txtProdutos.setBounds(66, 34, 86, 20);
			contentPanel.add(txtProdutos);
			txtProdutos.setColumns(10);
		}
		{
			txtEstoque = new JTextField();
			txtEstoque.setColumns(10);
			txtEstoque.setBounds(106, 134, 86, 20);
			contentPanel.add(txtEstoque);
		}
		{
			txtEstoqueMin = new JTextField();
			txtEstoqueMin.setColumns(10);
			txtEstoqueMin.setBounds(106, 159, 86, 20);
			contentPanel.add(txtEstoqueMin);
		}
		{
			txtValor = new JTextField();
			txtValor.setColumns(10);
			txtValor.setBounds(66, 184, 86, 20);
			contentPanel.add(txtValor);
		}
		{
			txtLocal = new JTextField();
			txtLocal.setColumns(10);
			txtLocal.setBounds(66, 234, 86, 20);
			contentPanel.add(txtLocal);
		}
		{
			btnExcluir = new JButton("Excluir");
			btnExcluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 excluirProduto();
				}
			});
			btnExcluir.setBounds(229, 38, 89, 23);
			contentPanel.add(btnExcluir);
		}
		{
			btnLimpar = new JButton("Limpar");
			btnLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limparCampos();
				}
			});
			btnLimpar.setBounds(229, 74, 89, 23);
			contentPanel.add(btnLimpar);
		}
		{
			btnAdicionar = new JButton("Adicionar");
			btnAdicionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					adicionar();
				}
			});
			btnAdicionar.setBounds(229, 108, 89, 23);
			contentPanel.add(btnAdicionar);
		}
		{
			btnEditar = new JButton("Editar");
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 editarProduto();
				}
			});
			btnEditar.setBounds(229, 153, 89, 23);
			contentPanel.add(btnEditar);
		}
		
		txtDescricao = new JTextPane();
		txtDescricao.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtDescricao.setBounds(306, 237, 269, 101);
		contentPanel.add(txtDescricao);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setBounds(229, 7, 89, 23);
		contentPanel.add(btnBuscar);
		
		cboUN = new JComboBox();
		cboUN.setModel(new DefaultComboBoxModel(new String[] {"UN", "CX ", "PC ", "KG", "M"}));
		cboUN.setBounds(66, 208, 86, 20);
		contentPanel.add(cboUN);
		
		getRootPane().setDefaultButton(btnBuscar);
		{
			txtBarcode = new JTextField();
			txtBarcode.setBounds(397, 8, 86, 20);
			contentPanel.add(txtBarcode);
			txtBarcode.setColumns(10);
		}
		{
			txtFoto = new JTextField();
			txtFoto.setBounds(385, 64, 86, 20);
			contentPanel.add(txtFoto);
			txtFoto.setColumns(10);
		}
		
		
	}//final construtor
	
	
	private void listarFornecedor() {
		// System.out.println("Teste");
		// a linha abaixo cria um objeto usando como referência um vetor dinâmico, este
		// obejto irá temporariamente armazenar os dados
		DefaultListModel<String> modelo = new DefaultListModel<>();
		// setar o model (vetor na lista)
		listFornecedor.setModel(modelo);
		// Query (instrução sql)
		String readLista = "select* from fornecedor where nome like '" + txtFornecedor.getText() + "%'" + "order by nome";
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
				if (txtFornecedor.getText().isEmpty()) {
					scrollPaneFornecedor.setVisible(false);
				}
			}
			con.close();
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
			String readListafornecedor =  "select * from fornecedor where nome like '" + txtFornecedor.getText() + "%'" + "order by nome";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readListafornecedor);
				rs = pst.executeQuery();
				if (rs.next()) {
					// esconder a lista
					scrollPaneFornecedor.setVisible(false);
					// setar campos
					txtIDFornecedor.setText(rs.getString(1));
					txtFornecedor.setText(rs.getString(2));
									
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
	 * METODO BUSCAR
	 */
	private void buscar() {
		String read = "select * from produtos where nomeprodutos = ?";
		// Tratamento de exceções
		try {
			// Abrir a conexão
			con = dao.conectar();

			// Preparar a exucução da query(instrução sql - CRUD Read)
			// O paraêmtro 1 substitui a ? pelo conteúdo da caixa de texto
			pst = con.prepareStatement(read);
		
			pst.setString(1, txtProdutos.getText());
			// executar a query e buscar o resultado
			rs = pst.executeQuery();
			// uso da estrutura if else parar verificar se existe o contato
			// rs.next() -> se existir um contato no banco
			if (rs.next()) {
				txtID.setText(rs.getString(1));
				txtProdutos.setText(rs.getString(2));
				txtValor.setText(rs.getString(3)); 
				txtDescricao.setText(rs.getString(4));
				txtEstoque.setText(rs.getString(5));
				txtEstoque.setText(rs.getString(6));
				txtEstoqueMin.setText(rs.getString(7));
				txtValor.setText(rs.getString(8));
				cboUN.setSelectedItem(rs.getString(9));
				txtLocal.setText(rs.getString(10));
				txtIDFornecedor.setText(rs.getString(11));
				
				btnEditar.setEnabled(true);
				btnExcluir.setEnabled(true);
			} else {
				// se não existir um contato no banco
				JOptionPane.showMessageDialog(null, "Produto inexistente");
				btnAdicionar.setEnabled(true);
				
			}

		} catch (Exception e) {
			System.out.print(e);
		}
	}
	/**
	 * METODO LIMPAR CAMPOS
	 */
	private void limparCampos() {
		txtProdutos.setText(null);
		txtDescricao.setText(null);
		txtIDFornecedor.setText(null);
		txtID.setText(null);
		txtLocal.setText(null);
		txtValor.setText(null);
		btnBuscar.setEnabled(true);
		txtEstoqueMin.setText(null);
		txtEstoque.setText(null);
		txtFornecedor.setText(null);
	}
	private void adicionar() {
		// System.out.println("teste");
		// Validação de campos obrigatóriios
		if  (txtValor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Brinquedo do Cliente");
			txtValor.requestFocus();
		}else if(txtDescricao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Defeito do Brinquedo do Cliente");
			txtDescricao.requestFocus();
		} else {
			
			// lógica pricipal
			// CRUD Creat
			String create = "insert into produtos (nomeprodutos,barcode,descricao,foto,estoque,estoquemin,valor,numeromedida,localarmazenagem,idprodutor) value (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			// tratamento com exceções
			try {
				//abrir conexão 
				con = dao.conectar();
				//preparar a execução da query(instrução sql - CRUD Create)
				pst = con.prepareStatement(create);
				pst.setString(1, txtProdutos.getText());
				pst.setString(2, txtBarcode.getText());
				pst.setString(3, txtDescricao.getText());
				pst.setString(4, txtFoto.getText());
				pst.setString(5, txtEstoque.getText());
				pst.setString(6, txtEstoqueMin.getText());
				pst.setString(7, txtValor.getText());
				pst.setString(8, cboUN.getSelectedItem().toString());
				pst.setString(9, txtLocal.getText());
				pst.setString(10, txtIDFornecedor.getText());
				
				//executar a query(instruição sql (CRUD - Creat))
				pst.executeUpdate();
				//Confirmar
				JOptionPane.showMessageDialog(null, "Produto adicionado");  
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
	private void excluirProduto() {
		// System.out.println("Teste do botão excluir");
		// validação de exclusão - a variável confima captura a opção escolhida

		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste fornecedor ?", "Atenção !",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_NO_OPTION) {
			// CRUD - Delete
			String delete = "delete from produtos where nomeprodutos=?";
			// tratamento de exceções
			try {
				// abrir a conexão
				con = dao.conectar();
				// preparar a query (instrução sql)
				pst = con.prepareStatement(delete);
				// substituir a ? pelo id do contato
				pst.setString(1, txtProdutos.getText());
				// executar a query
				pst.executeUpdate();
				// limpar Campos
				limparCampos();
				// exibir uma mensagem ao usuário
				JOptionPane.showMessageDialog(null, " Produto excluido");
				// fechar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	private void editarProduto() {
		// System.out.println("teste do Método");

		// Validação dos campos obrigátorios
		if (txtProdutos.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Brinquedo do Serviço");
			txtProdutos.requestFocus();
		} else if (txtValor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Valor de Serviço");
			txtValor.requestFocus();
		} else if (txtDescricao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Defeito do Serviço");
			txtDescricao.requestFocus();
		} else if (txtEstoque.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Defeito do Serviço");
			txtEstoque.requestFocus();
		} else if (txtLocal.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Defeito do Serviço");
			txtLocal.requestFocus();
		} else if (txtEstoqueMin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Defeito do Serviço");
			txtEstoqueMin.requestFocus();
		} else {

			// Lógica principal
			// CRUD - Update
			String update = "update produtos set nomeprodutos=?, estoque=?, estoquemin=?, descricao=?, valor=?, localarmazenagem=? where idprodutor=?";
			// tratamentos de exceçoes
			try {
				// como a conexão
				con = dao.conectar();
				// preparar a query (instrução sql)
				pst = con.prepareStatement(update);
				pst.setString(1, txtProdutos.getText());
				pst.setString(2, txtEstoque.getText());
				pst.setString(3, txtEstoqueMin.getText());
				pst.setString(4, txtDescricao.getText());
				pst.setString(5, txtValor.getText());
				pst.setString(6, cboUN.getSelectedItem().toString());
				pst.setString(7, txtLocal.getText());
				// executar a query
				pst.executeUpdate();
				// confirmar para o usuário
				JOptionPane.showMessageDialog(null, "Dados do Produto editado com sucesso");
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
