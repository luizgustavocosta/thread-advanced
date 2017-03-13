package br.com.thread.servidor;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JuntaResultadosWSBD implements Callable<Void> {


	private PrintStream saida;
	private Future<String> futureBD;
	private Future<String> futureWS;

	public JuntaResultadosWSBD(Future<String> futureWS, Future<String> futureBD, PrintStream saida) {
		this.futureWS = futureWS;
		this.futureBD = futureBD;
		this.saida = saida;
	}

	@Override
	public Void call() {
		System.out.println("Aguardando resultados dos future WS e BD");
		try {
			String numeroMagico = this.futureWS.get(15, TimeUnit.SECONDS);
			String numeroMagico2 = this.futureBD.get(15, TimeUnit.SECONDS);
			
			this.saida.println("Resultado do comando c2 e "+numeroMagico+", "+numeroMagico2);
			
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			this.saida.println("Timeout na execucao do comando c2");
			this.futureWS.cancel(true);
			this.futureBD.cancel(true);
		}
		return null;
	}

}
