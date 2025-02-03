package com.geeksforgeeks.socket.program;
import java.io.*;
import java.net.*;

public class Client {

	private Socket s = null;
	private DataInputStream in = null;
	private DataOutputStream out = null;
	private BufferedReader d = null;
	
	public Client(String addr, int port) {
		
		try {
			s = new Socket(addr, port);
			System.out.println("Connected");
			
			in = new DataInputStream(System.in);
			
			out = new DataOutputStream(s.getOutputStream());
		}
		catch(UnknownHostException u){
			System.out.println(u);
			return;
			
		}
		catch(IOException i){
			System.out.println(i);
			return;
		}
		
		//Message to read
		String message = "";
		
		//Type Over to end connection
		while (!message.equals("Over")){
			try {
				//Read from InputStream terminal
				d = new BufferedReader(new InputStreamReader(in));
				message = d.readLine();
				//Output Message to OutputStream
				out.writeUTF(message);
			}
			catch(IOException i){
				System.out.println(i);
				return;
			}
		}
		
		//Closing connection
		try {
			in.close();
			d.close();
			out.close();
			s.close();
		}
		catch(IOException i) {
			System.out.println(i);
			return;
		}
	}
	public static void main(String[] args) {
		Client c1 = new Client("127.0.0.1", 5000);
		
	}

}
