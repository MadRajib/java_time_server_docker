import java.io.*;
import java.net.*;
import java.util.Date;

public class SimpleTimeServer {
	public static void main(String[]  args) {
		System.out.println("Simple Time Server");

		try (ServerSocket serverSocket = new ServerSocket(6000)){
			System.out.println("Waiting for connection…..");

			while(true) {
				try (Socket clientSocket = serverSocket.accept()) {
					System.out.println("Connected to client");
					Date today = new Date();
                			String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                			clientSocket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
				}
				
			}

		} catch (IOException ex) {
			// Handle exceptions
		}
	}
}
