/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questao1;

/**
 *
 * @author larim
 */

class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T> {

	@Override
	public void inserir(T dado) {
		if (tamanho == info.length) {
			redimensionar();
		}

		Object[] infoLocal = getInfo();

		int posicao = 0;
		while (posicao < tamanho && dado.compareTo((T) infoLocal[posicao]) > 0) {
			posicao++;
		}

		for (int i = tamanho; i > posicao; i--) {
			infoLocal[i] = infoLocal[i - 1];
		}

		infoLocal[posicao] = dado;
		setTamanho(tamanho + 1);
	}

	@Override
	public int buscar(T dado) {
		Object[] infoLocal = getInfo();

		int inicio = 0;
		int fim = tamanho - 1;

		while (inicio <= fim) {
			int meio = (inicio + fim) / 2;
			int comparacao = dado.compareTo((T) infoLocal[meio]);

			if (comparacao == 0) {
				return meio;
			} else if (comparacao < 0) {
				fim = meio - 1;
			} else {
				inicio = meio + 1;
			}
		}

		return -1;
	}
}
