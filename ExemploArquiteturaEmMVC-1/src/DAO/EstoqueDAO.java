package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Estoque;



public class EstoqueDAO {

	private Connection conn;

	//Estabelecendo conexão com banco de dados
	public EstoqueDAO() {
			
			//Sempre que um objeto DAO é instanciado um conexão com um banco de dados é estabelecida
			
			this.conn = null;
			String url = "jdbc:mysql://localhost/acaiteria";//Caminho do banco de dados local na máquina
			String user = "root";//Usuário do banco de dados local
			String password = "@Secreto2003";//Senha do banco de dados local
			
			try {
	
				conn = DriverManager.getConnection(url, user, password);
				System.out.println("Conexão com banco de dados estabelecida");
			
			}catch(SQLException e) {
				
				e.printStackTrace();
			
			}
		
		}
	
	//Criando método de inserir um produdo na tabela de Estoque do banco de dados
	public boolean inserirProdutoNoEstoque(Estoque estoque) {
		
		//Criando o comando SQL que irá ser usado
		String sql = "INSERT INTO Estoque(codigo, nome, tipo, quantidadeEmEstoque) VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE quantidadeEmEstoque = quantidadeEmEstoque + ?";
		
		try {
			
			//Usando o comando SQL criado no método no banco de dados
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, estoque.getCodigo());
			ps.setString(2, estoque.getNomeProduto());
			ps.setString(3, estoque.getTipoDeProduto());
			ps.setInt(4, estoque.getQuantidadeEmEstoque());
			ps.setInt(5, estoque.getQuantidadeEmEstoque());
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
	public boolean excluirProduto(Estoque produto) {
		
		//Criando o comando SQL que irá ser usado
		String sql = "DELETE FROM Estoque WHERE codigo = ?";
		
		try {
			
			//Usando o comando SQL criado no método no banco de dados
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, produto.getCodigo());
			ps.executeUpdate();
			
			//Retornando um valor verdadeiro caso o método seja executado
			return true;
			
		}catch(SQLException e) {
			
			//Retornando execeção e valor falso caso não seja executado o método
			e.printStackTrace();
			return false;
			
		}
	}
	
	//Criando um método para listar Produtos na tabela de Produtos
	public ArrayList<Estoque> listarProduto(){
		
		ArrayList<Estoque> listaEstoque = new ArrayList<Estoque>();//Instanciando uma lista de Estoque
		String sql = "SELECT * FROM Estoque";//Criando o comando SQL a ser usado no método
		
		try {
			
			//Usando o comando SQL criado no método no banco de dados
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			//Pegar os valores de cada linha da tabela enquanto houver uma próxima linha
			while(rs.next()) {
				
				//Pegando os atributos desejados da tabela do banco de dados
				int codigo = rs.getInt("codigo");
				String nomeProduto = rs.getString("nome");
				String tipoDeProduto = rs.getString("tipo");
				int quantidadeEmEstoque = rs.getInt("quantidadeEmEstoque");
				Estoque estoque = new Estoque(codigo, nomeProduto, tipoDeProduto, quantidadeEmEstoque);
				listaEstoque.add(estoque);
				
			}
			
			//Retornando a lista de Estoque
			return listaEstoque;
			
		}catch(SQLException e) {
			
			//Retornando execeção e valor falso caso não seja executado o método
			e.printStackTrace();
			return listaEstoque;
			
		}
			
	}
	
	
	
}