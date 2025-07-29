/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questao1;

/**
 *
 * @author larim
 */
public abstract class ArvoreBinariaAbstract<T extends Comparable<T>> {
	private NoArvoreBinaria<T> raiz;

	public ArvoreBinariaAbstract() {
		this.raiz = null;
	}

	protected void setRaiz(NoArvoreBinaria<T> raiz) {
		this.raiz = raiz;
	}

	public NoArvoreBinaria<T> getRaiz() {
		return raiz;
	}

	public boolean estaVazia() {
		return raiz == null;
	}

	public abstract NoArvoreBinaria<T> buscar(T dado);

	public boolean pertence(T dado) {
		return buscar(dado) != null;
	}

	@Override
	public String toString() {
		return toString(raiz);
	}

	private String toString(NoArvoreBinaria<T> no) {
		if (no == null) {
			return "<>";
		}
		return "<" + no.getInfo() + toString(no.getEsquerda()) + toString(no.getDireita()) + ">";
	}
}

