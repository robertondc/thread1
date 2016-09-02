package br.com.alura.threads.banco;

public class PoolDeConexao {

	public String getConnection() {

		System.out.println("Emprestando a conexao");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "connection";

	}

}