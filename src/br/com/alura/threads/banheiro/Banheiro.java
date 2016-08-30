package br.com.alura.threads.banheiro;

public class Banheiro {

	boolean ehSujo = true;

	public void fazNumero1() {

		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");

		synchronized (this) {

			System.out.println(nome + " entrando no banheiro");

			while (this.ehSujo) {
				esperaLaFora(nome);
			}

			System.out.println(nome + " faz coisa rapida");

			try {
				Thread.sleep(8000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			this.ehSujo = true;
			
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando a mao");
			System.out.println(nome + " saindo do banheiro");
		}

	}

	private void esperaLaFora(String nome) {
		System.out.println(nome + ", eca, o banheiro está sujo");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void fazNumero2() {

		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");

		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");

			while (ehSujo) {
				esperaLaFora(nome);
			}

			System.out.println(nome + " faz coisa demorada");

			try {
				Thread.sleep(15000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			this.ehSujo = true;
			
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando a mao");
			System.out.println(nome + " saindo do banheiro");
		}

	}

	public void limpa() {
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");

		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");

			if (!ehSujo) {
				System.out.println(nome + " , não está sujo e vou sair");
				return;
			}
			
			System.out.println(nome + " limpando o banheiro");
		
			this.ehSujo = false;
			
			try {
				Thread.sleep(13000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.notifyAll();

			System.out.println(nome + " saindo do banheiro");
		}
	}

}
