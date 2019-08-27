package NetworkWithDatabase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Employee;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class NetworkingWithDatabaseClient {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	static Socket client = null;
	static int portnumber = 1235;
	static String getEmpId;
	Employee employeeobj = new Employee();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NetworkingWithDatabaseClient window = new NetworkingWithDatabaseClient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	/**
	 * Create the application.
	 */
	public NetworkingWithDatabaseClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 11, 98, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				getEmpId = textField.getText();
				try {
					client = new Socket(InetAddress.getLocalHost(), portnumber);
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				System.out.println("Client socket is created " + client);

				// Create an output stream of the client socket
				OutputStream clientOut = null;
				try {
					clientOut = client.getOutputStream();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PrintWriter pw = new PrintWriter(clientOut, true);

				// Create an input stream of the client socket
				InputStream clientIn = null;
				try {
					clientIn = client.getInputStream();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));

				// Create BufferedReader for a standard input
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
				pw.println(getEmpId);
				try {

					try {
						String rawString = br.readLine();
						Employee emp = employeeobj.getObject(rawString);
						DefaultTableModel model = new DefaultTableModel();
						model.addColumn("ID");
						model.addColumn("First Name");
						model.addColumn("Last Name");
						model.addColumn("Email");
						JTable table = new JTable(model);
						table.setBounds(10, 101, 400, 76);
						frame.getContentPane().add(table);
						model = (DefaultTableModel) table.getModel();
						model.addRow(new Object[] { "ID", "First Name", "Last Name", "Email" });
						model.addRow(
								new Object[] { emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail() });

					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		btnNewButton.setBounds(10, 53, 89, 23);
		frame.getContentPane().add(btnNewButton);

	}
}
