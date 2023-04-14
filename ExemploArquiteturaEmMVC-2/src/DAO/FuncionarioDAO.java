package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Funcionario;


public class FuncionarioDAO {

private Connection conn;
	
	//Estabelecendo conexão com banco de dados
	public FuncionarioDAO() {
		
		//Sempre que um objeto DAO é instanciado um conexão com um banco de dados é estabelecida
		
		this.conn = null;
		String url = "jdbc:mysql://localhost/acaiteria";
		String user = "root";
		String password = "@Secreto2003";
		
		try {

			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conexão com banco de dados estabelecida");
		
		}catch(SQLException e) {
			
			e.printStackTrace();
		
		}
	
	}
	
	//Criando método de inserir um funcionario na tabela de Funcionarios do banco de dados
	public boolean inserirFuncionario(Funcionario funcionario) {
		
		//Criando o comando SQL que irá ser usado
		String sql = "INSERT INTO Funcionarios( cpf, nome, telefone, cargo, salario) VALUES(?, ?, ?, ?, ?)";
		
		try {
			
			//Usando o comando SQL criado no método no banco de dados
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, funcionario.getCPF());
			ps.setString(2, funcionario.getNome());
			ps.setString(3, funcionario.getTelefone());
			ps.setString(4, funcionario.getCargo());
			ps.setDouble(5, funcionario.getSalario());
			ps.execute();

			//Retornando um valor verdadeiro caso o método seja executado
			return true;

		}catch(SQLException e) {

			//Retornando execeção e valor falso caso não seja executado o método
			e.printStackTrace();
			return false;

		}
		
	}
	
	//Criando método para excluir um produto da tabela Estoque do banco de dados
	public boolean excluirFuncionario(Funcionario cpfFuncionario) {
		
		//Criando o comando SQL que irá ser usado
		String sql = "DELETE FROM Funcionarios WHERE cpf = ?";
		
		try {
			
			//Usando o comando SQL criado no método no banco de dados
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cpfFuncionario.getCPF());
			ps.executeUpdate();
			
			//Retornando um valor verdadeiro caso o método seja executado
			return true;
			
		}catch(SQLException e) {
			
			//Retornando execeção e valor falso caso não seja executado o método
			e.printStackTrace();
			return false;
			
		}
	}
	
	//Criando um método para listar Funcinarios da tabela de funcionarios 
	public ArrayList<Funcionario> listarFuncionario(){
		
		ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();//Instanciando uma lista de Funcionario
		String sql = "SELECT * FROM Funcionarios";//Criando o comando SQL a ser usado no método
		
		try {
			
			//Usando o comando SQL criado no método no banco de dados
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			//Pegar os valores de cada linha da tabela enquanto houver uma próxima linha
			while(rs.next()) {
				
				//Pegando os atributos desejados da tabela do banco de dados
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String telefone = rs.getString("telefone");
				String cargo = rs.getString("cargo");
				double salario = rs.getDouble("salario");
				Funcionario funcionario = new Funcionario(nome, telefone, cpf, cargo);
				listaFuncionarios.add(funcionario);
				
			}
			
			//Retornando a lista de Funcionarios
			return listaFuncionarios;
			
		}catch(SQLException e) {
			
			//Retornando execeção e valor falso caso não seja executado o método
			e.printStackTrace();
			return listaFuncionarios;
			
		}
			
	}
	
}