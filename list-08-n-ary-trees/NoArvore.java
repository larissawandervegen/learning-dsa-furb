/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questao1;

/**
 *
 * @author larim
 */
public class NoArvore<T> {
    private T info;
    private NoArvore<T> primeiro;
    private NoArvore<T> proximo;
    
    
    public NoArvore(T info) {
        this.info = info;
        this.primeiro = null;
        this.proximo = null;
    }
    
    public void inserirFilhos(NoArvore<T> sa){
        if(this.primeiro == null){
            this.primeiro = sa;
        } else {
            NoArvore<T> atual = this.primeiro;
            while (atual.proximo != null){
             atual = atual.proximo;   
            }
            atual.proximo = sa;
        }  
    }

    public NoArvore(T info, NoArvore<T> esquerda, NoArvore<T> direita) {
        this.info = info;
        this.primeiro = esquerda;
        this.proximo = direita;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvore<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoArvore<T> proximo) {
        this.proximo = proximo;
    }

    public NoArvore<T> getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoArvore<T> primeiro) {
        this.primeiro = primeiro;
    }
}
