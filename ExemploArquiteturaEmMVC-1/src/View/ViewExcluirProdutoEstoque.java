package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


import Controller.EstoqueController;

import Model.Estoque;
import java.awt.Font;

public class ViewExcluirProdutoEstoque extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewExcluirProdutoEstoque frame = new ViewExcluirProdutoEstoque();
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
	public ViewExcluirProdutoEstoque() {

		
		setTitle("Exclua um Produto do Estoque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 37, 372, 171);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(283, 11, 118, 20);
		contentPane.add(txtCodigo);
		
		JLabel lblNomeProduto = new JLabel("Digite o código do produto que deseja excluir:");
		lblNomeProduto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomeProduto.setBounds(29, 10, 244, 20);
		contentPane.add(lblNomeProduto);
	
		//Instanciando Controller e Estoque
		EstoqueController controllerEstoque = new EstoqueController();
	    ArrayList<Estoque> listaProduto = controllerEstoque.controllerListarProdutos();
	    
	    //Criando tabela na view
	    DefaultTableModel tbl = (DefaultTableModel) table.getModel();
	    tbl.addColumn("Codigo");
	    tbl.addColumn("Nome");
	    tbl.addColumn("Tipo");
        tbl.addColumn("Quantidade");
		

        //Criando objetos na lista da View ao abri-la
		try {
			
			//Adicionando os objetos da tabela do banco de dados na tabela da view
			tbl.setRowCount(0);
            for (int i = 0; i < listaProduto.size(); i++) {
                
            	Estoque produto = listaProduto.get(i);
                tbl.addRow(new Object[] {produto.getCodigo() ,produto.getNomeProduto(), produto.getTipoDeProduto(), produto.getQuantidadeEmEstoque()});
                
            }
			
        //Retornando erro caso não seja possivel retornar os valores da tabela 
		} catch (NumberFormatException x) {
			
			x.printStackTrace();
            JOptionPane.showMessageDialog(null,"Erro ao atualizar a lista de produtos");
		
		}
		
		//Criando o botão de excluir na view
		JButton btnExcluirProduto = new JButton("Excluir Produto");
        btnExcluirProduto.addActionListener(new ActionListener() {
			
        	//Criando evento para chamar o método de excluir da DAO
        	public void actionPerformed(ActionEvent e) {
				
        		//Se o campo estiver em branco irá retornar mensagem de erro
				if(txtCodigo.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null,"Erro ao excluir produto do estoque, valor invalido ou em branco");
					
				}else {
				
					//Excluindo valor desejado com base no valor passado no campo
					try {
						
						for(int a = 0; a <  listaProduto.size(); a++) {
							
							if(listaProduto.get(a).getCodigo() == Integer.parseInt(txtCodigo.getText())) {
							
						        controllerEstoque.controllerExcluirProdutoNoEstoque(listaProduto.get(a));
						        JOptionPane.showMessageDialog(null,"Produto removido com sucesso");
						        
						    }
							
						}
			        
					//Retornando mensagem de erro caso não seja  possivel excluir produto
			        } catch (Exception ex) {
			        	
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(null,"Erro ao remover produto do estoque, valor invalido ou em branco");
			            
			        }
				}
				
			}
		});
        btnExcluirProduto.setBounds(232, 227, 169, 23);
		contentPane.add(btnExcluirProduto);
		
		//Criando botão de retornar ao estoque
		JButton btnRetornarAEstoque = new JButton("Retornar a Estoque");
		btnRetornarAEstoque.addActionListener(e -> {
			ViewEstoque viewEstoque = new ViewEstoque();
			viewEstoque.setVisible(true);
			dispose();
		});
		btnRetornarAEstoque.setBounds(29, 227, 169, 23);
		contentPane.add(btnRetornarAEstoque);
	} 
}