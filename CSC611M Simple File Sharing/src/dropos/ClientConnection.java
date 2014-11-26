package dropos;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientConnection extends Thread {

	private Socket connectionSocket;
	private Scanner in;
	public PrintWriter out;
	private String ipAddress;

	public ClientConnection(Socket connectionSocket) {
		this.connectionSocket = connectionSocket;
		this.ipAddress = connectionSocket.getInetAddress().toString()
				.substring(1);

		// TODO Auto-generated constructor stub

		System.out.println("[SYSTEM] SERVER just connected to CLIENT with IP:"
				+ connectionSocket.getInetAddress().toString());

		try {
			DataInputStream din = new DataInputStream(
					connectionSocket.getInputStream());
			BufferedInputStream bin = new BufferedInputStream(din);
			in = new Scanner(bin);

			DataOutputStream dout = new DataOutputStream(
					connectionSocket.getOutputStream());
			out = new PrintWriter(dout);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		do {
			String input = null;
			// As long as you are sending me messages, handle them correctly
			while ((input = in.nextLine()).equals(null) == false) {
				handleInput(input);
			}
		} while (true);

	}

	private void handleInput(String input) {
		String command = input.split(" ")[0];
		String params = input.substring(command.length());

		System.out.println("Command: " + command);
		System.out.println("Params: " + params);
		switch (command) {
		case "ADD":
			break;
		case "MODIFY":
			break;
		case "DELETE":
			break;
		}
	}

	public String getIPAddress() {
		return ipAddress;
	}
}
