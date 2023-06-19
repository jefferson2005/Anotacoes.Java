package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class Produtos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtProdutos;
	private JTextField txtEstoque;
	private JTextField txtEstoqueMin;
	private JTextField txtValor;
	private JTextField txtLocal;
	private JTextField txtFornecedor;

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
		setBounds(100, 100, 601, 401);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Fornecedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 286, 223, 52);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		txtFornecedor = new JTextField();
		txtFornecedor.setBounds(106, 19, 76, 17);
		panel.add(txtFornecedor);
		txtFornecedor.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome Fornecedor:");
		lblNewLabel.setBounds(10, 21, 100, 14);
		panel.add(lblNewLabel);
		{
			JLabel lblID = new JLabel("ID:");
			lblID.setBounds(10, 11, 46, 14);
			contentPanel.add(lblID);
		}
		{
			JLabel lblProduto = new JLabel("Produtos");
			lblProduto.setBounds(10, 37, 46, 14);
			contentPanel.add(lblProduto);
		}
		{
			JLabel lblBarcode = new JLabel("Barcode");
			lblBarcode.setBounds(342, 11, 46, 14);
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
			lblEstoque.setBounds(10, 137, 46, 14);
			contentPanel.add(lblEstoque);
		}
		{
			JLabel lblEstoqueMin = new JLabel("Estoque Minimo:");
			lblEstoqueMin.setBounds(10, 162, 46, 14);
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
			txtEstoque.setBounds(66, 134, 86, 20);
			contentPanel.add(txtEstoque);
		}
		{
			txtEstoqueMin = new JTextField();
			txtEstoqueMin.setColumns(10);
			txtEstoqueMin.setBounds(66, 159, 86, 20);
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
			JButton btnExcluir = new JButton("Excluir");
			btnExcluir.setBounds(229, 38, 89, 23);
			contentPanel.add(btnExcluir);
		}
		{
			JButton btnLimpar = new JButton("Limpar");
			btnLimpar.setBounds(229, 74, 89, 23);
			contentPanel.add(btnLimpar);
		}
		{
			JButton btnAdicionar = new JButton("Adicionar");
			btnAdicionar.setBounds(229, 108, 89, 23);
			contentPanel.add(btnAdicionar);
		}
		{
			JButton btnEditar = new JButton("Editar");
			btnEditar.setBounds(229, 153, 89, 23);
			contentPanel.add(btnEditar);
		}
		
		JTextPane txtDescricao = new JTextPane();
		txtDescricao.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtDescricao.setBounds(306, 237, 269, 101);
		contentPanel.add(txtDescricao);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(229, 7, 89, 23);
		contentPanel.add(btnBuscar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"UN", "CX ", "PC ", "KG", "M"}));
		comboBox.setBounds(66, 208, 86, 20);
		contentPanel.add(comboBox);
	}
}
