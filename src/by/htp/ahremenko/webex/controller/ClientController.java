package by.htp.ahremenko.webex.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientController {
	private String netAress;
	private int port;
	private Socket socket;
	
	public ClientController (String netAddress, int port) throws IOException {
		InetAddress inetAddress = InetAddress.getByName(netAddress);
		// this.socket = new Socket( "127.0.0.1", port);  // You may open the socket by this way
		this.socket = new Socket( inetAddress, port);
	}
	
	public void start() throws IOException {
		try {
			System.out.println("[Client] got a connection");
			
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
				
			DataInputStream dataIn = new DataInputStream (in);
			DataOutputStream dataOut = new DataOutputStream(out);
			String response;
						
			String request  = "add 2 5";
			dataOut.writeUTF(request);
			dataOut.flush();  // push all from buffer 
			System.out.println("[Client] sent request and he is waiting for response..");
			try {
				response = dataIn.readUTF();
				System.out.println("[Client] Server sent a response: " + response);
			} catch (EOFException e) {
				System.out.println("[Client] gets NULL answer.");
			}
			
			request  = "minus 50 23";
			dataOut.writeUTF(request); 
			dataOut.flush();  // push all from buffer 
			System.out.println("[Client] sent request 2. It is waiting for response...)");
			try {
				response = dataIn.readUTF();
				System.out.println("[Client] Server sent a response 2: " + response);
			} catch (EOFException e) {
				System.out.println("[Client] gets NULL answer.");
			}
			
			
		} finally {
			socket.close();
		}
	}
}
