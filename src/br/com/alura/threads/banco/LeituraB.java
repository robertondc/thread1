package br.com.alura.threads.banco;

import java.io.File;

public class LeituraB implements Runnable {

	private File arquivo1;
	private File arquivo2;

	public LeituraB(File arquivo1, File arquivo2) {
		this.arquivo1 = arquivo1;
		this.arquivo2 = arquivo2;
	}

	@Override
	public void run() {

		System.out.println("Leitura B");

		System.out.println("esperando arquivo 2");
		synchronized (arquivo2) {
			System.out.println("acessando arquivo 2");

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("esperando arquivo 1");

			synchronized (arquivo1) {
				System.err.println("Acessando arquivo 1");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
