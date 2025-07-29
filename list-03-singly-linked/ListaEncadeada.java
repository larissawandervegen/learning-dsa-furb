/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questao01;

/**
 *
 * @author larim
 * @param <T>
 */
public class ListaEncadeada<T> {

    private NoLista<T> primeiro;

    public ListaEncadeada() {
        this.primeiro = null;
    }

    public NoLista getPrimeiro() {
        return primeiro;
    }

    public void inserir(T info) {
        NoLista novo = new NoLista();
        novo.setInfo(info);
        novo.setProximo(this.primeiro);
        this.primeiro = novo;
    }

    public boolean estaVazia() {
        if (this.primeiro == null) {
            return true;
        }
        return false;
    }

    public NoLista<T> buscar(T valor) {
        NoLista<T> p = this.primeiro;
        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retirar(T valor) {
        NoLista<T> anterior = null;
        NoLista<T> p = this.primeiro;

        while (p != null && !p.getInfo().equals(valor)) {
            anterior = p;
            p = p.getProximo();
        }

        if (p != null) {
            if (p == this.primeiro) {
                this.primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
        }
    }

    public int obterComprimento() {
        int contador = 0;
        NoLista<T> atual = this.primeiro;
        while (atual != null) {
            atual = atual.getProximo();
            contador++;
        }
        return contador;
    }

    public NoLista<T> obterNo(int posicao) {
        if (posicao < 0) {
            throw new IndexOutOfBoundsException("Posição negativa: " + posicao);
        }

        NoLista<T> atual = this.primeiro;
        int contador = 0;

        while (atual != null) {
            if (contador == posicao) {
                return atual;
            }
            atual = atual.getProximo();
            contador++;
        }

        throw new IndexOutOfBoundsException("Posição fora da lista: " + posicao);
    }

      @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoLista<T> atual = primeiro;
 
        while (atual != null) {
            sb.append(atual.getInfo());
            if (atual.getProximo() != null) {
                sb.append(",");
            }
            atual = atual.getProximo();
        }
 
        return sb.toString();
    }

}
