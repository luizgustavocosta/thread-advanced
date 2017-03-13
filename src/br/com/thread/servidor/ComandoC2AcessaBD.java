package br.com.thread.servidor;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

// Objetivo e executar algo que demora
// 2 tarefas. Acessar WS e BD
public class ComandoC2AcessaBD implements Callable<String> {

	private PrintStream saida;

	public ComandoC2AcessaBD(PrintStream saida) {
		super();
		this.saida = saida;
	}

	@Override
	public String call() throws Exception {
		System.out.println("executando o comando 2");
		System.out.println("Processando comando c2");
		Thread.sleep(10000); // simulando processamento
		
		int numero = new Random().nextInt(100) + 1;
		
		// Cliente vai receber a informacao
		saida.println("servidor finalizou a execucacao do comando c2 - WS");
		return Integer.toString(numero);
	}

}
