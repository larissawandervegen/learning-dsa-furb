/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Questao03;

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
public class FilaListaTest {
    private FilaLista<Integer> fila;

    @Before
    public void setUp() {
        fila = new FilaLista<>();
    }

    @Test
    public void testCaso1_EstaVaziaReconheceFilaVazia() {
        assertTrue(fila.estaVazia());
    }

    @Test
    public void testCaso2_EstaVaziaReconheceFilaNaoVazia() {
        fila.inserir(10);
        assertFalse(fila.estaVazia());
    }

    @Test
    public void testCaso3_DesenfileirarRetornaDadoCorreto() {
        fila.inserir(10);
        Integer retirado = fila.retirar();
        assertEquals(Integer.valueOf(10), retirado);
    }

    @Test
    public void testCaso3_EnfileirarEDesenfileirarCorretamente() {
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(Integer.valueOf(10), fila.retirar());
        assertEquals(Integer.valueOf(20), fila.retirar());
        assertEquals(Integer.valueOf(30), fila.retirar());
        assertTrue(fila.estaVazia());
    }

    @Test
    public void testCaso4_PeekRetornaInicioDaFila() {
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(Integer.valueOf(10), fila.peek());
        assertEquals(Integer.valueOf(10), fila.retirar());
    }

    @Test
    public void testCaso5_LiberarRemoveTodosElementos() {
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        fila.liberar();
        assertTrue(fila.estaVazia());
    }
}

