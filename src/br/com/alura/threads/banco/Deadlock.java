package br.com.alura.threads.banco;

import java.io.File;

public class Deadlock {
	public static File arquivo1 = new File("arquivo1.txt");
	public static File arquivo2 = new File("arquivo2.txt");

	public static void main(String[] args) {
		
		new Thread(new LeituraA(arquivo1, arquivo2)).start();
		new Thread(new LeituraB(arquivo1, arquivo2)).start();

		
		
	}
}
