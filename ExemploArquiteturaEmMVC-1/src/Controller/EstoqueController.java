package Controller;

import java.util.ArrayList;
import DAO.EstoqueDAO;
import Model.Estoque;

public class EstoqueController {
	
private EstoqueDAO estoque;
	
	//Criando chamada de método inserir da DAO de dentro da Controller
	public boolean controllerSalvarProdutoNoEstoque(Estoque novoFuncionario) {
	
		//Instanciando FuncionariosDAO
		this.estoque = new EstoqueDAO();
		
		//Retornando o método de inserir da DAO
		return this.estoque.inserirProdutoNoEstoque(novoFuncionario);
	
	}
	
	//Criando chamada de método excluir da DAO de dentro da Controller
	public boolean controllerExcluirProdutoNoEstoque(Estoque novoFuncionario) {
		
		//Instanciando FuncionariosDAO
		this.estoque = new EstoqueDAO();
		
		//Retornando o método de excluir da DAO
		return this.estoque.excluirProduto(novoFuncionario);
	
	}
	
	//Criando chamada de método listar da DAO de dentro da Controller
	public ArrayList<Estoque> controllerListarProdutos(){
		
		//Instanciando FuncionariosDAO
		this.estoque = new EstoqueDAO();
		
		//Retornando o método de listar da DAO
		return this.estoque.listarProduto();
		
	}
	
}
