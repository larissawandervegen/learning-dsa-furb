package Questao01;

import Questao01.ListaEncadeada;
import Questao01.NoLista;
import org.junit.Before;
import org.junit.Test;
 
import static org.junit.Assert.*;
 
public class ListaEncadeadaTest {
 
    private ListaEncadeada<Integer> lista;
 
    @Before
    public void setUp() {
        lista = new ListaEncadeada<>();
    }
 
    @Test
    public void teste01_listaVazia() {
        assertTrue(lista.estaVazia());
    }
 
    @Test
    public void teste02_listaNaoVazia() {
        lista.inserir(5);
        assertFalse(lista.estaVazia());
    }
 
    @Test
    public void teste03_inclusaoDeUmNumero() {
        lista.inserir(5);
        NoLista<Integer> no = lista.getPrimeiro();
        assertNotNull(no);
        assertEquals(Integer.valueOf(5), no.getInfo());
        assertNull(no.getProximo());
    }
 
    @Test
    public void teste04_inclusaoDeTresNumeros() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        NoLista<Integer> atual = lista.getPrimeiro();
        assertEquals(Integer.valueOf(15), atual.getInfo());
        atual = atual.getProximo();
        assertEquals(Integer.valueOf(10), atual.getInfo());
        atual = atual.getProximo();
        assertEquals(Integer.valueOf(5), atual.getInfo());
        assertNull(atual.getProximo());
    }
 
    @Test
    public void teste05_buscarPrimeiraPosicao() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoLista<Integer> no = lista.buscar(20);
        assertNotNull(no);
        assertEquals(Integer.valueOf(20), no.getInfo());
    }
 
    @Test
    public void teste06_buscarMeio() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoLista<Integer> no = lista.buscar(15);
        assertNotNull(no);
        assertEquals(Integer.valueOf(15), no.getInfo());
    }
 
    @Test
    public void teste07_buscarInexistente() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertNull(lista.buscar(50));
    }
 
    @Test
    public void teste08_removerPrimeiro() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(20);
        assertEquals("15,10,5", lista.toString());
    }
 
    @Test
    public void teste09_removerMeio() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(15);
        assertEquals("20,10,5", lista.toString());
    }
 
    @Test
    public void teste10_obterNoPosicaoZero() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(Integer.valueOf(20), lista.obterNo(0).getInfo());
    }
 
    @Test
    public void teste11_obterNoUltimaPosicao() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(Integer.valueOf(5), lista.obterNo(3).getInfo());
    }
 
    @Test(expected = IndexOutOfBoundsException.class)
    public void teste12_obterNoPosicaoInvalida() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.obterNo(10);
    }
 
    @Test
    public void teste13_comprimentoListaVazia() {
        assertEquals(0, lista.obterComprimento());
    }
 
    @Test
    public void teste14_comprimentoListaNaoVazia() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        assertEquals(4, lista.obterComprimento());
    }
}