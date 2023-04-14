package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.FuncionarioController;
import Model.Funcionario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JEditorPane;

public class ViewExcluirFuncionario extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnVoltarAHomw;
	private FuncionarioController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewExcluirFuncionario frame = new ViewExcluirFuncionario();
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
	public ViewExcluirFuncionario() {
		ButtonGroup group = new ButtonGroup();
		controller = new FuncionarioController(); 
		
		setTitle("Excluir funcionarios: ");
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
		
		//Instanciando Controller e Estoque
		FuncionarioController controllerFuncionario = new FuncionarioController();
		ArrayList<Funcionario> listaFuncionarios = controllerFuncionario.controllerListarClientes();
		
		//Criando tabela na view
		DefaultTableModel tbl = (DefaultTableModel) table.getModel();
		tbl.addColumn("Cpf");
		tbl.addColumn("Nome");
		tbl.addColumn("Telefone");
		tbl.addColumn("Cargo");
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					//Adicionando os objetos da tabela do banco de dados na tabela da view
					tbl.setRowCount(0);
					for(int i = 0; i < listaFuncionarios.size(); i++) {
						
						Funcionario funcionario = listaFuncionarios.get(i);
						tbl.addRow(new Object[] {funcionario.getCPF(), funcionario.getNome(), funcionario.getTelefone(), funcionario.getCargo()});
						
					}
				
				//Retornando erro caso não seja possivel retornar os valores da tabela 
				}catch(Exception x) {
					
					x.printStackTrace();
		            JOptionPane.showMessageDialog(null,"Erro ao atualizar a lista de funcionarios");
		        
				}
				
			}
			
		});
		btnAtualizar.setBounds(315, 219, 114, 23);
		contentPane.add(btnAtualizar);
		
		
		JLabel lblMensagem = new JLabel("Cpf do funcionario a ser excluido:");
		lblMensagem.setBounds(10, 10, 205, 23);
		contentPane.add(lblMensagem);
		
		JEditorPane lblCpfAExcluir = new JEditorPane();
		lblCpfAExcluir.setBounds(225, 13, 107, 20);
		contentPane.add(lblCpfAExcluir);
		
		//Criando o botão de excluir na view
		JButton btnExcluirFuncionario = new JButton("Excluir Funcionário");
		btnExcluirFuncionario.setBounds(166, 219, 152, 23);
		btnExcluirFuncionario.addActionListener(new ActionListener() {
			
			//Criando evento para chamar o método de excluir da DAO
			public void actionPerformed(ActionEvent e) {
				
				//Se o campo estiver em branco irá retornar mensagem de erro
				if(lblCpfAExcluir.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null,"Erro ao excluir funcionário, valor invalido ou em branco");
					
				}else {
				
					//Excluindo valor desejado com base no valor passado no campo
					try {
						
						String cpf = lblCpfAExcluir.getText();
						Funcionario CpfFuncionario = new Funcionario(cpf);
						controller.controllerExcluirFuncionario(CpfFuncionario);
						group.clearSelection();
						JOptionPane.showMessageDialog(null,"Funcionario excluido com sucesso!");
						
					//Retornando mensagem de erro caso não seja  possivel excluir funcionario
					}catch(Exception x) {
						
						x.printStackTrace();
			            JOptionPane.showMessageDialog(null,"Erro ao excluir funcionário, valor invalido ou em branco");
			        
					}
				}
				
			}
			
		});
		contentPane.add(btnExcluirFuncionario);
		
		//Criando botão de retornar ao gerenciador
		JButton btnVoltarAoGerenciador = new JButton("Voltar ao gerenciador");
		btnVoltarAoGerenciador.addActionListener(e -> {
	        ViewGerenciadorFuncionario viewGerenciarFuncionario = new ViewGerenciadorFuncionario();
	        viewGerenciarFuncionario.setVisible(true);
	        dispose();
		});
		btnVoltarAoGerenciador.setBounds(10, 219, 158, 23);
		contentPane.add(btnVoltarAoGerenciador);
		
		
		
	}
}