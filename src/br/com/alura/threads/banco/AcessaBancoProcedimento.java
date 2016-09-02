package br.com.alura.threads.banco;

public class AcessaBancoProcedimento implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public AcessaBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	@Override
	public void run() {
		synchronized (tx) {
			System.out.println("peguei  a chave da tx");
			tx.begin();

			synchronized (pool) {
				System.out.println("peguei a chave do pool");
				pool.getConnection();
			}

		}

	}

}
