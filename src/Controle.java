package chatJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Controle extends Thread {

	private Socket cliente;
	private String nomeCliente;

	// Um objeto controle para cada cliente
	public Controle(Socket cliente) {
		this.cliente = cliente;
		start();
	}

	@Override
	public void run() {
		try {
			// Faz a leitura
			BufferedReader reader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			// Escreve
			PrintWriter writer = new PrintWriter(cliente.getOutputStream());
			writer.println("Por favor escreva seu nome");
			String msg = reader.readLine();
			this.nomeCliente = msg;

			while (true) {
				msg = reader.readLine();
				writer.println(this.nomeCliente + " diz: " + msg);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
