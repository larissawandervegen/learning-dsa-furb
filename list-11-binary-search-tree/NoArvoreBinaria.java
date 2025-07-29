/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questao1;

/**
 *
 * @author larim
 */
public class NoArvoreBinaria<T> {
    private T info;
    private NoArvoreBinaria<T> primeiro;
    private NoArvoreBinaria<T> proximo;
    
    
    public NoArvoreBinaria(T info) {
        this.info = info;
        this.primeiro = null;
        this.proximo = null;
    }
    
    public void inserirFilhos(NoArvoreBinaria<T> sa){
        if(this.primeiro == null){
            this.primeiro = sa;
        } else {
            NoArvoreBinaria<T> atual = this.primeiro;
            while (atual.proximo != null){
             atual = atual.proximo;   
            }
            atual.proximo = sa;
        }  
    }

    public NoArvoreBinaria(T info, NoArvoreBinaria<T> esquerda, NoArvoreBinaria<T> direita) {
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

    public NoArvoreBinaria<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoArvoreBinaria<T> proximo) {
        this.proximo = proximo;
    }

    public NoArvoreBinaria<T> getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoArvoreBinaria<T> primeiro) {
        this.primeiro = primeiro;
    }
}
