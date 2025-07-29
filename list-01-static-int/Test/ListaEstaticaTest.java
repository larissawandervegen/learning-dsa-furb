package Questao1;

import Questao01.ListaEstatica;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ListaEstaticaTest {

    private ListaEstatica lista;

    @Before
    public void setUp() {
        lista = new ListaEstatica();
    }

    @Test
    public void testarInserir() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals("[5, 10, 15, 20]", lista.toString());
    }

    @Test
    public void testBuscarElementoExistente() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals(2, lista.buscar(15));
    }

    @Test
    public void testBuscarElementoInexistente() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals(-1, lista.buscar(30));
    }

    @Test
    public void testarRetirar() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);
        
        assertEquals("[5, 15, 20]", lista.toString());
        assertEquals(3, lista.getTamanho());
    }

    @Test
    public void testarInclusaoComRedimensionamento() {
        for (int i = 1; i <= 15; i++) {
            lista.inserir(i);
        }
        
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]", lista.toString());
        assertEquals(15, lista.getTamanho());
    }

    @Test
    public void testarObterElemento() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(20, lista.obterElemento(3));
    }

    @Test
    public void testarExcecaoObterElemento() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        try {
            lista.obterElemento(5);
            fail("Deveria ter lançado IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Índice inválido!", e.getMessage());
        }
    }

    @Test
    public void testarLiberar() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.liberar();

        assertTrue(lista.estaVazia());
    }
}
