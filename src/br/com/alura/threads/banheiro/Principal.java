package br.com.alura.threads.banheiro;

public class Principal {
	public static void main(String[] args) {
		Banheiro banheiro = new Banheiro();
		
		Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "Joao");
		Thread convidado2 =  new Thread(new TarefaNumero2(banheiro), "Pedro");
		//Thread convidado3 =  new Thread(new TarefaNumero2(banheiro), "Maria");
		//Thread convidado4 =  new Thread(new TarefaNumero2(banheiro), "Ana");
		Thread limpeza =  new Thread(new TarefaLimpeza(banheiro), "Limpeza");
		limpeza.setDaemon(true); //isso indica que quando as outras threads do processo, tiverem terminado essa pode morrer
		
		convidado1.start();
		convidado2.start();
		limpeza.start();
		//convidado3.start();
		//convidado4.start();
	}
}
