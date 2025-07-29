/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Questao1;

/**
 *
 * @author larim
 */

public class ArvoreBinaria<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

	public void setRaiz(NoArvoreBinaria<T> raiz) {
		super.setRaiz(raiz);
	}

	@Override
	public NoArvoreBinaria<T> buscar(T dado) {
		return buscar(getRaiz(), dado);
	}

	private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T dado) {
		if (no == null || no.getInfo().equals(dado)) {
			return no;
		}

		if (dado.compareTo(no.getInfo()) < 0) {
			return buscar(no.getEsquerda(), dado);
		} else {
			return buscar(no.getDireita(), dado);
		}
	}
}

