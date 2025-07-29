/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questao1;

/**
 *
 * @author larim
 */

class ListaEstatica<T> extends ListaAbstract<T> {

	@Override
	public void inserir(T dado) {
		if (tamanho == info.length) {
			redimensionar();
		}

		Object[] infoLocal = getInfo();
		infoLocal[tamanho] = dado;
		setTamanho(tamanho + 1);
	}

	@Override
	public int buscar(T dado) {
		Object[] infoLocal = getInfo();

		for (int i = 0; i < tamanho; i++) {
			if (infoLocal[i].equals(dado)) {
				return i;
			}
		}
		return -1;
	}
}
