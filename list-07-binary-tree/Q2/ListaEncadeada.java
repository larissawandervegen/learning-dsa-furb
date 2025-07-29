/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questao03;

/**
 *
 * @author larim
 */
public class ListaEncadeada<T> {
    private NoLista<T> primeiro;
    private NoLista<T> ultimo;

    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public void inserirNoFinal(T valor) {
        NoLista<T> novoNo = new NoLista<>(valor);
        if (estaVazia()) {
            primeiro = ultimo = novoNo;
        } else {
            ultimo.proximo = novoNo;
            ultimo = novoNo;
        }
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }
        return primeiro.valor;
    }

    public T retirar() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }
        T valor = primeiro.valor;
        primeiro = primeiro.proximo;
        if (primeiro == null) {
            ultimo = null;
        }
        return valor;
    }

    public void liberar() {
        primeiro = ultimo = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoLista<T> atual = primeiro;
        while (atual != null) {
            sb.append(atual.valor);
            if (atual.proximo != null) {
                sb.append(", ");
            }
            atual = atual.proximo;
        }
        return sb.toString();
    }
}
