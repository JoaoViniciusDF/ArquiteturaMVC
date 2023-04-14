package DAO;

import java.util.ArrayList;
import Model.Funcionario;

public class TesteFuncionarioDAO {

	public static void main(String[] args) {

		//Instanciando objeto de FuncionarioDAO
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		//Instanciando objetos de Funcionario
		Funcionario funcionario1 = new Funcionario("João Vinicius", "34978387290", "892.939.723-75",  "Montador");
		Funcionario funcionario2 = new Funcionario("Gustavo", "34993543378","873.342.765-09",  "Atendente");
		Funcionario funcionario3 = new Funcionario("Caian", "34993484737", "094.728.472-88",  "Limpeza");
		
		//Inserindo objetos de funcionario no banco de dados através do método na DAO
		funcionarioDAO.inserirFuncionario(funcionario1);
		funcionarioDAO.inserirFuncionario(funcionario2);
		
		//Retornando no console se os funcionarios foram cadastrados com sucesso
		if(funcionarioDAO.inserirFuncionario(funcionario3)) {
			System.out.print("Funcionários cadastrados com sucesso!\n\n");
		}
		
		//Imprimindo a Table de Funcionarios no console
		ArrayList<Funcionario> lista = funcionarioDAO.listarFuncionario();
		for(int i = 0; i < lista.size(); i++) {
			
			System.out.print(lista.get(i));
			
		}
		
		//Retornando no console se o funcionario foi excluido da Tabela do banco de dados com sucesso
		if(funcionarioDAO.excluirFuncionario(funcionario3)) {
			System.out.print("Funcionário excluido com sucesso!\n\n");
		}
		
		//Imprimindo a Table de Funcionarios no console
		ArrayList<Funcionario> lista2 = funcionarioDAO.listarFuncionario();
		for(int i = 0; i < lista2.size(); i++) {
			
			System.out.print(lista2.get(i));
			
		}
		
		
	}

}
