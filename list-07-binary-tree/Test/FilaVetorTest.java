/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Questao01;

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
public class FilaVetorTest {

    @Test
    public void testeCaso1_estaVazia_true() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        assertTrue(fila.estaVazia());
    }

    @Test
    public void testeCaso2_estaVazia_false() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        assertFalse(fila.estaVazia());
    }

    @Test
    public void testeCaso3_enfileirarDesenfileirar() {
        FilaVetor<Integer> fila = new FilaVetor<>(10);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals((Integer)10, fila.retirar());
        assertEquals((Integer)20, fila.retirar());
        assertEquals((Integer)30, fila.retirar());
        assertTrue(fila.estaVazia());
    }

    @Test(expected = FilaCheiaException.class)
    public void testeCaso4_filaCheiaException() {
        FilaVetor<Integer> fila = new FilaVetor<>(3);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.inserir(40); // Deve lançar exceção
    }

    @Test(expected = FilaVaziaException.class)
    public void testeCaso5_filaVaziaException() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.retirar(); // Deve lançar exceção
    }

    @Test
    public void testeCaso6_peekRetornaInicio() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals((Integer)10, fila.peek());
        assertEquals((Integer)10, fila.retirar());
        assertEquals((Integer)20, fila.peek());
    }

    @Test
    public void testeCaso7_liberarFila() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.liberar();
        assertTrue(fila.estaVazia());
    }

    @Test
    public void testeCaso8_concatenacao() {
        FilaVetor<Integer> f1 = new FilaVetor<>(5);
        f1.inserir(10);
        f1.inserir(20);
        f1.inserir(30);

        FilaVetor<Integer> f2 = new FilaVetor<>(3);
        f2.inserir(40);
        f2.inserir(50);

        FilaVetor<Integer> f3 = f1.criarFilaConcatenada(f2);
        assertEquals("10, 20, 30, 40, 50", f3.toString());

        assertEquals("10, 20, 30", f1.toString());
        assertEquals("40, 50", f2.toString());

        assertEquals(5, f3.getLimite());
    }
}