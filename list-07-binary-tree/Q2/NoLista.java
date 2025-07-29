/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questao03;

/**
 *
 * @author larim
 */
public class NoLista<T> {
    T valor;
    NoLista<T> proximo;

    public NoLista(T valor) {
        this.valor = valor;
        this.proximo = null;
    }
}
