package NetworkingMulticast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class NetworkingMulitcastClient {
	public static void main(String[] args) throws IOException {
		int portnumber = 1236;

		// Create a MulticastSocket
		MulticastSocket chatMulticastSocket = new MulticastSocket(portnumber);

		// Determine the IP address of a host, given the host name
		InetAddress group = InetAddress.getByName("224.0.0.1");

		// Joins a multicast group
		chatMulticastSocket.joinGroup(group);
		while (true) {
			String msg = "";
			System.out.println("Type a message for the server:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			msg = br.readLine();

			// Send the message to Multicast address
			DatagramPacket data = new DatagramPacket(msg.getBytes(), 0, msg.length(), group, portnumber);
			chatMulticastSocket.send(data);
			// ----------------------------------------------------------
			byte buffer[] = new byte[1024];
			DatagramPacket data1 = new DatagramPacket(buffer, buffer.length);
			chatMulticastSocket.receive(data1);
			String message = new String(data1.getData()).trim();
			System.out.println("Message received from server = " + message);
		}
	}
}
