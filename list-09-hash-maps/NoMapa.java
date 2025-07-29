/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Questao01;

/**
 *
 * @author larim
 */
public class NoMapa<T> {
    private int chave;
    private T info;

    public NoMapa(int chave, T info) {
        this.chave = chave;
        this.info = info;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NoMapa) {
            NoMapa<?> outro = (NoMapa<?>) obj;
            return this.chave == outro.chave;
        }
        return false;
    }
}
