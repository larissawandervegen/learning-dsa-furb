/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questao01;

/**
 *
 * @author larim
 */
public class FilaVetor<T> implements Fila<T> {
    private Object[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        this.limite = limite;
        this.info = new Object[limite];
        this.tamanho = 0;
        this.inicio = 0;
    }

    @Override
    public void inserir(T valor) {
        if (tamanho == limite) {
            throw new FilaCheiaException();
        }
        int pos = (inicio + tamanho) % limite;
        info[pos] = valor;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }
        return (T) info[inicio];
    }

    @Override
    public T retirar() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }
        T valor = (T) info[inicio];
        inicio = (inicio + 1) % limite;
        tamanho--;
        return valor;
    }

    @Override
    public void liberar() {
        tamanho = 0;
        inicio = 0;
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> novaFila = new FilaVetor<>(this.tamanho + f2.tamanho);
        
        for (int i = 0; i < this.tamanho; i++) {
            int index = (this.inicio + i) % this.limite;
            novaFila.inserir((T) this.info[index]);
        }
        for (int i = 0; i < f2.tamanho; i++) {
            int index = (f2.inicio + i) % f2.limite;
            novaFila.inserir((T) f2.info[index]);
        }
        return novaFila;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            int index = (inicio + i) % limite;
            sb.append(info[index]);
            if (i < tamanho - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public int getLimite() {
        return limite;
    }
}
