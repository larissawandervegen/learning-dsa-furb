/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questao01;

import java.util.Arrays;

/**
 *
 * @author larim
 */
public class ListaEstatica {

    private int[] info;
    private int tamanho;

    public ListaEstatica() {
        this.info = new int[10];
        this.tamanho = 0;
    }

    private void redimensionar() {
        int[] novo = new int[info.length + 10];
        
        for (int i = 0; i < tamanho; i++) {
            novo[i] = info[i];
        }
        
        info = novo;
    }

    public void inserir(int num) {
        if (tamanho == info.length) {
            redimensionar();
        }
        info[tamanho] = num;
        tamanho++;
        
        //ou
//        if (tamanho == info.length) {
//             throw new IndexOutOfBoundsException("Array cheio!");
//        }
//        info[tamanho] = num;
//        tamanho++;
    }

    public void exibir() {
        for (int i = 0; i < info.length; i++){
            System.out.println(i);
        }    
    }
    
    public int buscar(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(int valor) {
        int index = buscar(valor);
        for (int i = 0; i < tamanho; i++) {
            if (info[i] == valor) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IndexOutOfBoundsException("Valor não encontrado!");
        }
        for (int i = index; i < this.tamanho - 1; i++) {
            info[i] = info[i + 1];
        }
        tamanho--;
    }

    public void liberar() {
        info = new int[10];
        tamanho = 0;
    }

    public int obterElemento(int posicao) {
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido!");
        }
        return info[posicao];
    }

    public boolean estaVazia() {
        if(tamanho == 0){
            return true;
        }
        return false;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        if (tamanho == 0) {
            return "[]";
        }

        StringBuilder resultado = new StringBuilder("[");

        for (int i = 0; i < tamanho; i++) {
            resultado.append(info[i]);
            if (i < tamanho - 1) {
                resultado.append(", "); 
            }
        }

        resultado.append("]");
        return resultado.toString();
    }

}
