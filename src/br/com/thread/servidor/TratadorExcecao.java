package br.com.thread.servidor;

import java.lang.Thread.UncaughtExceptionHandler;

public class TratadorExcecao implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread thread, Throwable throwable) {
		System.out.println("Deu excecao na thread .:"+thread.getName() +", mensagem .:"+ throwable.getMessage());
	}

}
