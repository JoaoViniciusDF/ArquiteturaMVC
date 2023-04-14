package DAO;

import java.util.ArrayList;
import Model.Estoque;


public class TesteEstoqueDAO {

	public static void main(String[] args) {
		
		//Instanciando objeto de EstoqueDAO
		EstoqueDAO estoqueDAO = new EstoqueDAO();
		
		//Instanciando objetos de Estoque
		Estoque produto1 = new Estoque(1, "Morango", "Acompanhamento", 20);
		Estoque produto2 = new Estoque(2, "Chantilly", "Acompanhamento", 15);
		Estoque produto3 = new Estoque(3, "Nutella", "Acompanhamento", 10);
		Estoque produto4 = new Estoque(4, "Banana", "Acompanhamento", 10);
		
		//Inserindo objetos de estoque no banco de dados através do método na DAO
		estoqueDAO.inserirProdutoNoEstoque(produto1);
		estoqueDAO.inserirProdutoNoEstoque(produto2);
		estoqueDAO.inserirProdutoNoEstoque(produto3);
		
		//Retornando no console se produtos foram cadastrados com sucesso
		if(estoqueDAO.inserirProdutoNoEstoque(produto4)) {
			System.out.print("produto cadastrados com sucesso!\n\n");
		}
		
		//Imprimindo a Table de Estoque no console
		ArrayList<Estoque> TabelaEstoque = estoqueDAO.listarProduto();
		for(int i = 0; i < TabelaEstoque.size(); i++) {
			System.out.print(TabelaEstoque.get(i));
		}
		
		//Retornando no console se o produto foi excluido da Tabela do banco de dados com sucesso
		if(estoqueDAO.excluirProduto(produto4)) {
			System.out.print("\n\nProduto excluido com sucesso!\n\n");
		}
		
		//Imprimindo a Tabela de Estoque no console
		ArrayList<Estoque> TabelaEstoque2 = estoqueDAO.listarProduto();
		
		for(int i = 0; i < TabelaEstoque2.size(); i++) {
			System.out.print(TabelaEstoque2.get(i));
		}
		
		

	}

}