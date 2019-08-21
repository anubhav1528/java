package sampleJframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;

import model.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JFRAME {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private EmployeeService service;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFRAME window = new JFRAME();
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
	public JFRAME() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		try {
			service = new EmployeeServiceImpl();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JLabel myname = new JLabel("ID");
		myname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		myname.setBounds(22, 32, 77, 21);
		frame.getContentPane().add(myname);

		JLabel lblPassword = new JLabel("FirstName");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(22, 64, 77, 28);
		frame.getContentPane().add(lblPassword);

		textField = new JTextField();
		textField.setBounds(123, 34, 145, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(123, 70, 145, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnLogin = new JButton("ADD");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service.createEmployee(
						new Employee(Integer.parseInt(textField.getText().toString()), textField_1.getText().toString(),
								textField_2.getText().toString(), textField_3.getText().toString()));
				JOptionPane.showMessageDialog(btnLogin, "EMPLOYEE ADDED SUCCESSFULLY");
			}
		});
		btnLogin.setBounds(22, 178, 89, 23);
		frame.getContentPane().add(btnLogin);

		JLabel lblLastname = new JLabel("LastName");
		lblLastname.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblLastname.setBounds(22, 108, 77, 14);
		frame.getContentPane().add(lblLastname);

		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(22, 141, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		textField_2 = new JTextField();
		textField_2.setBounds(123, 107, 145, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(123, 140, 145, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ADD OR UPDATE EMPLOYEE ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(22, 11, 214, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblDeleteEmployee = new JLabel("DELETE OR SEARCH  EMPLOYEE");
		lblDeleteEmployee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDeleteEmployee.setBounds(22, 214, 224, 14);
		frame.getContentPane().add(lblDeleteEmployee);

		textField_4 = new JTextField();
		textField_4.setBounds(123, 239, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(22, 242, 16, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JButton btndeleteButton = new JButton("DELETE");
		btndeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int check = service.deleteEmployee(Integer.parseInt(textField_4.getText().toString()));
					if (check == 0) {
						JOptionPane.showMessageDialog(btndeleteButton, "ID IS NOT THERE IN THE DATABAS");
					} else {
						JOptionPane.showMessageDialog(btndeleteButton, "EMPLOYEE DELETED SUCCESSFULLY");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btndeleteButton, "ID IS NOT THERE IN THE DATABASE");
				}
			}
		});
		btndeleteButton.setBounds(22, 287, 89, 23);
		frame.getContentPane().add(btndeleteButton);

		JButton btnUpupdate = new JButton("FIND");
		btnUpupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Employee empobj = service.getEmployeeById(Integer.parseInt(textField_4.getText().toString()));
					textField.setText("" + empobj.getId() + "");
					textField_1.setText(empobj.getFirstName());
					textField_2.setText(empobj.getLastName());
					textField_3.setText(empobj.getEmail());
				} catch (Exception e1) {
					// TODO Auto-generated catch block

					JOptionPane.showMessageDialog(btnUpupdate, "ID IS NOT THERE IN THE DATABASE");
				}

			}
		});
		btnUpupdate.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnUpupdate.setBounds(138, 287, 89, 23);
		frame.getContentPane().add(btnUpupdate);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = service.updateEmployee(
						new Employee(Integer.parseInt(textField.getText().toString()), textField_1.getText().toString(),
								textField_2.getText().toString(), textField_3.getText().toString()));
				if (result == 0) {
					JOptionPane.showMessageDialog(btnUpdate, "NO ROW UPDATED");
				} else {
					JOptionPane.showMessageDialog(btnUpupdate, "EMPLOYEE UPDATED SUCCESSFULLY");
				}
			}
		});
		btnUpdate.setBounds(123, 178, 89, 23);
		frame.getContentPane().add(btnUpdate);
	}
}
