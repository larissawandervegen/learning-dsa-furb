/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questa01;

/**
 *
 * @author larim
 * @param <T>
 */
public class ListaDupla<T> {

    private NoListaDupla<T> primeiro;

    public ListaDupla() {
        this.primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoListaDupla novo = new NoListaDupla();
        novo.setInfo(valor);
        novo.setProximo(this.primeiro);
        novo.setAnterior(null);
        if (this.primeiro != null) {
            primeiro.setAnterior(novo);
        }
        this.primeiro = novo;
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> p = this.primeiro;
        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retirar(T valor) {
        NoListaDupla<T> p = buscar(valor);

        if (p != null) {
            if (this.primeiro.equals(p)) {
                this.primeiro = p.getProximo();
            } else {
                p.getAnterior().setProximo(p.getProximo());
            }
            if (p.getProximo() != null) {
                p.getProximo().setAnterior(p.getAnterior());
            }
        }

    }

    public void exibirOrdemInversa() {
        if (getPrimeiro() == null) {
            System.out.println("(lista vazia)");
            return;
        }

        NoListaDupla atual = getPrimeiro();
        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }

        while (atual != null) {
            System.out.print(atual.getInfo() + " ");
            atual = atual.getAnterior();
        }
        System.out.println();
    }

    public void liberar() {
        NoListaDupla atual = getPrimeiro();
        while (atual != null) {
            NoListaDupla proximo = atual.getProximo();

            atual.setAnterior(null);
            atual.setProximo(null);

            atual = proximo;
        }

        primeiro = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoListaDupla<T> atual = primeiro;

        while (atual != null) {
            sb.append(atual.getInfo());
            if (atual.getProximo() != null) {
                sb.append(",");
            }
            atual = atual.getProximo();
        }

        return sb.toString();
    }
    
    public ListaDupla<T> clonar(){
        ListaDupla<T> listaClone = new ListaDupla<>();
        NoListaDupla<T> atual = getPrimeiro();
        
        while (atual != null) {      
            NoListaDupla<T> novoNo = new NoListaDupla<T>();
            novoNo.setInfo(atual.getInfo());
            listaClone.inserir(novoNo.getInfo());
            atual = atual.getProximo();
        }
        
        return listaClone;
    }
    

}
