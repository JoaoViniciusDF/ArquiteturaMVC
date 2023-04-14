package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.EstoqueController;
import Model.Estoque;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ViewEstoque extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEstoque frame = new ViewEstoque();
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
	public ViewEstoque() {
		setTitle("Estoque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 414, 171);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblEstoque = new JLabel("Estoque:");
		lblEstoque.setBounds(10, 11, 77, 23);
		contentPane.add(lblEstoque);
		
		//Instanciando Controller e Model
		EstoqueController controllerEstoque = new EstoqueController();
	    ArrayList<Estoque> listaProduto = controllerEstoque.controllerListarProdutos();
	    
	    //Criando tabela
	    DefaultTableModel tbl = (DefaultTableModel) table.getModel();
	    tbl.addColumn("Nome");
	    tbl.addColumn("Tipo");
        tbl.addColumn("Quantidade");
		
        //Criando botão para chamar método da DAO
		JButton btnConferirEstoque = new JButton("Atualizar");
		btnConferirEstoque.addActionListener(new ActionListener() {
			
			//Criando evento para chamar método da DAO
			public void actionPerformed(ActionEvent e) {
			    
				try {
					
					//Adicionando as linhas da Tabela do banco de dados na tabela da View
		            tbl.setRowCount(0);
		            for (int i = 0; i < listaProduto.size(); i++) {
		                Estoque produto = listaProduto.get(i);
		                tbl.addRow(new Object[] {produto.getNomeProduto(), produto.getTipoDeProduto(), produto.getQuantidadeEmEstoque()});
		               
		            }
		            
		        } catch (Exception ex) {
		        	
		        	//Retornando mensagem de erro caso método falhe
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null,"Erro ao atualizar a lista de produtos");
		            
		        }
				
			}
		});
		btnConferirEstoque.setBounds(272, 11, 152, 23);
		contentPane.add(btnConferirEstoque);
		
		//Criando botão de mudar para view Adicionar Produto
		JButton btnAdicionarProduto = new JButton("Adicionar Produto");
		btnAdicionarProduto.addActionListener(e -> {
			ViewAdicionarProdutoNoEstoque viewAdicionarProdutoNoEstoque = new ViewAdicionarProdutoNoEstoque();
			viewAdicionarProdutoNoEstoque.setVisible(true);
			dispose();
		});
		btnAdicionarProduto.setBounds(275, 227, 136, 23);
		contentPane.add(btnAdicionarProduto);
		
		//Criando botão de mudar para view Excluir Produto
		JButton btnExcluirProduto = new JButton("Excluir Produto");
		btnExcluirProduto.addActionListener(e -> {
			ViewExcluirProdutoEstoque viewExcluirProdutoEstoque = new ViewExcluirProdutoEstoque();
			viewExcluirProdutoEstoque.setVisible(true);
			dispose();
		});
		btnExcluirProduto.setBounds(142, 227, 136, 23);
		contentPane.add(btnExcluirProduto);
	}
}
