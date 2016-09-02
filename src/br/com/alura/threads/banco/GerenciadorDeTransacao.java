package br.com.alura.threads.banco;

public class GerenciadorDeTransacao {
	
	public void begin() {
		System.out.println("comencando a transacao");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
