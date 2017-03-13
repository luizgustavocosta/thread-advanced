package br.com.thread.servidor;

import java.io.PrintStream;

// Objetivo e executar algo que demora
public class ComandoC3 implements Runnable {

	private PrintStream saida;

	public ComandoC3(PrintStream saida) {
		super();
		this.saida = saida;
	}

	@Override
	public void run() {
		System.out.println("executando o comando 3");
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		// Cliente vai receber a informacao
		saida.println("comando 3 executado com sucesso");
	}

}
