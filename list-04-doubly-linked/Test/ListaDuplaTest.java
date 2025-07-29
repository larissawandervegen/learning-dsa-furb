/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Questa01;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author larim
 */
public class ListaDuplaTest {
    private ListaDupla<Integer> lista;
 
    @Before
    public void setUp() {
        lista = new ListaDupla<>();
    }
    
    @Test
    public void teste01_inclusaoDeTresNumeros() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoListaDupla<Integer> atual = lista.getPrimeiro();
        assertEquals(Integer.valueOf(20), atual.getInfo());
        atual = atual.getProximo();
        assertEquals(Integer.valueOf(15), atual.getInfo());
        atual = atual.getProximo();
        assertEquals(Integer.valueOf(10), atual.getInfo());
        atual = atual.getProximo();
        assertEquals(Integer.valueOf(5), atual.getInfo());
        assertNull(atual.getProximo());
    }
    
    @Test
    public void teste02_buscarInicio() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoListaDupla<Integer> no = lista.buscar(20);
        assertNotNull(no);
        assertEquals(Integer.valueOf(20), no.getInfo());
    }
    
    @Test
    public void teste03_buscarMeio() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoListaDupla<Integer> no = lista.buscar(10);
        assertNotNull(no);
        assertEquals(Integer.valueOf(10), no.getInfo());
    }
    
     @Test
    public void teste04_removerPrimeiro() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(20);
        assertEquals("15,10,5", lista.toString());
    }
 
    @Test
    public void teste05_removerMeio() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(10);
        assertEquals("20,15,5", lista.toString());
    }
    
    @Test
    public void teste05_removerFim() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(5);
        assertEquals("20,15,10", lista.toString());
    }
    
    @Test
    public void teste05_liberar() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.liberar();
        assertEquals("", lista.toString());
    }
 
}
