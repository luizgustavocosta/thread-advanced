package br.com.thread.cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {

	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("localhost", 12345);

		System.out.println("Conexao Estabelecida");

		Thread threadEnviarComando = new Thread(() -> {
			PrintStream saida = null;
			try {
				saida = new PrintStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}

			Scanner teclado = new Scanner(System.in);

			while (teclado.hasNext()){
				String linha = teclado.nextLine();
				if (linha.trim().equals(""))
					break;
				saida.println(linha);
			}
			saida.close();
			teclado.close();
		});
		
		Thread threadRespostaServidor = new Thread(() -> {
			System.out.println("Resposta do servidor");
			Scanner respostaServidor;
			try {
				respostaServidor = new Scanner(socket.getInputStream());
				while(respostaServidor.hasNextLine()){
					String linha = respostaServidor.nextLine();
					System.out.println(linha);
				}
				respostaServidor.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		threadEnviarComando.start();
		threadRespostaServidor.start();
		
		// Thread main, deve esperar a execucao da threadEnviarComando, atraves do
		// threadEnviarComando.join()
		threadEnviarComando.join();
		
		socket.close();
	}

}
