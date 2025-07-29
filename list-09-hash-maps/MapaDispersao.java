/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Questao01;

import java.util.LinkedList;

/**
 *
 * @author larim
 */
public class MapaDispersao<T> {

    private LinkedList<NoMapa<T>>[] info;

    public MapaDispersao(int tamanho) {
        this.info = new LinkedList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            info[i] = new LinkedList<>();
        }
    }

    private int calcularHash(int chave) {
        return chave % info.length;
    }

    public void inserir(int chave, T valor) {
        int indice = calcularHash(chave);
        NoMapa<T> novo = new NoMapa<>(chave, valor);
        LinkedList<NoMapa<T>> lista = info[indice];
        for (NoMapa<T> no : lista) {
            if (no.equals(novo)) {
                lista.remove(no);
                break;
            }
        }
        lista.add(novo);
    }

    public void remover(int chave) {
        int pos = calcularHash(chave);
        LinkedList<NoMapa<T>> lista = info[pos];
        lista.removeIf(no -> no.getChave() == chave);
    }

    public T buscar(int chave) {
        int indice = calcularHash(chave);
        for (NoMapa<T> no : info[indice]) {
            if (no.getChave() == chave) return no.getInfo();
        }
        return null;
    }
}
