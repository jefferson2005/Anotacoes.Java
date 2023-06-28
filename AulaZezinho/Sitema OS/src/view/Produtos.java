package view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.DAO;
import utils.Validador;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextArea;

public class Produtos extends JDialog {
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	// instanciar objeto para o fluxo de bytes
	private FileInputStream fis;

	// variavel global para armazenar o tamanho da imagem(bytes)
	private int tamanho;

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
	private JLabel lblFoto;
	private JButton btnCarregar;
	private JTextField txtBarcode;
	private JLabel lblNewLabel;
	private JTextArea txtDescricao;
	private JScrollPane scrollPaneProdutos;
	private JList listProdutos;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Produtos.class.getResource("/img/Produtos.png")));
		setTitle("Produtos");
		setBounds(100, 100, 601, 399);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			scrollPaneProdutos = new JScrollPane();
			scrollPaneProdutos.setVisible(false);
			scrollPaneProdutos.setBounds(146, 42, 182, 27);
			contentPanel.add(scrollPaneProdutos);
			
			listProdutos = new JList();
			listProdutos.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					buscarProdutos();
				}
			});
			scrollPaneProdutos.setViewportView(listProdutos);
		}

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Fornecedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(353, 55, 222, 65);
		contentPanel.add(panel);
		panel.setLayout(null);

		txtFornecedor = new JTextField();
		txtFornecedor.setDocument(new Validador(50));
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
		txtIDFornecedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";

				if (!caracteres.contains(e.getKeyChar() + "")) {

					e.consume();
				}
			}
		});
		txtIDFornecedor.setEditable(false);
		txtIDFornecedor.setBounds(33, 38, 46, 20);
		panel.add(txtIDFornecedor);
		txtIDFornecedor.setColumns(10);
		{
			JLabel lblID = new JLabel("ID:");
			lblID.setBounds(25, 11, 46, 14);
			contentPanel.add(lblID);
		}
		{
			JLabel lblProduto = new JLabel("Produto:");
			lblProduto.setBounds(148, 11, 59, 14);
			contentPanel.add(lblProduto);
		}
		{
			JLabel lblBarcode = new JLabel("Barcode:");
			lblBarcode.setBounds(236, 102, 59, 14);
			contentPanel.add(lblBarcode);
		}
		{
			JLabel lblDescricao = new JLabel("Descrição:");
			lblDescricao.setBounds(25, 154, 222, 14);
			contentPanel.add(lblDescricao);
		}
		{
			JLabel lblEstoque = new JLabel("Estoque:");
			lblEstoque.setBounds(25, 55, 86, 14);
			contentPanel.add(lblEstoque);
		}
		{
			JLabel lblEstoqueMin = new JLabel("Estoque Min:");
			lblEstoqueMin.setBounds(131, 55, 86, 14);
			contentPanel.add(lblEstoqueMin);
		}
		{
			JLabel lblValor = new JLabel("Valor:");
			lblValor.setBounds(25, 102, 46, 14);
			contentPanel.add(lblValor);
		}
		{
			JLabel lblUnidade = new JLabel("Unidade Medida:");
			lblUnidade.setBounds(131, 102, 107, 14);
			contentPanel.add(lblUnidade);
		}
		{
			JLabel lblLocal = new JLabel("Local:");
			lblLocal.setBounds(236, 54, 86, 14);
			contentPanel.add(lblLocal);
		}
		{
			txtID = new JTextField();
			txtID.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					String caracteres = "0123456789.";

					if (!caracteres.contains(e.getKeyChar() + "")) {

						e.consume();
					}
				}
			});
			txtID.setEditable(false);
			txtID.setBounds(25, 24, 86, 20);
			contentPanel.add(txtID);
			txtID.setColumns(10);

		}
		{
			txtProdutos = new JTextField();
			txtProdutos.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					listarProdutos();
				}
			});
			txtProdutos.setBounds(146, 24, 182, 20);
			contentPanel.add(txtProdutos);
			txtProdutos.setColumns(10);
			txtProdutos.setDocument(new Validador(50));
		}
		{
			txtEstoque = new JTextField();
			txtEstoque.setDocument(new Validador(5));
			txtEstoque.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					String caracteres = "0123456789.";

					if (!caracteres.contains(e.getKeyChar() + "")) {

						e.consume();
					}
				}
			});
			txtEstoque.setColumns(10);
			txtEstoque.setBounds(25, 71, 86, 20);
			contentPanel.add(txtEstoque);
		}
		{
			txtEstoqueMin = new JTextField();
			txtEstoqueMin.setDocument(new Validador(7));
			txtEstoqueMin.setColumns(10);
			txtEstoqueMin.setBounds(131, 71, 84, 20);
			contentPanel.add(txtEstoqueMin);
		}
		{
			txtValor = new JTextField();
			txtValor.setDocument(new Validador(7));
			txtValor.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					String caracteres = "0123456789.";

					if (!caracteres.contains(e.getKeyChar() + "")) {

						e.consume();
					}
				}
			});
			txtValor.setColumns(10);
			txtValor.setBounds(25, 117, 86, 20);
			contentPanel.add(txtValor);
		}
		{
			txtLocal = new JTextField();
			txtLocal.setColumns(10);
			txtLocal.setBounds(236, 69, 107, 20);
			contentPanel.add(txtLocal);
			txtLocal.setDocument(new Validador(20));
		}
		{
			btnExcluir = new JButton("");
			btnExcluir.setEnabled(false);
			btnExcluir.setToolTipText("Excluir");
			btnExcluir.setIcon(new ImageIcon(Produtos.class.getResource("/img/Apagar.png")));
			btnExcluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					excluirProduto();
				}
			});
			btnExcluir.setBounds(456, 301, 48, 48);
			contentPanel.add(btnExcluir);
		}
		{
			btnLimpar = new JButton("");
			btnLimpar.setIcon(new ImageIcon(Produtos.class.getResource("/img/clear icon.png")));
			btnLimpar.setToolTipText("Limpar");
			btnLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limparCampos();
				}
			});
			btnLimpar.setBounds(73, 301, 48, 48);
			contentPanel.add(btnLimpar);
		}
		{
			btnAdicionar = new JButton("");
			btnAdicionar.setToolTipText("Adicionar");
			btnAdicionar.setIcon(new ImageIcon(Produtos.class.getResource("/img/ADD.png")));
			btnAdicionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					adicionar();
				}
			});
			btnAdicionar.setBounds(199, 301, 48, 48);
			contentPanel.add(btnAdicionar);
		}
		{
			btnEditar = new JButton("");
			btnEditar.setEnabled(false);
			btnEditar.setToolTipText("Editar");
			btnEditar.setIcon(new ImageIcon(Produtos.class.getResource("/img/Editor.png")));
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					editarProduto();
				}
			});
			btnEditar.setBounds(328, 301, 48, 48);
			contentPanel.add(btnEditar);
		}

		cboUN = new JComboBox();
		cboUN.setModel(new DefaultComboBoxModel(new String[] { "UN", "CX ", "PC ", "KG", "M" }));
		cboUN.setBounds(131, 117, 86, 20);
		contentPanel.add(cboUN);

		lblFoto = new JLabel("");
		lblFoto.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblFoto.setForeground(SystemColor.textHighlight);
		lblFoto.setIcon(new ImageIcon(Produtos.class.getResource("/img/Camera.png")));
		lblFoto.setBounds(402, 131, 132, 128);
		contentPanel.add(lblFoto);

		btnCarregar = new JButton("Carregar Foto");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarFoto();
			}
		});
		btnCarregar.setBounds(402, 263, 132, 23);
		contentPanel.add(btnCarregar);

		txtBarcode = new JTextField();
		txtBarcode.setBounds(236, 115, 107, 20);
		contentPanel.add(txtBarcode);
		txtBarcode.setColumns(10);
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(new Color(255, 128, 192));
			lblNewLabel.setBounds(0, 291, 585, 69);
			contentPanel.add(lblNewLabel);
		}
		{
			txtDescricao = new JTextArea();
			txtDescricao.setBounds(25, 168, 271, 110);
			contentPanel.add(txtDescricao);
		}

	}// final construtor
	

	private void listarFornecedor() {
		// System.out.println("Teste");
		// a linha abaixo cria um objeto usando como referência um vetor dinâmico, este
		// obejto irá temporariamente armazenar os dados
		DefaultListModel<String> modelo = new DefaultListModel<>();
		// setar o model (vetor na lista)
		listFornecedor.setModel(modelo);
		// Query (instrução sql)
		String readLista = "select* from fornecedor where nome like '" + txtFornecedor.getText() + "%'"
				+ "order by nome";
		try {
			// abri conexão
			con = dao.conectar();

			pst = con.prepareStatement(readLista);

			rs = pst.executeQuery();

			// uso do while para trazer os usuários enquanto exisitr
			while (rs.next
					()) {
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

	
	private void buscarFornecedor() {
		// System.out.println("teste");
		// variável que captura o indice da linha da lista
		int linha = listFornecedor.getSelectedIndex();
		if (linha >= 0) {
			// Query (instrução sql)
			// limit (0,1) -> seleciona o indice 0 e 1 usuário da lista
			String readListafornecedor = "select * from fornecedor where nome like '" + txtFornecedor.getText() + "%'"
					+ "order by nome";
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

	
	private void limparCampos() {
		txtProdutos.setText(null);
		txtDescricao.setText(null);
		txtIDFornecedor.setText(null);
		txtID.setText(null);
		txtLocal.setText(null);
		txtValor.setText(null);
		txtEstoqueMin.setText(null);
		txtEstoque.setText(null);
		txtFornecedor.setText(null);
		lblFoto.setIcon(new ImageIcon(Produtos.class.getResource("/img/camera.png")));
		cboUN.setSelectedItem("");
	}

	private void adicionar() {
		// System.out.println("teste");
		// Validação de campos obrigatóriios
		if (txtValor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o valor do produto");
			txtValor.requestFocus();
		} else if (txtDescricao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a descrição do produto");
			txtDescricao.requestFocus();
		} else if (txtEstoque.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o estoque atual");
			txtEstoque.requestFocus();
		} else if (txtEstoqueMin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o estoque minimo atual");
			txtEstoqueMin.requestFocus();
		} else if (txtProdutos.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome do produto");
			txtProdutos.requestFocus();
		} else if (lblFoto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a foto do produto");
			lblFoto.requestFocus();
		} else if (txtFornecedor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o fornecedor do produto");
			txtFornecedor.requestFocus();
		} else {

			// lógica pricipal
			// CRUD Creat
			String create = "insert into produtos (nomeprodutos,barcode,descricao,foto,estoque,estoquemin,valor,numeromedida,localarmazenagem,idprodutor) value (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			// tratamento com exceções
			try {
				// abrir conexão
				con = dao.conectar();
				// preparar a execução da query(instrução sql - CRUD Create)
				pst = con.prepareStatement(create);
				pst.setString(1, txtProdutos.getText());
				pst.setString(2, txtBarcode.getText());
				pst.setString(3, txtDescricao.getText());
				pst.setBlob(4, fis, tamanho);
				pst.setString(5, txtEstoque.getText());
				pst.setString(6, txtEstoqueMin.getText());
				pst.setString(7, txtValor.getText());
				pst.setString(8, cboUN.getSelectedItem().toString());
				pst.setString(9, txtLocal.getText());
				pst.setString(10, txtIDFornecedor.getText());

				// executar a query(instruição sql (CRUD - Creat))
				pst.executeUpdate();
				// Confirmar
				JOptionPane.showMessageDialog(null, "Produto adicionado");
				limparCampos();
				// fechar a conexão
			} catch (Exception e) {
				System.out.print(e);
			}
		}
	}

	
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
			String update = "update produtos set nomeprodutos=?, descricao=?, estoque=?, estoquemin=?, valor=?, localarmazenagem=? where idproduto=?";
			// tratamentos de exceçoes
			try {
				// como a conexão
				con = dao.conectar();
				// preparar a query (instrução sql)
				pst = con.prepareStatement(update);
				pst.setString(1, txtProdutos.getText());
				pst.setString(3, txtEstoque.getText());
				pst.setString(4, txtEstoqueMin.getText());
				pst.setString(2, txtDescricao.getText());
				pst.setString(5, txtValor.getText());
				pst.setString(6, txtLocal.getText());
				pst.setString(7, txtID.getText());

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

	private void carregarFoto() {
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("Selecionar Arquivo");
		jfc.setFileFilter(new FileNameExtensionFilter("Arquivo de Imagens(*.PNG, *JPG, *JPEG)", "png", "jpg", "jpeg"));
		int resultado = jfc.showOpenDialog(this);
		if (resultado == JFileChooser.APPROVE_OPTION) {
			try {
				fis = new FileInputStream(jfc.getSelectedFile());
				tamanho = (int) jfc.getSelectedFile().length();
				Image foto = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(lblFoto.getWidth(),
						lblFoto.getHeight(), Image.SCALE_SMOOTH);
				lblFoto.setIcon(new ImageIcon(foto));
				lblFoto.updateUI();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	
	private void listarProdutos() {
		// System.out.println("Teste");
		// a linha abaixo cria um objeto usando como referência um vetor dinâmico, este
		// obejto irá temporariamente armazenar os dados
		DefaultListModel<String> modelo = new DefaultListModel<>();
		// setar o model (vetor na lista)
		listProdutos.setModel(modelo);
		// Query (instrução sql)
		String readLista = "select* from produtos where nomeprodutos like '" + txtProdutos.getText() + "%'"
				+ "order by nomeprodutos";
		try {
			// abri conexão
			con = dao.conectar();

			pst = con.prepareStatement(readLista);

			rs = pst.executeQuery();

			// uso do while para trazer os usuários enquanto exisitr
			while (rs.next
					()) {
				// mostrar a lista
				scrollPaneProdutos.setVisible(true);
				// adicionar os usuarios no vetor -> lista
				modelo.addElement(rs.getString(2));
				// esconder a lista se nenhuma letra for digitada
				if (txtProdutos.getText().isEmpty()) {
					scrollPaneProdutos.setVisible(false);
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void buscarProdutos() {
		// System.out.println("teste");
		// variável que captura o indice da linha da lista
		int linha = listProdutos.getSelectedIndex();
		if (linha >= 0) {
			// Query (instrução sql)
			// limit (0,1) -> seleciona o indice 0 e 1 usuário da lista
			String readListaprodutos = "select * from produtos where nomeprodutos like '" + txtProdutos.getText() + "%'"
					+ "order by nomeprodutos";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readListaprodutos);
				rs = pst.executeQuery();
				if (rs.next()) {
					// esconder a lista
					scrollPaneProdutos.setVisible(false);
					// setar campos
					txtID.setText(rs.getString(1));
					txtProdutos.setText(rs.getString(2));
					txtValor.setText(rs.getString(3)); 
					txtDescricao.setText(rs.getString(4));
					Blob blob = (Blob) rs.getBlob(5);
					txtEstoque.setText(rs.getString(6));
					txtEstoqueMin.setText(rs.getString(7));
					txtValor.setText(rs.getString(8));
					cboUN.setSelectedItem(rs.getString(9));
					txtLocal.setText(rs.getString(10));
					txtIDFornecedor.setText(rs.getString(11));
					
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
					btnAdicionar.setEnabled(false);
					

					byte[] img = blob.getBytes(1, (int) blob.length());
					BufferedImage imagem = null;
					
				try {
					imagem = ImageIO.read(new ByteArrayInputStream(img));
				} catch (Exception e) {
					System.out.println(e);
				}
				ImageIcon icone = new ImageIcon(imagem);
				Icon foto = new ImageIcon(icone.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH));
					lblFoto.setIcon(foto);
				} else {
					// se não existir um contato no banco
					JOptionPane.showMessageDialog(null, "Produto inexistente");
					}
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			// se não existir no banco um usuário da lista
			scrollPaneProdutos.setVisible(false);
			
		}
	}

}
