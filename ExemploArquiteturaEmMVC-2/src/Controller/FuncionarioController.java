package Controller;

import Model.Funcionario;
import DAO.FuncionarioDAO;
import java.util.ArrayList;

public class FuncionarioController {

	private FuncionarioDAO funcionario;
	
	//Criando chamada de método inserir da DAO de dentro da Controller
	public boolean controllerSalvarFuncionario(Funcionario novoFuncionario) {
	
		//Instanciando FuncionariosDAO
		this.funcionario = new FuncionarioDAO();
		
		//Retornando o método de inserir da DAO
		return this.funcionario.inserirFuncionario(novoFuncionario);
	
	}
	
	//Criando chamada de método excluir da DAO de dentro da Controller
	public boolean controllerExcluirFuncionario(Funcionario cpfFuncionario) {
		
		//Instanciando FuncionariosDAO
		this.funcionario = new FuncionarioDAO();
		
		//Retornando o método de exlcuir da DAO
		return this.funcionario.excluirFuncionario(cpfFuncionario);
	
	}
	
	//Criando chamada de método listar da DAO de dentro da Controller
	public ArrayList<Funcionario> controllerListarClientes(){
		
		//Instanciando FuncionariosDAO
		this.funcionario = new FuncionarioDAO();
		
		//Retornando o método de listar da DAO
		return this.funcionario.listarFuncionario();
		
	}

	
}
