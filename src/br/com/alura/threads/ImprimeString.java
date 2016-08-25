package br.com.alura.threads;

public class ImprimeString implements Runnable{
	public void run() {
			System.out.println("Começou");
			try {
				Thread.sleep(10000);
				Thread.sleep(10000);
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Terminou");
	}
}