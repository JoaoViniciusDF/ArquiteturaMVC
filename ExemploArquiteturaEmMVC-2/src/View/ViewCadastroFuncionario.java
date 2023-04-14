package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.FuncionarioController;
import Model.Funcionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class ViewCadastroFuncionario extends JFrame {
	
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
    private JTextField textFieldCPF;
    private FuncionarioController controller;
    private JRadioButton rdbtnMontador;
	private JRadioButton rdbtnAtendente;
	private JRadioButton rdbtnLimpeza;
	private final ButtonGroup buttonGroup = new ButtonGroup();
    
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastroFuncionario frame = new ViewCadastroFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ViewCadastroFuncionario() {
		ButtonGroup group = new ButtonGroup();
		controller = new FuncionarioController(); 
		
		setTitle("Cadastre um novo funcionário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(71, 125, 46, 14);
		
		contentPane.add(lblNome);
		textFieldNome = new JTextField();
		textFieldNome.setBounds(152, 122, 224, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(71, 156, 81, 14);
		
		contentPane.add(lblTelefone);
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(152, 153, 224, 20);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
        JLabel lblCPF = new JLabel("CPF:");
        lblCPF.setBounds(71, 187, 46, 14);
        
        contentPane.add(lblCPF);
        textFieldCPF = new JTextField();
        textFieldCPF.setBounds(152, 184, 224, 20);
        contentPane.add(textFieldCPF);
        textFieldCPF.setColumns(10);
        
        JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(71, 231, 46, 14);
		contentPane.add(lblCargo);
		
		rdbtnMontador = new JRadioButton("Montador");
		rdbtnMontador.setBounds(118, 181, 81, 23);
		buttonGroup.add(rdbtnMontador);
		rdbtnMontador.setBounds(152, 227, 89, 23);
		contentPane.add(rdbtnMontador);

		rdbtnAtendente = new JRadioButton("Atendente");
		rdbtnAtendente.setBounds(118, 181, 81, 23);
		buttonGroup.add(rdbtnAtendente);
		rdbtnAtendente.setBounds(243, 227, 89, 23);
		contentPane.add(rdbtnAtendente);

		rdbtnLimpeza = new JRadioButton("Limpeza");
		rdbtnLimpeza.setBounds(118, 181, 81, 23);
		buttonGroup.add(rdbtnLimpeza);
		rdbtnLimpeza.setBounds(335, 227, 89, 23);
		contentPane.add(rdbtnLimpeza);
        
		//Criando o botão de inserir funcionario no banco de dados
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(272, 39, 104, 23);
		btnCadastrar.addActionListener(new ActionListener() {
		    
			//Criando evento para chamar o método de inserir da DAO
			public void actionPerformed(ActionEvent e) {

		    	//Se algum valor estiver nulo exibir mensagem de erro
		    	if(textFieldNome.getText().isEmpty() || textFieldTelefone.getText().isEmpty() || textFieldCPF.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null,"Erro ao remover produto, valor invalido ou em branco");
					
				}else {
				
					//Adicionando os valores passados na view com o metodo da DAO
					try {
						
				        String nome = textFieldNome.getText();
				        String telefone = textFieldTelefone.getText();
				        String cpf = textFieldCPF.getText();
				        String cargo = "";
		
				        if (rdbtnMontador.isSelected()) {
				            cargo = "Montador";
				        } else if (rdbtnAtendente.isSelected()) {
				            cargo = "Atendente";
				        } else if (rdbtnLimpeza.isSelected()) {
				            cargo = "Limpeza";
				        }
		
				        //Instanciando valores passados
				        Funcionario novoFuncionario = new Funcionario(nome, telefone, cpf, cargo);
				        
				        //Chamando método de adicionar objeto ao banco de dados
				        boolean adicionou = controller.controllerSalvarFuncionario(novoFuncionario);
				        
				        //Exibir mensagem de caso seja adcionado com sucesso
				        group.clearSelection();
				        JOptionPane.showMessageDialog(null,"Sucesso ao adicionar funcionário!");
				        
				    //Exibir mensagem de erro caso não seja adcionado 
					}catch(Exception x) {
						
						x.printStackTrace();
			            JOptionPane.showMessageDialog(null,"Erro ao salvar produto, valor invalido ou em branco");
			        
					}
				}
		    }
		});
		contentPane.add(btnCadastrar);
		
		//Criando botão para voltar ao gerenciador
		JButton btnVoltarAHome = new JButton("Voltar ao gerenciador");
		btnVoltarAHome.addActionListener(e -> {
			ViewGerenciadorFuncionario viewGerenciarFuncionario = new ViewGerenciadorFuncionario();
			viewGerenciarFuncionario.setVisible(true);
			dispose();
		});
		
		btnVoltarAHome.setBounds(28, 39, 199, 23);
		contentPane.add(btnVoltarAHome);
		
		
		
		
	}
	
	
}
