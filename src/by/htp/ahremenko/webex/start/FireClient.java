package by.htp.ahremenko.webex.start;

import java.io.IOException;

import by.htp.ahremenko.webex.controller.ClientController;

public class FireClient {
	
	public static void main(String[] args) {
		try {
			//ClientController client  = new ClientController ("10.57.24.67", 1235);			
			//ClientController client  = new ClientController ("192.168.0.8", 1235);

			ClientController client  = new ClientController ("10.0.1.39", 1235);
			client.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
		
}
