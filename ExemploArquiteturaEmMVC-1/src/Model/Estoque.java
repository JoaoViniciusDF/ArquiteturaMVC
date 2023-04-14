package Model;

public class Estoque {
	
	// Atributos
	private String nomeProduto, tipoDeProduto;
	private int quantidadeEmEstoque;
	public int codigo;
    private int numeroProduto;
	
	// Construtor
	public Estoque(int codigo, String nomeProduto, String tipoDeProduto, int quantidadeEmEstoque) {

		
        this.codigo = codigo;
		this.nomeProduto = nomeProduto;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
		this.tipoDeProduto = tipoDeProduto;

	}

	// Getters and Setter
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	public String getTipoDeProduto() {
		return tipoDeProduto;
	}

	public void setTipoDeProduto(String tipoDeProduto) {
		this.tipoDeProduto = tipoDeProduto;
	}
	
	public int getNumeroProduto() {
		return numeroProduto;
	}

	public void setNumeroProduto(int numeroProduto) {
		this.numeroProduto = numeroProduto;
	}

	// Tradução para string
    @Override
	public String toString() {
    	
		return codigo + " - " + nomeProduto + " - " + tipoDeProduto + " - " + quantidadeEmEstoque + "\n";
		
	}
	
}