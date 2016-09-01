package br.com.alura.threads.lista;

public class Lista {

	private String[] elementos = new String[1000];
	private int indice = 0;

	public synchronized void adicionarElementos(String elemento) {

		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		this.elementos[indice] = elemento;
		this.indice++;

		if (this.indice == this.elementos.length) {
			System.out.println("Lista esta cheia - notificando");
			this.notify();
		}
	}

	public int tamanho() {
		return this.elementos.length;
	}

	public String pegaElemento(int posicao) {
		return this.elementos[posicao];
	}

	public boolean estaCheia() {
		return this.indice == tamanho();
	}

}
