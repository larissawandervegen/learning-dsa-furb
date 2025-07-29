import Questao01.ListaGenerica;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ListaGenericaTest {

    private ListaGenerica<Integer> lista;

    @Before
    public void setUp() {
        lista = new ListaGenerica<>();
    }

    @Test
    public void testInserir() {
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);

        assertEquals("[10, 20, 30]", lista.toString());
    }

    @Test
    public void testBuscar() {
        lista.inserir(10);
        lista.inserir(20);

        assertEquals(1, lista.buscar(20));
        assertEquals(-1, lista.buscar(30));
    }

    @Test
    public void testRetirar() {
        lista.inserir(10);
        lista.inserir(20);
        lista.retirar(10);
        
        assertEquals("[20]", lista.toString());
    }

    @Test
    public void testInverter() {
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inverter();
        
        assertEquals("[30, 20, 10]", lista.toString());
    }

    @Test
    public void testObterElemento() {
        lista.inserir(10);
        lista.inserir(20);
        
        assertEquals((Integer) 20, lista.obterElemento(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testObterElementoComIndiceInvalido() {
        lista.obterElemento(2);  // Índice inválido
    }

    @Test
    public void testEstaVazia() {
        assertTrue(lista.estaVazia());
        
        lista.inserir(10);
        assertFalse(lista.estaVazia());
    }
}
