package chatJava;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private final int port;

	public Server(int port) {
		this.port = port;
	}

	public void start() throws IOException {
		ServerSocket server = null;
		try {
			System.out.println("Servidor sendo iniciado em: " + "0.0.0.0:" + this.port);
			server = new ServerSocket(5678);

			while (true) {
				Socket cliente = server.accept(); // A cada conexão será feito um novo socket
				new Controle(cliente);
			}

		} catch (IOException e) {

			System.out.println("Servidor com problemas");
			System.out.println(e.getMessage());
			server.close();
		}
	}
}
