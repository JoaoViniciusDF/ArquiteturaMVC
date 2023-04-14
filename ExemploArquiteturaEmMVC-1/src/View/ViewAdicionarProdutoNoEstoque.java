package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import Controller.EstoqueController;

import Model.Estoque;

public class ViewAdicionarProdutoNoEstoque extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtTipo;
	private JTextField txtQuantidade;
	private JTextField textFieldCodigo;
	private EstoqueController controller;
	private JRadioButton rdbtnAcompanhamento;
	private JRadioButton rdbtnBedida;
	private JRadioButton rdbtnAperitivo;
	private JRadioButton rdbtnOutros;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAdicionarProdutoNoEstoque frame = new ViewAdicionarProdutoNoEstoque();
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
	public ViewAdicionarProdutoNoEstoque() {
		ButtonGroup group = new ButtonGroup();
		controller = new EstoqueController();
		
		setTitle("Adicione um Produto no Estoque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeProduto = new JLabel("Nome:");
		lblNomeProduto.setBounds(71, 52, 114, 20);
		contentPane.add(lblNomeProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(71, 82, 114, 20);
		contentPane.add(lblQuantidade);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(71, 22, 114, 20);
		contentPane.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setColumns(10);
		textFieldCodigo.setBounds(260, 23, 114, 20);
		contentPane.add(textFieldCodigo);
		
		txtNome = new JTextField();
		txtNome.setBounds(260, 53, 114, 20);
		txtNome.setColumns(10);
		contentPane.add(txtNome);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(71, 121, 46, 14);
		contentPane.add(lblTipo);
		
		
		rdbtnAcompanhamento = new JRadioButton("Acompanhamento");
		rdbtnAcompanhamento.setBounds(159, 117, 136, 23);
		buttonGroup.add(rdbtnAcompanhamento);
		contentPane.add(rdbtnAcompanhamento);
		
		rdbtnBedida = new JRadioButton("Bebida");
		rdbtnBedida.setBounds(297, 117, 70, 23);
		buttonGroup.add(rdbtnBedida);
		contentPane.add(rdbtnBedida);

		rdbtnAperitivo = new JRadioButton("Aperitivo");
		rdbtnAperitivo.setBounds(159, 155, 89, 23);
		buttonGroup.add(rdbtnAperitivo);
		contentPane.add(rdbtnAperitivo);
		
		rdbtnOutros = new JRadioButton("Outros");
		rdbtnOutros.setBounds(297, 155, 89, 23);
		buttonGroup.add(rdbtnOutros);
		contentPane.add(rdbtnOutros);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(260, 83, 114, 20);
		txtQuantidade.setColumns(10);
		contentPane.add(txtQuantidade);
		
		JButton btnRetornarAEstoque = new JButton("Retornar a Estoque");
		btnRetornarAEstoque.setBounds(35, 206, 169, 23);
		btnRetornarAEstoque.addActionListener(e -> {
			ViewEstoque viewEstoque = new ViewEstoque();
			viewEstoque.setVisible(true);
			dispose();
		});
		contentPane.add(btnRetornarAEstoque);
		
		//Criando o botão de inserir funcionario no banco de dados
		JButton btnAdicionarProduto = new JButton("Adicionar Produto");
		btnAdicionarProduto.setBounds(237, 206, 169, 23);
		btnAdicionarProduto.addActionListener(new ActionListener() {
			
			//Criando evento para chamar o método de inserir da DAO
			public void actionPerformed(ActionEvent e) {
				
				//Se algum valor estiver nulo exibir mensagem de erro
				if(txtNome.getText().isEmpty() || txtNome.getText().isEmpty() || textFieldCodigo.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null,"Erro ao adicionar produto no estoque, valor invalido ou em branco");
					
				}else {
					
					//Adicionando os valores passados na view com o metodo da DAO
					try {
						
						String nome = txtNome.getText();
						int quantidade = Integer.parseInt(txtQuantidade.getText());
						String tipo = "";
						int codigo = Integer.parseInt(textFieldCodigo.getText());
		
				        if (rdbtnAcompanhamento.isSelected()) {
				        	tipo = "Acompanhamento";
				        } else if (rdbtnBedida.isSelected()) {
				        	tipo = "Bebida";
				        } else if (rdbtnAperitivo.isSelected()) {
				        	tipo = "Aperitivo";
				        } else if (rdbtnAperitivo.isSelected()) {
				        	tipo = "Outros";
				        }	        
				  
				        //Instanciando valores passados
						Estoque novoProduto = new Estoque(codigo, nome, tipo, quantidade);
						
						//Chamando método de adicionar objeto ao banco de dados
						boolean adicionou = controller.controllerSalvarProdutoNoEstoque(novoProduto);
						
						//Exibir mensagem de caso seja adcionado com sucesso
						group.clearSelection();
						JOptionPane.showMessageDialog(null,"Produto adicionado no estoque com sucesso!");
						
					//Exibir mensagem de erro caso não seja adcionado 
					}catch(Exception x) {
						
						x.printStackTrace();
			            JOptionPane.showMessageDialog(null,"Erro ao adicionar produto no estoque, valor invalido ou em branco");
			        
					}
			
				}
			}
		});
		contentPane.add(btnAdicionarProduto);
			
	} 
}