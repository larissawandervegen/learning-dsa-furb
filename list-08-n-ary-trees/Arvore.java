 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Questao1;

/**
 *
 * @author larim
 */
public class Arvore<T> {

    private NoArvore<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public boolean pertence(T info) {
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvore<T> no, T info) {
        if (no == null) {
            return false;
        }
       if(no.getInfo().equals(info)){
       return true;
       }
       NoArvore<T> filho = no.getPrimeiro();
       while(filho!=null){
           if(pertence(filho, info)){
               return true;
       }
           filho = filho.getProximo();
    }
        return false;
    }
    @Override
    public String toString() {
       if(raiz == null){
           return "";
       }
       return obterRepresentacaoTextual(raiz);
    }
    
    private String obterRepresentacaoTextual(NoArvore<T> no){
        StringBuilder sb = new StringBuilder(0);
        sb.append("<").append(no.getPrimeiro());
        
        NoArvore<T> filho = no.getPrimeiro();
        while(filho != null){
         sb.append(obterRepresentacaoTextual(filho));
         filho = filho.getProximo();
        }
        sb.append(">");
        return sb.toString();
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvore<T> no) {
        if (no == null) {
            return 0;
        }

        return 1 + contarNos(no.getProximo()) + contarNos(no.getPrimeiro());
    }

}
