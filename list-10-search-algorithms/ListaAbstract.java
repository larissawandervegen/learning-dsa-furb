/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Questao1;

/**
 *
 * @author larim
 */

abstract class ListaAbstract<T> {
	
	protected Object[] info;
	protected int tamanho;
	
	private static final int TAMANHO_INICIAL = 10;

	public ListaAbstract() {
		this.info = new Object[TAMANHO_INICIAL];
		this.tamanho = 0;
	}

	protected Object[] getInfo() {
		return this.info;
	}

	protected void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	protected void redimensionar() {
		Object[] novoVetor = new Object[info.length * 2];
		for (int i = 0; i < tamanho; i++) {
			novoVetor[i] = info[i];
		}
		this.info = novoVetor;
	}

	public abstract void inserir(T dado);

	public abstract int buscar(T dado);

	public int getTamanho() {
		return tamanho;
	}

	public boolean estaVazia() {
		return tamanho == 0;
	}

	@SuppressWarnings("unchecked")
	public T obterElemento(int indice) {
		if (indice < 0 || indice >= tamanho) {
			throw new IndexOutOfBoundsException("Índice inválido: " + indice);
		}
		return (T) info[indice];
	}

	@Override
	public String toString() {
		if (tamanho == 0)
			return "";

		StringBuilder sb = new StringBuilder();
		sb.append(info[0]);
		for (int i = 1; i < tamanho; i++) {
			sb.append(",").append(info[i]);
		}
		return sb.toString();
	}
}
