package br.com.thread.servidor;

import java.util.concurrent.ThreadFactory;

public class FabricaDeThreads implements ThreadFactory {

	private int numeros;

	@Override
	public Thread newThread(Runnable runnable) {
		Thread thread = new Thread(runnable, "ThreadServidorTarefas " + ++numeros);
		thread.setUncaughtExceptionHandler(new TratadorExcecao());
		return thread;
	}

}
