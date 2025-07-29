/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Questao01;

import Questao01.Pilha;
import Questao01.PilhaCheiaException;
import Questao01.PilhaVaziaException;

/**
 *
 * @author larim
 * @param <T>
 */
public class PilhaVetor<T> implements Pilha<T> {
    private T[] info;
    private int limite;
    private int topo;

    public PilhaVetor(int limite) {
        this.limite = limite;
        this.info = (T[]) new Object[limite];
        this.topo = -1;
    }

    @Override
    public void push(T valor) {
        if (topo == limite - 1) {
            throw new PilhaCheiaException();
        }
        topo++;
        info[topo] = valor;
    }

    @Override
    public T pop() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        T valor = info[topo];
        topo--;
        return valor;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        return info[topo];
    }

    @Override
    public boolean estaVazia() {
        return topo == -1;
    }

    @Override
    public void liberar() {
        topo = -1;
    }

    @Override
    public String toString() {
        if (estaVazia()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = topo; i >= 0; i--) {
            sb.append(info[i]);
            if (i > 0) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public void concatenar(PilhaVetor<T> outra) {
        int totalElementos = this.topo + 1 + outra.topo + 1;
        if (totalElementos > limite) {
            throw new PilhaCheiaException();
        }

        // Pilha auxiliar para inverter ordem
        PilhaVetor<T> auxiliar = new PilhaVetor<>(outra.limite);
        for (int i = 0; i <= outra.topo; i++) {
            auxiliar.push(outra.info[i]);
        }

        // Agora empilhar os valores da auxiliar na pilha atual
        while (!auxiliar.estaVazia()) {
            this.push(auxiliar.pop());
        }
    }
}