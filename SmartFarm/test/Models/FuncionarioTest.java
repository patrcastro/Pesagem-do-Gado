/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miiil
 */
public class FuncionarioTest {
    
    public FuncionarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ValidarEmail method, of class Funcionario.
     */
    @Test
    public void testValidarEmail() {
        System.out.println("ValidarEmail");
        String email = "email@hotmail.com"; // alterar a variável email para testar a execução do método ValidaEmail();
        boolean expResult = true;
        boolean result = Funcionario.ValidarEmail(email);
        assertEquals(expResult, result);
    }
    
}
