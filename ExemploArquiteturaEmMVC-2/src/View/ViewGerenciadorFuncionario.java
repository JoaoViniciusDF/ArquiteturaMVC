package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ViewGerenciadorFuncionario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewGerenciadorFuncionario frame = new ViewGerenciadorFuncionario();
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
	public ViewGerenciadorFuncionario() {
		setTitle("Gerenciador de Funcionarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Criando botão para ir até a View Adicionar Funcionário
		JButton btnAdicionarFuncionario = new JButton("Adicionar Funcionário");
		btnAdicionarFuncionario.setBounds(80, 89, 248, 23);
		btnAdicionarFuncionario.addActionListener(e -> {
	        ViewCadastroFuncionario viewCadastroFuncionario = new ViewCadastroFuncionario();
	        viewCadastroFuncionario.setVisible(true);
	        dispose();
		});
		contentPane.add(btnAdicionarFuncionario);
		
		//Criando botão para ir até a View Deletar Funcionário
		JButton btnDeletarFuncionrio = new JButton("Deletar Funcionário");
		btnDeletarFuncionrio.setBounds(80, 123, 248, 23);
		btnDeletarFuncionrio.addActionListener(e -> {
        	ViewExcluirFuncionario viewDeletarFuncionario = new ViewExcluirFuncionario();
        	viewDeletarFuncionario.setVisible(true);
			dispose();
        });
		contentPane.add(btnDeletarFuncionrio);
		
	}
}