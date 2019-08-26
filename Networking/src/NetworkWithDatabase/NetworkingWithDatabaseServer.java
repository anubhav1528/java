package NetworkWithDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.Employee;

public class NetworkingWithDatabaseServer {
	public static void main(String[] args) throws SQLException {

		ServerSocket server = null;
		Socket client;

		// Default port number we are going to use
	    int  portnumber = 1235;
		int result;
		EmployeeDao service = new EmployeeDaoImpl();

		// Create Server side socket
		try {
			server = new ServerSocket(portnumber);
		} catch (IOException ie) {
			System.out.println("Cannot open socket." + ie);
			System.exit(1);
		}
		System.out.println("ServerSocket is created " + server);

		// Wait for the data from the client and reply
		while (true) {

			try {

				// Listens for a connection to be made to
				// this socket and accepts it. The method blocks until
				// a connection is made
				System.out.println("Waiting for connect request...");
				client = server.accept();

				System.out.println("Connect request is accepted...");
				String clientHost = client.getInetAddress().getHostAddress();
				int clientPort = client.getPort();
				System.out.println("Client host = " + clientHost + " Client port = " + clientPort);

				// Read data from the client
				InputStream clientIn = client.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
				OutputStream clientOut = client.getOutputStream();
              PrintWriter pw = new PrintWriter(clientOut, true);
				//                String msgFromClient = br.readLine();
//                System.out.println("Number received from client = " + msgFromClient);
//                
//                // Send response to the client
//                if (msgFromClient != null && !msgFromClient.equalsIgnoreCase("bye")) {
//                   System.out.println("in this");
//                	OutputStream clientOut = client.getOutputStream();
//                    PrintWriter pw = new PrintWriter(clientOut, true);
//                    int fact=Integer.parseInt(msgFromClient);
//                    System.out.println(fact);
//                     result=1;
//                    for(int i=fact;i>1;i--) {
//                    	result=result*(i);
//                    }
//                    System.out.println(result);
//                    pw.println(result);
//                    
//                }

				// Close sockets
				// if (msgFromClient != null && msgFromClient.equalsIgnoreCase("bye")) {
                String EmpId =br.readLine();
                Employee empObj = service.getEmployeeById(Integer.parseInt(EmpId));
                pw.println(empObj.toString());
                
				server.close();
				server.close();
				break;
				// }

			} catch (IOException ie) {
			}
		}
	}
}
