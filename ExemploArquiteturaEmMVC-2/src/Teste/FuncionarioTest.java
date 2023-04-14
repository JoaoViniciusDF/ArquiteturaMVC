package Teste;

import org.junit.Test;
import Model.Funcionario;

import static org.junit.Assert.*;

public class FuncionarioTest {

    @Test
    //Testando set de Nome
    public void testSetNome() {
        Funcionario f = new Funcionario( "João Silva", "99999999","123456789", "Montador");
        f.setNome("José Santos");
        assertEquals("José Santos", f.getNome());
    }

    @Test
    //Testando get de Telegone
    public void testGetTelefone() {
        Funcionario f = new Funcionario( "João Silva", "99999999", "123456789","Limpeza");
        assertEquals("99999999", f.getTelefone());
    }

    @Test
    //Testando set de Cargo
    public void testSetCargo() {
        Funcionario f = new Funcionario( "João Silva", "99999999", "123456789", "Atendente");
        f.setCargo("Atendente");
        assertEquals("Atendente", f.getCargo());
    }

    @Test
    //Testando salários
    public void testGetSalario() {
        Funcionario f1 = new Funcionario("João Silva", "99999999","123456789", "Montador");
        assertEquals(1449.50, f1.getSalario(), 0.001);
        
        Funcionario f2 = new Funcionario( "Maria Souza", "88888888","987654321", "Atendente");
        assertEquals(1499.00, f2.getSalario(), 0.001);
        
        Funcionario f3 = new Funcionario( "José Santos", "77777777", "456789123", "Limpeza");
        assertEquals(1320.20, f3.getSalario(), 0.001);
    }
}
