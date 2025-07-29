/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Questao01;

import Questao02.Aluno;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author larim
 */
public class MapaDispersaoTest {

    private MapaDispersao<Aluno> mapa;

    @Before
    public void setUp() {
        mapa = new MapaDispersao<>(53);
    }

    @Test
    public void testeInsercaoUnicaEBusca() {
        Aluno a1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        mapa.inserir(12000, a1);
        Aluno resultado = mapa.buscar(12000);
        assertNotNull(resultado);
        assertEquals(a1, resultado);
    }

    @Test
    public void testeInsercaoMultiplaEBusca() {
        Aluno a1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        Aluno a2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno a3 = new Aluno(12500, "Marta", LocalDate.of(2001, 2, 18));
        Aluno a4 = new Aluno(13000, "Lucas", LocalDate.of(1998, 11, 25));

        mapa.inserir(a1.getMatricula(), a1);
        mapa.inserir(a2.getMatricula(), a2);
        mapa.inserir(a3.getMatricula(), a3);
        mapa.inserir(a4.getMatricula(), a4);

        assertEquals(a1, mapa.buscar(a1.getMatricula()));
        assertEquals(a2, mapa.buscar(a2.getMatricula()));
        assertEquals(a3, mapa.buscar(a3.getMatricula()));
        assertEquals(a4, mapa.buscar(a4.getMatricula()));
    }

    @Test
    public void testeInsercaoComColisao() {
        
        Aluno a1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        Aluno a2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno a3 = new Aluno(14226, "Marta", LocalDate.of(2001, 2, 18));
        Aluno a4 = new Aluno(17180, "Lucas", LocalDate.of(1998, 11, 25));

        mapa.inserir(a1.getMatricula(), a1);
        mapa.inserir(a2.getMatricula(), a2);
        mapa.inserir(a3.getMatricula(), a3);
        mapa.inserir(a4.getMatricula(), a4);

        assertEquals(a1, mapa.buscar(a1.getMatricula()));
        assertEquals(a2, mapa.buscar(a2.getMatricula()));
        assertEquals(a3, mapa.buscar(a3.getMatricula()));
        assertEquals(a4, mapa.buscar(a4.getMatricula()));
    }
}

