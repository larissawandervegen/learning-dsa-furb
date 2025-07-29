/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questao03;

/**
 *
 * @author larim
 */
public class FilaLista<T> implements Fila<T> {
    private ListaEncadeada<T> lista;

    public FilaLista() {
        lista = new ListaEncadeada<>();
    }

    @Override
    public void inserir(T valor) {
        lista.inserirNoFinal(valor);
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public T peek() {
        return lista.peek();
    }

    @Override
    public T retirar() {
        return lista.retirar();
    }

    @Override
    public void liberar() {
        lista.liberar();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}
