package Model;

public class Funcionario {

    // Atributos
    private String nome, cpf, telefone;
    private String cargo;
    private double salario;

    // Construtor
    public Funcionario(String nome, String telefone, String cpf, String cargo) {
    	
    	this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cargo = cargo;

    }
    
    public Funcionario(String cpf) {
    	
        this.cpf = cpf;

    }

    // Getters and Setters
    public void setNome(String nome) {

        this.nome = nome;

    }

    public String getNome() {

        return nome;

    }

    public String getCPF() {

        return cpf;

    }

    public void setTelefone(String telefone) {

        this.telefone = telefone;

    }

    public String getTelefone() {

        return telefone;

    }

    public void setCargo(String cargo) {

        this.cargo = cargo;

    }

    public String getCargo() {

        return this.cargo;

    }

    // Consultar salário de funcionário
    public double getSalario() {

        if (this.cargo == "Montador") {

            return 1449.50;

        } else if (this.cargo == "Atendente") {

            return 1499.00;

        } else if (this.cargo == "Limpeza") {

            return 1320.20;

        }
        
        return (Double) null;

    }
    
    // Tradução para string
    @Override
	public String toString() {
		
		return cpf + " - " + nome + " - " + telefone + " - " + cargo + "\n";
		
	}

}