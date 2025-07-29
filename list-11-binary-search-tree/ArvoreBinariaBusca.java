/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questao1;
import Questao1.NoArvoreBinaria;
/**
 *
 * @author larim
 */

public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinaria<T> {

	public void inserir(T dado) {
		setRaiz(inserir(getRaiz(), dado));
	}

	private NoArvoreBinaria<T> inserir(NoArvoreBinaria<T> no, T dado) {
		if (no == null) {
			return new NoArvoreBinaria<>(dado);
		}

		if (dado.compareTo(no.getInfo()) < 0) {
			no.setEsquerda(inserir(no.getEsquerda(), dado));
		} else if (dado.compareTo(no.getInfo()) > 0) {
			no.setDireita(inserir(no.getDireita(), dado));
		}

		return no;
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

	public void retirar(T dado) {
		setRaiz(retirar(getRaiz(), dado));
	}

	private NoArvoreBinaria<T> retirar(NoArvoreBinaria<T> no, T dado) {
		if (no == null) {
			return null;
		}

		if (dado.compareTo(no.getInfo()) < 0) {
			no.setEsquerda(retirar(no.getEsquerda(), dado));
		} else if (dado.compareTo(no.getInfo()) > 0) {
			no.setDireita(retirar(no.getDireita(), dado));
		} else {

			if (no.getEsquerda() == null && no.getDireita() == null) {
				return null;
			}

			if (no.getEsquerda() == null) {
				return no.getDireita();
			}
			if (no.getDireita() == null) {
				return no.getEsquerda();
			}

			NoArvoreBinaria<T> sucessor = encontrarMinimo(no.getDireita());

			no.setInfo(sucessor.getInfo());

			no.setDireita(retirar(no.getDireita(), sucessor.getInfo()));
		}

		return no;
	}

	private NoArvoreBinaria<T> encontrarMinimo(NoArvoreBinaria<T> no) {
		while (no.getEsquerda() != null) {
			no = no.getEsquerda();
		}
		return no;
	}
}