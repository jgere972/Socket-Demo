package com.geeksforgeeks.socket.program;
import java.io.*;
import java.net.*;

public class Server {
	//Initialize sockets and data streams
	private Socket s = null;
	private ServerSocket ss = null;
	private DataInputStream in = null;
	
	public Server(int port) {
		
		//Start Server and establish connection to Client
		try {
			//Start Server
			ss = new ServerSocket(port);
			System.out.println("Server started");
			
			System.out.println("Waiting for a client ...");
			
			s = ss.accept();
			System.out.println("Client accepted");
			
			in = new DataInputStream(new BufferedInputStream(s.getInputStream()));
			
			String message = "";
			
			while (!message.equals("Over")) {
				try {
					message = in.readUTF();
					System.out.println(message);
				}
				catch(IOException i) {
					System.out.println(i);
				}
			}
			System.out.println("Closing connection");

            // Close connection
            s.close();
            in.close();
		}		
		catch(IOException i) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		Server s1 = new Server(5000); 
	}

}
