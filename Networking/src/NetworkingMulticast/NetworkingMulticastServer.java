package NetworkingMulticast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class NetworkingMulticastServer {
	public static void main(String[] args) throws IOException {
		int portNumber = 1236;
		MulticastSocket serverMulticastSocket = new MulticastSocket(portNumber);
		System.out.println("Multicast is created");
		InetAddress group = InetAddress.getByName("224.0.0.1");
		serverMulticastSocket.joinGroup(group);
		System.out.println("joinGroup method is called...");
		while (true) {
			byte buf[] = new byte[1024];
			DatagramPacket dataa = new DatagramPacket(buf, buf.length);
			serverMulticastSocket.receive(dataa);
			String msg = new String(dataa.getData()).trim();
			System.out.println("Message received from client = " + msg);
			//------------------------------------------------------------
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			String message = br.readLine();
//			System.out.println(message);
//
//			// Send the message to Multicast address
//			DatagramPacket dataa1 = new DatagramPacket(message.getBytes(), 0, message.length(), group, portNumber);
//			serverMulticastSocket.send(dataa1);
//			System.out.println(dataa1+"seneded to client");
		}

	}
}
